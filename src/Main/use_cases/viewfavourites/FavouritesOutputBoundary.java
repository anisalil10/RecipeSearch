package use_cases.viewfavourites;

import entity.Recipe;

public interface FavouritesOutputBoundary {

    void presentFavoriteRecipes(FavouritesOutputData outputData);

    void openRecipe(Recipe recipe, String username);

    void presentError(String errorMessage);
}
