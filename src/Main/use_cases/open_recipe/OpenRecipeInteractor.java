package Main.use_cases.open_recipe;

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
        final OpenRecipeOutputData openRecipeOutputData = new OpenRecipeOutputData(openRecipeInputData.getRecipe());
        recipePresenter.prepareSuccessView(openRecipeOutputData);
    }

    @Override
    public void addToFavourites(OpenRecipeInputData openRecipeInputData) {

    }
}

