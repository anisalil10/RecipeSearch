package Main.use_cases.OpenRecipe;

import Main.entity.Recipe;

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
        Recipe recipe = recipeDataAccessInterface.findrecipe(recipeId);

        final OpenRecipeOutputData openRecipeOutputData = new OpenRecipeOutputData(recipe);

    }

    @Override
    public void addToFavourites(OpenRecipeInputData openRecipeInputData) {

    }
}

