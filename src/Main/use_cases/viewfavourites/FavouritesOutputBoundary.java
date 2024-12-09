package use_cases.viewfavourites;

import entity.Recipe;

public interface FavouritesOutputBoundary {

    void presentFavoriteRecipes(FavouritesOutputData outputData);

    void openRecipe(Recipe recipe, String username);

    void addToFavouritesFail(String message);

    void addToFavouritesSuccess(String s);

    void presentError(String errorMessage);
}
