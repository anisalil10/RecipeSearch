package Main.use_cases.OpenRecipe;

import Main.entity.Recipe;
import Main.entity.RecipeId;

public class OpenRecipeInteractor implements OpenRecipeInputBoundary{

    private final OpenRecipeDataAccessInterface recipeDataAccessInterface;
    private final OpenRecipeOutputBoundary recipePresenter;

    public OpenRecipeInteractor(OpenRecipeDataAccessInterface recipeDataAccessInterface,
                                OpenRecipeOutputBoundary recipePresenter) {
        this.recipeDataAccessInterface = recipeDataAccessInterface;
        this.recipePresenter = recipePresenter;
    }

    @Override
    public void execute(OpenRecipeInputData openRecipeInputData) {
        final String recipeId = openRecipeInputData.getRecipeId();

        Recipe outputdata = recipeDataAccessInterface.findrecipe(recipeId);

        final OpenRecipeOutputData openRecipeOutputData = new OpenRecipeOutputData(outputdata);

    }
}

