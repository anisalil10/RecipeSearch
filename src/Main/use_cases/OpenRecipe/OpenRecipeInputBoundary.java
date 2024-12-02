package Main.use_cases.OpenRecipe;

public interface OpenRecipeInputBoundary {

    void execute(OpenRecipeInputData openRecipeInputData);

    void addToFavourites(OpenRecipeInputData openRecipeInputData);
}
