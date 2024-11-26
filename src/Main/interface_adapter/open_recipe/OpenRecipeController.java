package Main.interface_adapter.open_recipe;

import Main.entity.RecipeId;
import Main.use_cases.OpenRecipe.OpenRecipeInputBoundary;
import Main.use_cases.OpenRecipe.OpenRecipeInputData;

public class OpenRecipeController {

    private final OpenRecipeInputBoundary openRecipeInteractor;

    public OpenRecipeController(OpenRecipeInputBoundary openRecipeInputBoundary) {
        this.openRecipeInteractor = openRecipeInputBoundary;
    }

    public void execute(RecipeId recipeId) {
        final OpenRecipeInputData openRecipeInputData = new OpenRecipeInputData(recipeId);

        openRecipeInteractor.execute(openRecipeInputData);
    }

}
