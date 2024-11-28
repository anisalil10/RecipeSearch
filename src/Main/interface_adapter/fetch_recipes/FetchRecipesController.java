package Main.interface_adapter.fetch_recipes;

import Main.entity.SearchParameters;
import Main.use_cases.FetchRecipes.FetchRecipesInputBoundary;
import Main.use_cases.FetchRecipes.FetchRecipesInputData;

public class FetchRecipesController {

    private static FetchRecipesInputBoundary recipesInputInteractor;

    public FetchRecipesController(FetchRecipesInputBoundary recipesInputInteractor) {
        FetchRecipesController.recipesInputInteractor = recipesInputInteractor;

    }
    public static void execute(SearchParameters searchParameters) {
        final FetchRecipesInputData fetchRecipesInputData = new FetchRecipesInputData(searchParameters);

        recipesInputInteractor.execute(fetchRecipesInputData);
    }

}