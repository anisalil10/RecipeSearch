package Main.use_cases.get_search_parameters;

import Main.entity.Recipe;

public class GetSearchParametersInputData {
    private String query;
    private String cuisineType;
    private String mealType;
    private String diet;
    private final int maxResults = 10;
    private String username;
    private Recipe recipe;


    public GetSearchParametersInputData(String query, String cuisineType, String mealType, String diet) {
        this.query = query;
        this.cuisineType = cuisineType;
        this.mealType = mealType;
        this.diet = diet;
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
