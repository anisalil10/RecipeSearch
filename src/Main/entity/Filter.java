import java.util.List;

/**
 * Represents a filter applied to recipe searches.
 * A filter allows the user to narrow down search results based on specified criteria,
 * such as category, cuisine type, mealtime, and included ingredients.
 */
public class Filter {

    /**
     * The category of the filter (e.g., "diet", "health", "meal type").
     */
    private String category;

    /**
     * The specific label for the filter (e.g., "vegetarian", "low-fat").
     */
    private String label;

    /**
     * The type of cuisine the filter applies to (e.g., "Italian", "Chinese").
     */
    private String cuisine;

    /**
     * The mealtime associated with the filter (e.g., "Breakfast", "Dinner").
     */
    private String mealtime;

    /**
     * A list of ingredients to include in the filtered recipes.
     */
    private List<String> IngredientInclusion;

    // Add getter and setter methods for the fields, if needed.
}
