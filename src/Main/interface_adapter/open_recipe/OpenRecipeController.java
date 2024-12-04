package Main.interface_adapter.open_recipe;

import Main.use_cases.open_recipe.OpenRecipeInputBoundary;
import Main.use_cases.open_recipe.OpenRecipeInputData;

import java.io.IOException;

public class OpenRecipeController {

    private final OpenRecipeInputBoundary openRecipeInteractor;

    public OpenRecipeController(OpenRecipeInputBoundary openRecipeInputBoundary) {
        this.openRecipeInteractor = openRecipeInputBoundary;
    }

    public void execute(String recipeId, String username) throws IOException {
        final OpenRecipeInputData openRecipeInputData = new OpenRecipeInputData(recipeId, username);

        openRecipeInteractor.execute(openRecipeInputData);
    }

}
