package Main.use_cases.AddToFavourites;

import Main.entity.RecipeId;
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
        RecipeId recipeId = addToFavouritesInputData.getRecipeId();
        user.addtofavourites(addToFavouritesInputData.getRecipeId());

        final AddToFavouritesOutputData outputData = new AddToFavouritesOutputData(user.getUsername(), recipeId);
        userPresenter.prepareSuccessView(outputData);
    }
}
