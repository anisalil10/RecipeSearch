package use_cases.AddToFavourites;

import entity.UserFactory;

public class AddToFavouritesInteractor implements AddToFavouritesInputBoundary {
    private final AddToFavouritesUserDataAccessInterface userDataAccessObject;
    private final AddToFavouritesOutputBoundary userPresenter;

    public AddToFavouritesInteractor(AddToFavouritesUserDataAccessInterface addToFavouritesUserDataAccessInterface,
                                     AddToFavouritesOutputBoundary addToFavouritesOutputBoundary,
                                     UserFactory userFactory) {
        this.userDataAccessObject = addToFavouritesUserDataAccessInterface;
        this.userPresenter = addToFavouritesOutputBoundary;
    }

    @Override
    public void execute(AddToFavouritesInputData addToFavouritesInputData) {
        this.userDataAccessObject.addToFavourites();
    }
}
