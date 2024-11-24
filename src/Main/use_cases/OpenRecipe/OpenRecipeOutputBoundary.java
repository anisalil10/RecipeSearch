package Main.use_cases.OpenRecipe;

public interface OpenRecipeOutputBoundary {

    void prepareSuccessView(OpenRecipeOutputData openRecipeOutputData);

    void prepareFailView(String message);
}
