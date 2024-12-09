package use_cases.add_to_favourites;


public class AddToFavouritesInteractor implements AddToFavouritesInputBoundary {
    private final AddToFavouritesUserDataAccessInterface userDataAccessObject;

    public AddToFavouritesInteractor(AddToFavouritesUserDataAccessInterface addToFavouritesUserDataAccessInterface) {
        this.userDataAccessObject = addToFavouritesUserDataAccessInterface;
    }

    @Override
    public void execute(AddToFavouritesInputData addToFavouritesInputData) {
        userDataAccessObject.updatefavourites(addToFavouritesInputData.getUsername(),
                addToFavouritesInputData.getRecipeId());
    }
}
