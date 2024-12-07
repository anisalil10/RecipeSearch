package Main.interface_adapter.open_recipe;

import Main.entity.Recipe;
import Main.use_cases.open_recipe.OpenRecipeInputBoundary;
import Main.use_cases.open_recipe.OpenRecipeInputData;

public class OpenRecipeController {

    private final OpenRecipeInputBoundary openRecipeInteractor;

    public OpenRecipeController(OpenRecipeInputBoundary openRecipeInputBoundary) {
        this.openRecipeInteractor = openRecipeInputBoundary;
    }

    public void execute(Recipe recipe, String username) {
        final OpenRecipeInputData openRecipeInputData = new OpenRecipeInputData(recipe, username);

        openRecipeInteractor.execute(openRecipeInputData);
    }

}
