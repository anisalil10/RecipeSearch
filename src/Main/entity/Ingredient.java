package Main.entity;

import java.util.List;

/**
 * Audience:
 * Developers working on recipe-related functionalities, specifically handling the
 * list of ingredients associated with a recipe.

 * Context:
 * The Ingredient class represents a collection of ingredients for a recipe.
 * Each ingredient may include detailed information such as name, quantity, and units.

 * Content:
 * This class contains a single field, `ingredients`, which stores a list of Ingredient objects.

 * Examples:
 * Example usage:
 * Ingredient ingredient = new Ingredient();
 * List<Ingredient> ingredientList = ingredient.getIngredients();

 * Use Cases:
 * - Storing a list of ingredients for a recipe object.
 * - Accessing and modifying ingredients when creating or updating a recipe.
 */
public class Ingredient {

    /**
     * A list of ingredients associated with a recipe.
     */
    private List<Ingredient> ingredients;

    /**
     * Default constructor for the Ingredient class.
     * Initializes the ingredient list to null.
     */
    public Ingredient() {
    }
}
