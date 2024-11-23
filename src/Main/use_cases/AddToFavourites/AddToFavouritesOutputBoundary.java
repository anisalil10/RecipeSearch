package Main.use_cases.AddToFavourites;

public interface AddToFavouritesOutputBoundary {

    void prepareSuccessView(AddToFavouritesOutputData outputData);

    void prepareFailView(String errorMessage);
}
