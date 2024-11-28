package Main.use_cases.GetSearchParameters;

public class GetSearchParametersInputData {
    private String query;
    private String cuisineType;
    private String mealType;
    private String username;
    private final int maxResults = 10;


    public GetSearchParametersInputData(String query, String cuisineType, String mealType, String username) {
        this.query = query;
        this.cuisineType = cuisineType;
        this.mealType = mealType;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public int getMaxResults() {
        return maxResults;
    }
}
