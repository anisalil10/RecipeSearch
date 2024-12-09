package Main.entity;

import java.util.List;

/**
 * Audience:
 * Developers working on recipe-related features and functionalities in the application.
 * They need to manage and retrieve global statistics about the most popular recipes.

 * Context:
 * The GlobalStats class is used to store and access a list of the most popular recipes
 * across the application, determined by user activity such as favoriting recipes.

 * Content:
 * This class contains a single field, `toprecipes`, which holds a list of Recipe objects
 * that represent the globally most popular recipes.

 * Examples:
 * Example usage:
 * GlobalStats globalStats = new GlobalStats();
 * List<Recipe> topRecipes = globalStats.toprecipes;

 * Use Cases:
 * - Retrieving a list of recipes to display on the "Most Popular Recipes" page.
 * - Updating global statistics when a recipe becomes more popular.
 */
public class GlobalStats {

    /**
     * A list of the top recipes globally.
     * These recipes are sorted based on their popularity (e.g., number of favorites).
     */
    private List<Recipe> toprecipes;
}
