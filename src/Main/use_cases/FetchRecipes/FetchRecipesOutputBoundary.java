package Main.use_cases.FetchRecipes;

import Main.entity.Recipe;

import java.util.List;

public interface FetchRecipesOutputBoundary {

    void prepareSuccessView(FetchRecipesOutputData outputData);

    void prepareFailView(String errorMessage);
}
