package Main.use_cases.open_recipe;

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
        Recipe recipe;
        recipe = recipeDataAccessInterface.findrecipe(openRecipeInputData.getRecipeId());

        final OpenRecipeOutputData openRecipeOutputData = new OpenRecipeOutputData(recipe);

        recipePresenter.prepareSuccessView(openRecipeOutputData);
    }

    @Override
    public void addToFavourites(OpenRecipeInputData openRecipeInputData) {

    }
}

