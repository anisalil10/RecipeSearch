package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the RecipeId class.
 * These tests verify the functionality of the RecipeId class.
 */
class RecipeIdTest {

    @Test
    void testRecipeIdInitialization() {
        // Create a RecipeId object
        RecipeId recipeId = new RecipeId("12345");

        // Verify that the recipe ID is correctly initialized
        assertEquals("12345", recipeId.getRecipeId(), "The recipe ID should match the input value.");
    }

    @Test
    void testGetRecipeId() {
        // Create a RecipeId object
        RecipeId recipeId = new RecipeId("67890");

        // Verify the getter method returns the correct ID
        assertEquals("67890", recipeId.getRecipeId(), "The recipe ID should be retrievable.");
    }
}
