package Main.entity;

/**
 * Audience:
 * Developers managing unique identifiers for recipes, particularly for distinguishing
 * recipes in databases or API interactions.

 * Context:
 * The RecipeId class represents a unique identifier for a recipe. This identifier
 * ensures that each recipe can be referenced or retrieved uniquely.

 * Content:
 * This class contains a single field, `recipeId`, representing the unique identifier,
 * along with a constructor and a getter method.

 * Examples:
 * Example usage:
 * RecipeId id = new RecipeId("12345");
 * String recipeId = id.getRecipeId(); // Returns "12345"

 * Use Cases:
 * - Associating a unique identifier with a recipe for storage or retrieval.
 * - Passing the recipe ID as a parameter in API requests.
 */
public class RecipeId {

    /**
     * The unique identifier for a recipe.
     */
    private String recipeId;

    /**
     * Constructs a RecipeId object with the specified identifier.
     *
     * @param recipeId The unique identifier for the recipe.
     */
    public RecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * Retrieves the recipe ID.
     *
     * @return The unique identifier for the recipe.
     */
    public String getRecipeId() {
        return recipeId;
    }
}
