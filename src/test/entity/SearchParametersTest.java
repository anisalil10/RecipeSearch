package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the SearchParameters class.
 * These tests verify that the parameters are correctly initialized and accessible.
 */
class SearchParametersTest {

    @Test
    void testSearchParametersInitialization() {
        // Create a SearchParameters object
        SearchParameters params = new SearchParameters("Pasta", "Italian", "Dinner", "Vegetarian", 10);

        // Verify all fields are correctly initialized
        assertEquals("Pasta", params.getQuery(), "Query should match the input value.");
        assertEquals("Italian", params.getCuisineType(), "Cuisine type should match the input value.");
        assertEquals("Dinner", params.getMealType(), "Meal type should match the input value.");
        assertEquals("Vegetarian", params.getDiet(), "Diet should match the input value.");
        assertEquals(10, params.getMaxResults(), "Max results should match the input value.");
    }

    @Test
    void testGetQuery() {
        SearchParameters params = new SearchParameters("Soup", "Asian", "Lunch", "Vegan", 5);
        assertEquals("Soup", params.getQuery(), "Query should return 'Soup'.");
    }

    @Test
    void testGetCuisineType() {
        SearchParameters params = new SearchParameters("Burger", "American", "Snack", null, 3);
        assertEquals("American", params.getCuisineType(), "Cuisine type should return 'American'.");
    }

    @Test
    void testGetMealType() {
        SearchParameters params = new SearchParameters("Sandwich", "French", "Breakfast", "Gluten-Free", 8);
        assertEquals("Breakfast", params.getMealType(), "Meal type should return 'Breakfast'.");
    }

    @Test
    void testGetDiet() {
        SearchParameters params = new SearchParameters("Pizza", "Italian", "Dinner", "Vegetarian", 15);
        assertEquals("Vegetarian", params.getDiet(), "Diet should return 'Vegetarian'.");
    }

    @Test
    void testGetMaxResults() {
        SearchParameters params = new SearchParameters("Curry", "Indian", "Dinner", "Keto", 20);
        assertEquals(20, params.getMaxResults(), "Max results should return 20.");
    }
}
