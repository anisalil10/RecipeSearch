package Main.use_cases.OpenRecipe;

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
        final RecipeId recipeId = new RecipeId(openRecipeInputData.getRecipeId());

        final OpenRecipeOutputData openRecipeOutputData = new OpenRecipeOutputData(recipeId);


    }
}

