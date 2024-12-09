package use_cases.get_search_parameters;

import entity.Recipe;
import entity.SearchParameters;

import java.util.List;

public interface GetSearchParametersDataAccess {

    public List<Recipe> getRecipes(SearchParameters searchParameters);

    public boolean recipeInFavourites(String username, String recipeId);

    public void updateFavourites(String username, String recipeId);

    public List<Recipe> getTopRecipes();
}
