package use_cases.viewfavourites;

import data_access.DataAccessObject;
import entity.Recipe;

import java.util.List;

public class FavouritesInteractor implements FavouritesInputBoundary {
    private final DataAccessObject dataAccessObject;
    private final FavouritesOutputBoundary outputBoundary;

    public FavouritesInteractor(DataAccessObject dataAccessObject, FavouritesOutputBoundary outputBoundary) {
        this.dataAccessObject = dataAccessObject;
        this.outputBoundary = outputBoundary;
    }

    public void openRecipe(Recipe recipe, String username) {
        outputBoundary.openRecipe(recipe, username);
    }

    @Override
    public void addToFavourites(Recipe recipe, String username) {
        if(dataAccessObject.recipeInFavourites(username, recipe.getRecipeID())) {
            outputBoundary.addToFavouritesFail("recipe already in favourites");
        }
        else {
            dataAccessObject.updateFavourites(username, recipe.getRecipeID());
            outputBoundary.addToFavouritesSuccess("");
        }
    }

    @Override
    public void fetchFavoriteRecipes(FavouritesInputData inputData) {
        String username = inputData.getUsername();

        // Fetch favorite recipe names
        List<Recipe> favoriteRecipes = dataAccessObject.getFavoriteRecipeNames(username);

        // Prepare output data
        if (favoriteRecipes.isEmpty()) {
            outputBoundary.presentError("No favorite recipes found for user: " + username);
        } else {
            FavouritesOutputData outputData = new FavouritesOutputData(favoriteRecipes);
            outputBoundary.presentFavoriteRecipes(outputData);
        }
    }
}

