package entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the User class.
 * These tests verify the functionality of managing user profiles and favorite recipes.
 */
class UserTest {

    @Test
    void testUserInitialization() {
        // Create a User object
        User user = new User("john_doe", "password123", "Vegetarian");

        // Verify that the user details are correctly initialized
        assertEquals("john_doe", user.getUsername(), "Username should match the input value.");
        assertEquals("password123", user.getPassword(), "Password should match the input value.");
        assertEquals("Vegetarian", user.getUserpreferences(), "Preferences should match the input value.");
        assertTrue(user.getFavouriterecipes().isEmpty(), "Favorites list should be empty upon initialization.");
    }

    @Test
    void testAddToFavorites() {
        // Create a User object
        User user = new User("jane_doe", "securepass", "Vegan");

        // Add recipes to favorites
        user.addtofavourites("recipe1");
        user.addtofavourites("recipe2");

        // Verify that the recipes are added to the favorites list
        List<String> favourites = user.getFavouriterecipes();
        assertEquals(2, favourites.size(), "Favorites list should contain 2 recipes.");
        assertTrue(favourites.contains("recipe1"), "Favorites list should contain 'recipe1'.");
        assertTrue(favourites.contains("recipe2"), "Favorites list should contain 'recipe2'.");
    }

    @Test
    void testSetFavoriteRecipes() {
        // Create a User object
        User user = new User("sam_doe", "pass123", "Keto");

        // Set a list of favorite recipes
        List<String> recipes = List.of("recipe3", "recipe4");
        user.setFavouriterecipes(recipes);

        // Verify that the favorites list is updated
        assertEquals(recipes, user.getFavouriterecipes(), "Favorites list should match the new list.");
    }
}
