package interface_adapter.get_search_parameters;

import entity.Recipe;
import use_cases.get_search_parameters.GetSearchParametersInputBoundary;
import use_cases.get_search_parameters.GetSearchParametersInputData;

/**
 * Controller for the GetSearchParameter View.
 */
public class GetSearchParametersController {
    private final GetSearchParametersInputBoundary searchParametersInteractor;

    public GetSearchParametersController(GetSearchParametersInputBoundary searchParametersInteractor) {
        this.searchParametersInteractor = searchParametersInteractor;
    }

    /**
     * Executes the Signup Use Case.
     * @param username the username to sign up
     * @param query the search entered
     * @param cuisine the cuisine type
     * @param mealType the meal Type
     */
    public void execute(String query, String cuisine, String mealType, String username) {
        final GetSearchParametersInputData searchParametersInputData = new GetSearchParametersInputData(query, cuisine,
                mealType, username);

        searchParametersInteractor.execute(searchParametersInputData);
    }

    /**
     * Executes the openRecipe Use Case.
     * @param username the username to possible add to favourites
     * @param recipe the recipe to be viewed.
     */
    public void openRecipe(Recipe recipe, String username) {
        searchParametersInteractor.openRecipe(recipe, username);
    }

    /**
     * Executes the addToFavourites Use Case.
     * @param username the username to possibly add to favourites
     * @param recipe the recipe to be viewed.
     */
    public void addToFavourites(Recipe recipe, String username) {
        searchParametersInteractor.addToFavourites(recipe, username);
    }

    /**
     * Executes the viewPopular Use Case.
     * @param username the username to possible add to favourites when viewing recipes
     */
    public void viewPopularRecipes(String username) {
        searchParametersInteractor.viewPopularRecipes(username);}

    /**
     * Executes the openFavourites Use Case.
     * @param username the username to find user's favourites
     */
    public void openFavourites(String username) {
        searchParametersInteractor.openFavourites(username);
    }
}
