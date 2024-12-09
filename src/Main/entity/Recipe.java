package Main.entity;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

/**
 * Audience:
 * Developers handling recipes and their attributes, such as when searching, filtering,
 * or displaying recipes in the application.

 * Context:
 * The Recipe class represents a recipe object with key details such as name, cuisine,
 * meal type, ingredients, and popularity metrics.

 * Content:
 * This class encapsulates recipe information and implements the Comparator interface
 * for comparing recipes based on their popularity (number of favorites).

 * Examples:
 * Example usage:
 * Recipe recipe = new Recipe("1", "Pasta", "Italian", "Dinner", List.of("Tomato", "Basil"), 400);
 * String cuisine = recipe.getCuisine(); // Returns "Italian"

 * Use Cases:
 * - Displaying a list of recipes based on search results.
 * - Comparing recipes for sorting by popularity.
 * - Accessing and modifying recipe details.
 */
public class Recipe implements Comparator<Recipe> {

    /**
     * A unique identifier for the recipe.
     */
    private String recipeID;

    /**
     * The name of the recipe.
     */
    private String name;

    /**
     * The type of cuisine the recipe belongs to (e.g., "Italian").
     */
    private String cuisine;

    /**
     * The type of meal the recipe is meant for (e.g., "Dinner").
     */
    private String mealType;

    /**
     * A list of ingredients required for the recipe.
     */
    private List<String> ingredients;

    /**
     * The number of calories in the recipe.
     */
    private int calories;

    /**
     * The number of times this recipe has been marked as a favorite.
     */
    private int favourties = 0;

    /**
     * Constructs a Recipe object with the provided attributes.
     *
     * @param recipeID   Unique identifier for the recipe.
     * @param name       The name of the recipe.
     * @param cuisine    The type of cuisine (e.g., "Italian").
     * @param mealType   The type of meal (e.g., "Lunch").
     * @param ingredients List of ingredients for the recipe.
     * @param calories   The number of calories in the recipe.
     */
    public Recipe(String recipeID, String name, String cuisine, String mealType, List<String> ingredients,
                  int calories) {
        this.recipeID = recipeID;
        this.name = name;
        this.cuisine = cuisine;
        this.mealType = mealType;
        this.ingredients = ingredients;
        this.calories = calories;
    }

    // Getters and Utility Methods

    public String getRecipeID() {
        return recipeID;
    }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public int getCalories() {
        return calories;
    }

    public String getMealType() {
        return mealType;
    }

    /**
     * Returns the list of ingredients as a formatted string.
     *
     * @return A newline-separated string of ingredients.
     */
    public String getIngredientsToString() {
        StringBuilder ingredients = new StringBuilder();
        for (String ingredient : this.ingredients) {
            ingredients.append(ingredient).append("\n");
        }
        return ingredients.toString();
    }

    public int getFavourties() {
        return favourties;
    }

    public void setFavourties(int favourties) {
        this.favourties = favourties;
    }

    /**
     * Compares two Recipe objects based on their popularity (number of favorites).
     *
     * @param o1 The first Recipe to compare.
     * @param o2 The second Recipe to compare.
     * @return -1 if o1 is less popular than o2, 1 if more popular, or 0 if equal.
     */
    @Override
    public int compare(Recipe o1, Recipe o2) {
        return Integer.compare(o1.getFavourties(), o2.getFavourties());
    }
}
