package Main.use_cases.fetch_recipes;

import Main.entity.Recipe;

public interface FetchRecipesOutputBoundary {

    void prepareSuccessView(FetchRecipesOutputData outputData);

    void prepareFailView(String errorMessage);

    void openRecipe(Recipe recipe, String username);
}
