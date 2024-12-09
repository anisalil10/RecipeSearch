package use_cases.open_recipe;

public interface OpenRecipeInputBoundary {

    void execute(OpenRecipeInputData openRecipeInputData);

    void addToFavourites(OpenRecipeInputData openRecipeInputData);
}
