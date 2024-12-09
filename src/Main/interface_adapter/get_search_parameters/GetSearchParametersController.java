package interface_adapter.get_search_parameters;

import entity.Recipe;
import use_cases.get_search_parameters.GetSearchParametersInputBoundary;
import use_cases.get_search_parameters.GetSearchParametersInputData;

public class GetSearchParametersController {
    private final GetSearchParametersInputBoundary searchParametersInteractor;

    public GetSearchParametersController(GetSearchParametersInputBoundary searchParametersInteractor) {
        this.searchParametersInteractor = searchParametersInteractor;
    }

    public void execute(String query, String cuisine, String mealType, String username) {
        final GetSearchParametersInputData searchParametersInputData = new GetSearchParametersInputData(query, cuisine,
                mealType, username);

        searchParametersInteractor.execute(searchParametersInputData);
    }

    public void openRecipe(Recipe recipe, String username) {
        searchParametersInteractor.openRecipe(recipe, username);
    }

    public void addToFavourites(Recipe recipe, String username) {
        searchParametersInteractor.addToFavourites(recipe, username);
    }

    public void viewPopularRecipes(String username) {
        searchParametersInteractor.viewPopularRecipes(username);}

    public void openFavourites(String username) {
        searchParametersInteractor.openFavourites(username);
    }
}
