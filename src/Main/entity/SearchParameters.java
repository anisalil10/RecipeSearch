package entity;

/**
 * A representation of the search parameters entered by a user.
 */
public class SearchParameters {

    private final String query;
    private final String cuisineType;
    private final String mealType;
    private final String diet;
    private final int maxResults;

    public SearchParameters(String query, String cuisineType, String mealType, String diet, int maxResults) {
        this.query = query;
        this.cuisineType = cuisineType;
        this.mealType = mealType;
        this.diet = diet;
        this.maxResults = maxResults;
    }

    /**
     * @return a string representing a search query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @return a string representing the preferred cuisine.
     */
    public String getCuisineType() {
        return cuisineType;
    }

    /**
     * @return a string representing the preferred mealType
     */
    public String getMealType() {
        return mealType;
    }

    /**
     * @return a string representing the user's diet
     */
    public String getDiet() {
        return diet;
    }

    /**
     * @return an int representing the maximum search results to be displayed.
     */
    public int getMaxResults() {
        return maxResults;
    }
}
