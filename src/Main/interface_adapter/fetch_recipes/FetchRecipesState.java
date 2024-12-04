package Main.interface_adapter.fetch_recipes;

import Main.entity.Recipe;
import Main.entity.SearchParameters;

import java.util.List;

public class FetchRecipesState {
    private SearchParameters searchParameters;
    private String username;

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    private List<Recipe> recipeList;
    private String recipeError;

    public SearchParameters getSearchParameters() {return searchParameters; }

    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    public String getRecipeError() {
        return recipeError;
    }

    public void setRecipeError(String recipeError) {
        this.recipeError = recipeError;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
