package Main.use_cases.viewfavourites;

public class FavouritesInteractor implements FavouritesInputBoundary {
    private final DataAccessObject dataAccessObject;
    private final FavouritesOutputBoundary outputBoundary;

    public FavouritesInteractor(DataAccessObject dataAccessObject, FavouritesOutputBoundary outputBoundary) {
        this.dataAccessObject = dataAccessObject;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void fetchFavoriteRecipes(FavouritesInputData inputData) {
        String username = inputData.getUsername();

        // Validate input
        if (username == null || username.isEmpty()) {
            outputBoundary.presentError("Username cannot be null or empty.");
            return;
        }

        // Fetch favorite recipe names
        List<String> favoriteRecipeNames = dataAccessObject.getFavoriteRecipeNames(username);

        // Prepare output data
        if (favoriteRecipeNames.isEmpty()) {
            outputBoundary.presentError("No favorite recipes found for user: " + username);
        } else {
            FavouritesOutputData outputData = new FavouritesOutputData(favoriteRecipeNames);
            outputBoundary.presentFavoriteRecipes(outputData);
        }
    }
}

