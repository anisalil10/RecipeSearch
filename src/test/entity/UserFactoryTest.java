package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the UserFactory class.
 * These tests verify the correct creation of User objects through the factory method.
 */
class UserFactoryTest {

    @Test
    void testCreateUser() {
        // Create a UserFactory instance
        UserFactory factory = new UserFactory();

        // Use the factory to create a User object
        User user = factory.create("john_doe", "password123", "Vegetarian");

        // Verify the User object is created with the correct attributes
        assertEquals("john_doe", user.getUsername(), "Username should match the input value.");
        assertEquals("password123", user.getPassword(), "Password should match the input value.");
        assertEquals("Vegetarian", user.getUserpreferences(), "User preferences should match the input value.");
        assertTrue(user.getFavouriterecipes().isEmpty(), "Favorites list should be initialized as empty.");
    }

    @Test
    void testMultipleUserCreation() {
        // Create a UserFactory instance
        UserFactory factory = new UserFactory();

        // Create multiple User objects
        User user1 = factory.create("jane_doe", "securepass", "Vegan");
        User user2 = factory.create("sam_doe", "pass123", "Keto");

        // Verify the attributes of each user
        assertEquals("jane_doe", user1.getUsername(), "User1's username should match the input value.");
        assertEquals("securepass", user1.getPassword(), "User1's password should match the input value.");
        assertEquals("Vegan", user1.getUserpreferences(), "User1's preferences should match the input value.");

        assertEquals("sam_doe", user2.getUsername(), "User2's username should match the input value.");
        assertEquals("pass123", user2.getPassword(), "User2's password should match the input value.");
        assertEquals("Keto", user2.getUserpreferences(), "User2's preferences should match the input value.");
    }
}
