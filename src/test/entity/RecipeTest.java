package entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the Recipe class.
 * These tests verify the functionality of recipe attributes and methods.
 */
class RecipeTest {

    @Test
    void testRecipeInitialization() {
        // Create a Recipe object
        Recipe recipe = new Recipe("1", "Pasta", "Italian", "Dinner", List.of("Tomato", "Basil"), 400);

        // Verify the attributes
        assertEquals("1", recipe.getRecipeID());
        assertEquals("Pasta", recipe.getName());
        assertEquals("Italian", recipe.getCuisine());
        assertEquals("Dinner", recipe.getMealType());
        assertEquals(400, recipe.getCalories());
        assertEquals(0, recipe.getFavourties());
        assertEquals(List.of("Tomato", "Basil"), recipe.getIngredients());
    }

    @Test
    void testSetAndGetFavourites() {
        Recipe recipe = new Recipe("1", "Pasta", "Italian", "Dinner", List.of("Tomato", "Basil"), 400);

        // Update favorites and verify
        recipe.setFavourties(10);
        assertEquals(10, recipe.getFavourties());
    }

    @Test
    void testGetIngredientsToString() {
        Recipe recipe = new Recipe("1", "Pasta", "Italian", "Dinner", List.of("Tomato", "Basil"), 400);

        // Verify the formatted ingredients string
        String expected = "Tomato\nBasil\n";
        assertEquals(expected, recipe.getIngredientsToString());
    }

    @Test
    void testCompareRecipes() {
        Recipe recipe1 = new Recipe("1", "Pasta", "Italian", "Dinner", List.of("Tomato", "Basil"), 400);
        Recipe recipe2 = new Recipe("2", "Pizza", "Italian", "Lunch", List.of("Cheese", "Tomato"), 800);

        // Set favorites
        recipe1.setFavourties(5);
        recipe2.setFavourties(10);

        // Compare recipes
        assertTrue(new Recipe().compare(recipe1, recipe2) < 0);
        assertTrue(new Recipe().compare(recipe2, recipe1) > 0);
        assertEquals(0, new Recipe().compare(recipe1, recipe1));
    }
}
