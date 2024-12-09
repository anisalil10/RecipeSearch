package entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    @Test
    void testFilterInitialization() {
        // Create a filter object
        Filter filter = new Filter();

        // Check that all fields are initialized to null or empty as expected
        assertNull(filter.getCategory());
        assertNull(filter.getLabel());
        assertNull(filter.getCuisine());
        assertNull(filter.getMealtime());
        assertNull(filter.getIngredientInclusion());
    }

    @Test
    void testSettersAndGetters() {
        // Create a filter object
        Filter filter = new Filter();

        // Set values for the filter
        filter.setCategory("Diet");
        filter.setLabel("Vegetarian");
        filter.setCuisine("Italian");
        filter.setMealtime("Dinner");
        filter.setIngredientInclusion(List.of("Tomato", "Basil"));

        // Verify that the getter methods return the correct values
        assertEquals("Diet", filter.getCategory());
        assertEquals("Vegetarian", filter.getLabel());
        assertEquals("Italian", filter.getCuisine());
        assertEquals("Dinner", filter.getMealtime());
        assertEquals(List.of("Tomato", "Basil"), filter.getIngredientInclusion());
    }

    @Test
    void testIngredientInclusion() {
        // Create a filter with ingredients
        Filter filter = new Filter();
        filter.setIngredientInclusion(List.of("Chicken", "Garlic"));

        // Verify the ingredient list
        List<String> ingredients = filter.getIngredientInclusion();
        assertNotNull(ingredients);
        assertTrue(ingredients.contains("Chicken"));
        assertTrue(ingredients.contains("Garlic"));
    }
}
