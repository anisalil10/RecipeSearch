package Main.use_cases.AddToFavourites;

import Main.entity.User;

public class AddToFavouritesInteractor implements AddToFavouritesInputBoundary {
    private final AddToFavouritesUserDataAccessInterface userDataAccessObject;
    private final AddToFavouritesOutputBoundary userPresenter;

    public AddToFavouritesInteractor(AddToFavouritesUserDataAccessInterface addToFavouritesUserDataAccessInterface,
                                     AddToFavouritesOutputBoundary addToFavouritesOutputBoundary) {
        this.userDataAccessObject = addToFavouritesUserDataAccessInterface;
        this.userPresenter = addToFavouritesOutputBoundary;
    }

    @Override
    public void execute(AddToFavouritesInputData addToFavouritesInputData) {
        User user = this.userDataAccessObject.finduser(addToFavouritesInputData.getUsername());
        user.addtofavourites(addToFavouritesInputData.getRecipe());


    }
}
