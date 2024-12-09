package entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the GlobalStats class.
 * These tests verify that the `toprecipes` field can be set and accessed correctly.
 */
class GlobalStatsTest {

    @Test
    void testGlobalStatsInitialization() {
        // Create a GlobalStats object
        GlobalStats globalStats = new GlobalStats();

        // Verify that the top recipes list is initially null
        assertNull(globalStats.toprecipes, "Top recipes should be null upon initialization.");
    }

    @Test
    void testSetTopRecipes() {
        // Create a GlobalStats object
        GlobalStats globalStats = new GlobalStats();

        // Mock a list of Recipe objects
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        List<Recipe> recipes = List.of(recipe1, recipe2);

        // Directly assign to the field for testing
        globalStats.toprecipes = recipes;

        // Verify the top recipes list
        assertNotNull(globalStats.toprecipes, "Top recipes should not be null after assignment.");
        assertEquals(2, globalStats.toprecipes.size(), "Top recipes list should contain two recipes.");
    }
}
