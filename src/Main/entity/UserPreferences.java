package Main.entity;

import java.util.List;

/**
 * Audience:
 * Developers working with user-defined preferences for recipe searches, including filtering
 * by cuisine, dietary restrictions, and ingredients to exclude.

 * Context:
 * The UserPreferences class captures and stores user preferences that influence recipe search results.
 * It provides a structured way to handle preferred cuisines, dietary restrictions, and excluded ingredients.

 * Content:
 * This class includes fields for cuisine preferences, dietary restrictions, and ingredients to exclude.
 * It provides a constructor to initialize these fields.

 * Examples:
 * Example usage:
 * List<String> cuisines = List.of("Italian", "Mexican");
 * List<String> restrictions = List.of("Vegetarian", "Gluten-Free");
 * List<Ingredient> exclusions = List.of(new Ingredient("Peanut"), new Ingredient("Dairy"));
 * UserPreferences prefs = new UserPreferences(cuisines, restrictions, exclusions);

 * Use Cases:
 * - Filtering recipes based on user preferences.
 * - Storing preferences for personalized search results.
 * - Modifying or extending user preferences dynamically.
 */
public class UserPreferences {

    /**
     * The user's preferred cuisines (e.g., "Italian", "Mexican").
     */
    private List<String> cuisinepreferences;

    /**
     * The user's dietary restrictions (e.g., "Vegetarian", "Gluten-Free").
     */
    private List<String> dietaryrestrictions;

    /**
     * Ingredients that the user wants to exclude from recipes (e.g., "Peanuts", "Dairy").
     */
    private List<Ingredient> excludedingredients;

    /**
     * Constructs a UserPreferences object with the given preferences.
     *
     * @param cuisinepreferences A list of preferred cuisines.
     * @param dietaryrestrictions A list of dietary restrictions.
     * @param excludedingredients A list of ingredients to exclude.
     */
    public UserPreferences(List<String> cuisinepreferences, List<String> dietaryrestrictions,
                           List<Ingredient> excludedingredients) {
        this.cuisinepreferences = cuisinepreferences;
        this.dietaryrestrictions = dietaryrestrictions;
        this.excludedingredients = excludedingredients;
    }
}
