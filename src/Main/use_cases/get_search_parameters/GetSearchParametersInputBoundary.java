package use_cases.get_search_parameters;

import entity.Recipe;

import java.util.List;

public interface GetSearchParametersInputBoundary {

    void execute(GetSearchParametersInputData inputData);

    void openRecipe(Recipe recipe, String username);

    void addToFavourites(Recipe recipe, String username);

    void viewPopularRecipes(String username);

    void openFavourites(String username);

}
