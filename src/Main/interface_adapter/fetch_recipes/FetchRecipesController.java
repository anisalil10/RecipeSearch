package Main.interface_adapter.fetch_recipes;

import Main.entity.SearchParameters;
import Main.use_cases.fetch_recipes.FetchRecipesInputBoundary;
import Main.use_cases.fetch_recipes.FetchRecipesInputData;

public class FetchRecipesController {

    private final FetchRecipesInputBoundary recipesInputInteractor;

    public FetchRecipesController(FetchRecipesInputBoundary recipesInputInteractor) {
        this.recipesInputInteractor = recipesInputInteractor;
    }

    // Fetch recipes using the given search parameters and username
    public void execute(SearchParameters searchParameters, String username) {
        final FetchRecipesInputData fetchRecipesInputData = new FetchRecipesInputData(searchParameters, username);
        recipesInputInteractor.execute(fetchRecipesInputData);
    }

    // Open the selected recipe for viewing
    public void openRecipe(String recipeId, String username) {
        recipesInputInteractor.openRecipe(recipeId, username);
    }
}
