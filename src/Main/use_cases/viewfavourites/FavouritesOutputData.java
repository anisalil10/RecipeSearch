package use_cases.viewfavourites;


import entity.Recipe;

import java.util.List;

public class FavouritesOutputData {
    private final List<Recipe> favoriteRecipeNames;

    public FavouritesOutputData(List <Recipe> favoriteRecipeNames) {
        this.favoriteRecipeNames = favoriteRecipeNames;
    }

    public List<Recipe> getFavoriteRecipeNames() {
        return favoriteRecipeNames;
    }
}
