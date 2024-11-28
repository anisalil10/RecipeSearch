package Main.use_cases.FetchRecipes;

import Main.entity.Recipe;
import Main.entity.SearchParameters;

import java.awt.*;
import java.util.List;

public class FetchRecipesInteractor implements FetchRecipesInputBoundary {

    private final FetchRecipesDataAccessInterface recipesDataAccessInterface;
    private final FetchRecipesOutputBoundary recipesPresenter;

    public FetchRecipesInteractor(FetchRecipesDataAccessInterface recipesDataAccessInterface,
                                  FetchRecipesOutputBoundary recipesPresenter) {
        this.recipesDataAccessInterface = recipesDataAccessInterface;
        this.recipesPresenter = recipesPresenter;
    }


    @Override
    public void execute(FetchRecipesInputData fetchRecipesInputData) {
        List<Recipe> recipeResults = recipesDataAccessInterface.getrecipes(fetchRecipesInputData.getSearchParameters());

        final FetchRecipesOutputData outputData = new FetchRecipesOutputData(recipeResults);
        if (recipeResults.isEmpty()) {
            recipesPresenter.prepareFailView("Could not find any recipes :(");
        }
        else {

            recipesPresenter.prepareSuccessView(outputData);
        }

    }
}
