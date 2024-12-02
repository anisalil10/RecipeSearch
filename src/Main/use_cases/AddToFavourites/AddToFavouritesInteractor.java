package Main.use_cases.AddToFavourites;


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
