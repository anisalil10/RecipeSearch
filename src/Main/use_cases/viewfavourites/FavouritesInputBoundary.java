package use_cases.viewfavourites;

import entity.Recipe;

public interface FavouritesInputBoundary {

    void fetchFavoriteRecipes(FavouritesInputData inputData);

    void openRecipe(Recipe recipe, String username);

    void addToFavourites(Recipe recipe, String username);
}
