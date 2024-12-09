package use_cases.add_to_favourites;

public interface AddToFavouritesOutputBoundary {

    void prepareSuccessView(AddToFavouritesOutputData outputData);

    void prepareFailView(String errorMessage);
}
