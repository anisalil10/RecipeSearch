package entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the Ingredient class.
 * These tests verify that the `ingredients` field initializes correctly and can be assigned values.
 */
class IngredientTest {

    @Test
    void testIngredientInitialization() {
        // Create an Ingredient object
        Ingredient ingredient = new Ingredient();

        // Verify the ingredients list is initially null
        assertNull(ingredient.ingredients, "Ingredients list should be null upon initialization.");
    }

    @Test
    void testSetIngredients() {
        // Create an Ingredient object
        Ingredient ingredient = new Ingredient();

        // Mock a list of Ingredient objects
        Ingredient subIngredient1 = new Ingredient();
        Ingredient subIngredient2 = new Ingredient();
        List<Ingredient> subIngredients = List.of(subIngredient1, subIngredient2);

        // Directly assign to the field for testing
        ingredient.ingredients = subIngredients;

        // Verify the ingredients list
        assertNotNull(ingredient.ingredients, "Ingredients list should not be null after assignment.");
        assertEquals(2, ingredient.ingredients.size(), "Ingredients list should contain two sub-ingredients.");
    }
}
