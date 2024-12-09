package interface_adapter.viewfavourites;

import entity.Recipe;
import use_cases.viewfavourites.FavouritesInputBoundary;
import use_cases.viewfavourites.FavouritesInputData;

public class FavouritesController {
    private final FavouritesInputBoundary interactor;

    public FavouritesController(FavouritesInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void getFavoriteRecipes(String username) {
        FavouritesInputData inputData = new FavouritesInputData(username);
        interactor.fetchFavoriteRecipes(inputData);
    }

    public void openRecipe(Recipe recipe, String username) {
        FavouritesInputData inputData = new FavouritesInputData( username);

        interactor.openRecipe(recipe, inputData.getUsername());
    }

    public void addToFavourites(Recipe recipe, String username) {
        interactor.addToFavourites(recipe, username);
    }

}
