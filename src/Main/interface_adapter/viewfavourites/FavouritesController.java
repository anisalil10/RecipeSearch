package Main.interface_adapter.viewfavourites;

import Main.use_cases.viewfavourites.FavouritesInputBoundary;
import Main.use_cases.viewfavourites.FavouritesInputData;

public class FavouritesController {
    private final FavouritesInputBoundary interactor;

    public FavouritesController(FavouritesInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void getFavoriteRecipes(String username) {
        FavouritesInputData inputData = new FavouritesInputData(username);
        interactor.fetchFavoriteRecipes(inputData);
    }
}
