package Main.interface_adapter.fetch_recipes;

import Main.entity.SearchParameters;
import Main.use_cases.fetch_recipes.FetchRecipesInputBoundary;
import Main.use_cases.fetch_recipes.FetchRecipesInputData;

public class FetchRecipesController {

    private final FetchRecipesInputBoundary recipesInputInteractor;

    public FetchRecipesController(FetchRecipesInputBoundary recipesInputInteractor) {
        this.recipesInputInteractor = recipesInputInteractor;

    }
    public void execute(SearchParameters searchParameters) {
        final FetchRecipesInputData fetchRecipesInputData = new FetchRecipesInputData(searchParameters);

        recipesInputInteractor.execute(fetchRecipesInputData);
    }

    public void openRecipe(String recipeId, String username) {
        recipesInputInteractor.openRecipe(recipeId, username);
    }

}