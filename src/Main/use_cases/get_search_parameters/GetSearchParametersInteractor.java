package use_cases.get_search_parameters;

import entity.Recipe;
import entity.SearchParameters;

import java.util.List;

public class GetSearchParametersInteractor implements GetSearchParametersInputBoundary {

    private final GetSearchParametersDataAccess searchParametersDataAccess;
    private final GetSearchParametersOutputBoundary searchPresenter;

    public GetSearchParametersInteractor(GetSearchParametersDataAccess searchParametersDataAccess,
                                         GetSearchParametersOutputBoundary searchPresenter) {
        this.searchParametersDataAccess = searchParametersDataAccess;
        this.searchPresenter = searchPresenter;
    }

    public void execute(GetSearchParametersInputData inputData) {
        SearchParameters searchParameters = new SearchParameters(inputData.getQuery(),
                inputData.getCuisineType(), inputData.getMealType(),
                inputData.getDiet(), inputData.getMaxResults());

        if(inputData.getQuery().isEmpty()) {
            searchPresenter.prepareFailView("Enter a search");
        }
        else if(inputData.getCuisineType().isEmpty()) {
            searchPresenter.prepareFailView("Enter a cuisine");
        }
        else if(inputData.getMealType().isEmpty()) {
            searchPresenter.prepareFailView("Enter a meal time");
        }
        else if(searchParametersDataAccess.getRecipes(searchParameters).isEmpty()) {
            searchPresenter.prepareFailView("No recipes found");
        }
        else {
            List<Recipe> recipes = searchParametersDataAccess.getRecipes(searchParameters);

            final GetSearchParametersOutputData outputData = new GetSearchParametersOutputData(recipes);
            searchPresenter.prepareSuccessView(outputData);
        }
    }

    @Override
    public void openRecipe(Recipe recipe, String username) {
        searchPresenter.openRecipe(recipe, username);
    }

    @Override
    public void addToFavourites(Recipe recipe, String username) {

        if(searchParametersDataAccess.recipeInFavourites(username, recipe.getRecipeID())) {
            searchPresenter.addToFavouritesFail("recipe already in favourites");
        }
        else {
            searchParametersDataAccess.updateFavourites(username, recipe.getRecipeID());
            searchPresenter.addToFavouritesSuccess("");

        }
    }

    @Override
    public void viewPopularRecipes(String username) {
        List<Recipe> topRecipes = searchParametersDataAccess.getTopRecipes();
        searchPresenter.viewPopularRecipes(username, topRecipes);
    }

    @Override
    public void openFavourites(String username) {
        searchPresenter.openfavouriteRecipes(username);
    }


}
