package Main.use_cases.get_search_parameters;

import Main.entity.Recipe;
import Main.entity.SearchParameters;

import java.util.List;

public interface GetSearchParametersDataAccess {

    public List<Recipe> getRecipes(SearchParameters searchParameters);

    public boolean recipeInFavourites(String username, String recipeId);

    public void updateFavourites(String username, String recipeId);

}
