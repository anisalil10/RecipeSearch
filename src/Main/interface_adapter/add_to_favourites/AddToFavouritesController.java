package Main.interface_adapter.add_to_favourites;

import Main.use_cases.AddToFavourites.AddToFavouritesInputBoundary;
import Main.use_cases.AddToFavourites.AddToFavouritesInputData;

public class AddToFavouritesController {

    private final AddToFavouritesInputBoundary userAddToFavouritesUseCaseInteractor;


    public AddToFavouritesController(AddToFavouritesInputBoundary userAddToFavouritesUseCaseInteractor) {
        this.userAddToFavouritesUseCaseInteractor = userAddToFavouritesUseCaseInteractor;
    }

    public void execute(int recipeId, String username) {
        final AddToFavouritesInputData addToFavouritesInputData = new AddToFavouritesInputData(recipeId, username);

        userAddToFavouritesUseCaseInteractor.execute(addToFavouritesInputData);
    }
}