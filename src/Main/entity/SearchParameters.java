package Main.entity;

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


    public String getQuery() {
        return query;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public String getMealType() {
        return mealType;
    }

    public String getDiet() {
        return diet;
    }

    public int getMaxResults() {
        return maxResults;
    }
}
