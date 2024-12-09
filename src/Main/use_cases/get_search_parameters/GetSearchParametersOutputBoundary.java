package use_cases.get_search_parameters;

import entity.Recipe;

import java.util.List;

public interface GetSearchParametersOutputBoundary {

    void prepareSuccessView(GetSearchParametersOutputData outputData);

    void prepareFailView(String errormessage);

    void openRecipe(Recipe recipe, String username);

    void addToFavouritesFail(String message);

    void addToFavouritesSuccess(String message);

    void viewPopularRecipes(String username, List<Recipe> topRecipes);

    void openfavouriteRecipes(String username);

}
