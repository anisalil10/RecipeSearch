package interface_adapter.add_to_favourites;

import use_cases.add_to_favourites.AddToFavouritesInputBoundary;
import use_cases.add_to_favourites.AddToFavouritesInputData;

public class AddToFavouritesController {

    private final AddToFavouritesInputBoundary userAddToFavouritesUseCaseInteractor;


    public AddToFavouritesController(AddToFavouritesInputBoundary userAddToFavouritesUseCaseInteractor) {
        this.userAddToFavouritesUseCaseInteractor = userAddToFavouritesUseCaseInteractor;
    }

    public void execute(String recipeId, String username) {
        final AddToFavouritesInputData addToFavouritesInputData = new AddToFavouritesInputData(recipeId, username);

        userAddToFavouritesUseCaseInteractor.execute(addToFavouritesInputData);
    }
}
