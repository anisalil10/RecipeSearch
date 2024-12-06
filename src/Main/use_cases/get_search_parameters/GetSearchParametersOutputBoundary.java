package Main.use_cases.get_search_parameters;

import Main.entity.Recipe;

public interface GetSearchParametersOutputBoundary {

    void prepareSuccessView(GetSearchParametersOutputData outputData);

    void prepareFailView(String errormessage);

    void openRecipe(Recipe recipe, String username);

    void addToFavouritesFail(String message);

    void addToFavouritesSuccess(String message);

    void viewPopularRecipes(String username);

}
