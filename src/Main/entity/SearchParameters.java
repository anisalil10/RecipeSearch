package Main.entity;

/**
 * Audience:
 * Developers building and managing recipe search functionalities, including filtering
 * results based on user preferences and constraints.

 * Context:
 * The SearchParameters class encapsulates the parameters used in a recipe search query.
 * These parameters include keywords, cuisine type, meal type, dietary restrictions, and the maximum
 * number of results to retrieve.

 * Content:
 * This class includes fields for the query, cuisine type, meal type, diet, and max results.
 * It provides a constructor to initialize these fields and getter methods for retrieval.

 * Examples:
 * Example usage:
 * SearchParameters params = new SearchParameters("Pasta", "Italian", "Dinner", "Vegetarian", 10);
 * String cuisine = params.getCuisineType(); // Returns "Italian"

 * Use Cases:
 * - Defining search queries for recipe searches.
 * - Passing search parameters to APIs or data access layers.
 * - Storing user-defined search criteria for reuse.
 */
public class SearchParameters {

    /**
     * The search query string entered by the user.
     */
    private final String query;

    /**
     * The type of cuisine (e.g., "Italian", "Asian").
     */
    private final String cuisineType;

    /**
     * The meal type (e.g., "Breakfast", "Dinner").
     */
    private final String mealType;

    /**
     * The dietary restrictions applied to the search (e.g., "Vegetarian").
     */
    private final String diet;

    /**
     * The maximum number of results to return for the search query.
     */
    private final int maxResults;

    /**
     * Constructs a SearchParameters object with the given search parameters.
     *
     * @param query       The search query string.
     * @param cuisineType The type of cuisine for the search.
     * @param mealType    The type of meal for the search.
     * @param diet        The dietary restrictions applied to the search.
     * @param maxResults  The maximum number of results to return.
     */
    public SearchParameters(String query, String cuisineType, String mealType, String diet, int maxResults) {
        this.query = query;
        this.cuisineType = cuisineType;
        this.mealType = mealType;
        this.diet = diet;
        this.maxResults = maxResults;
    }

    // Getter Methods

    /**
     * Retrieves the search query string.
     *
     * @return The search query.
     */
    public String getQuery() {
        return query;
    }

    /**
     * Retrieves the cuisine type.
     *
     * @return The cuisine type.
     */
    public String getCuisineType() {
        return cuisineType;
    }

    /**
     * Retrieves the meal type.
     *
     * @return The meal type.
     */
    public String getMealType() {
        return mealType;
    }

    /**
     * Retrieves the dietary restrictions.
     *
     * @return The dietary restrictions.
     */
    public String getDiet() {
        return diet;
    }

    /**
     * Retrieves the maximum number of results to return.
     *
     * @return The maximum number of results.
     */
    public int getMaxResults() {
        return maxResults;
    }
}
