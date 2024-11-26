package Main.interface_adapter.fetch_recipes;

import Main.entity.Recipe;
import Main.entity.SearchParameters;

import java.util.List;

public class FetchRecipesState {
    private SearchParameters searchParameters;
    private List<Recipe> recipeList;
    private String recipeError;

    public SearchParameters getSearchParameters() {return getSearchParameters(); }

    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    @Override
    public String toString() {
        int count = 1;
        StringBuilder result = new StringBuilder();
        result.append("Recipe List:" + '\'');
        for (Recipe recipe : recipeList) {
            result.append(count + ". " + recipe.getName() + '\'' + recipe.getCuisine() + '\'' + recipe.getCalories());
            count += 1;
        }

        return result.toString();
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
}
