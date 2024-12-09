package data_access;

import data_access.DataAccessObject;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestAPIRecipeDataAccessObject {

    private DataAccessObject dataAccessObject;

    @BeforeEach
    void setUp() {
        dataAccessObject = new DataAccessObject();

        // Reset the test CSV files before each test
        try (FileWriter writer = new FileWriter("src/main/resources/users.csv")) {
            writer.write("testuser;testpass;null;C\n");
        } catch (IOException e) {
            fail("Failed to set up test CSV files.");
        }
    }

    @Test
    void testExistsByName_UserExists() {
        assertTrue(dataAccessObject.existsByName("testuser"));
    }

    @Test
    void testExistsByName_UserDoesNotExist() {
        assertFalse(dataAccessObject.existsByName("nonexistentuser"));
    }

    @Test
    void testSave_NewUser() {
        User newUser = new User("newuser", "newpass", "preferences");
        dataAccessObject.save(newUser);

        assertTrue(dataAccessObject.existsByName("newuser"));
    }

    @Test
    void testSave_ExistingUser() {
        User existingUser = new User("testuser", "newpass", "preferences");
        dataAccessObject.save(existingUser);

        // Should not overwrite the existing user
        User retrievedUser = dataAccessObject.finduser("testuser");
        assertEquals("testpass", retrievedUser.getPassword());
    }

    @Test
    void testFindUser_ValidUser() {
        User user = dataAccessObject.finduser("testuser");

        assertNotNull(user);
        assertEquals("testuser", user.getUsername());
        assertEquals("testpass", user.getPassword());
        assertEquals("null", user.getUserpreferences());
    }

    @Test
    void testFindUser_InvalidUser() {
        User user = dataAccessObject.finduser("nonexistentuser");

        assertNull(user);
    }

    @Test
    void testUpdateFavourites_AddNewRecipe() {
        dataAccessObject.updateFavourites("testuser", "recipe123");

        assertTrue(dataAccessObject.recipeInFavourites("testuser", "recipe123"));
    }

    @Test
    void testUpdateFavourites_AppendToExistingFavourites() {
        dataAccessObject.updateFavourites("testuser", "recipe123");
        dataAccessObject.updateFavourites("testuser", "recipe456");

        User user = dataAccessObject.finduser("testuser");
        assertTrue(dataAccessObject.recipeInFavourites("testuser", "recipe123"));
        assertTrue(dataAccessObject.recipeInFavourites("testuser", "recipe456"));
    }

    @Test
    void testGetRecipes_ValidSearchParameters() {
        // Add a test for valid API interaction (mock API call or check integration)
    }

    @Test
    void testGetRecipes_InvalidSearchParameters() {
        // Add a test for invalid API interaction (mock API call or invalid inputs)
    }
}
