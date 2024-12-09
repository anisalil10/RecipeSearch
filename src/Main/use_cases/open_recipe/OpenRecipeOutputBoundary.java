package use_cases.open_recipe;

public interface OpenRecipeOutputBoundary {

    void prepareSuccessView(OpenRecipeOutputData openRecipeOutputData);

    void prepareFailView(String message);
}
