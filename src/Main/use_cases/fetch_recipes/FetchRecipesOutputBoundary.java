package use_cases.fetch_recipes;

import entity.Recipe;

public interface FetchRecipesOutputBoundary {

    void prepareSuccessView(FetchRecipesOutputData outputData);

    void prepareFailView(String errorMessage);

    void openRecipe(Recipe recipe, String username);
}
