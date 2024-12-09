package entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the UserPreferences class.
 * These tests validate the proper initialization and storage of user preferences.
 */
class UserPreferencesTest {

    @Test
    void testUserPreferencesInitialization() {
        // Mock data for preferences
        List<String> cuisines = List.of("Italian", "Mexican");
        List<String> restrictions = List.of("Vegetarian", "Gluten-Free");
        List<Ingredient> exclusions = List.of(new Ingredient(), new Ingredient());

        // Create a UserPreferences object
        UserPreferences prefs = new UserPreferences(cuisines, restrictions, exclusions);

        // Verify that the fields are initialized correctly
        assertEquals(cuisines, prefs.cuisinepreferences, "Cuisine preferences should match the input value.");
        assertEquals(restrictions, prefs.dietaryrestrictions, "Dietary restrictions should match the input value.");
        assertEquals(exclusions, prefs.excludedingredients, "Excluded ingredients should match the input value.");
    }

    @Test
    void testEmptyPreferences() {
        // Create a UserPreferences object with empty lists
        UserPreferences prefs = new UserPreferences(List.of(), List.of(), List.of());

        // Verify that the fields are empty
        assertTrue(prefs.cuisinepreferences.isEmpty(), "Cuisine preferences should be empty.");
        assertTrue(prefs.dietaryrestrictions.isEmpty(), "Dietary restrictions should be empty.");
        assertTrue(prefs.excludedingredients.isEmpty(), "Excluded ingredients should be empty.");
    }
}
