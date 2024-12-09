package interface_adapter.viewfavourites;

import entity.Recipe;

import java.util.List;

public class FavouritesState {

    private String username;
    private Recipe selectedRecipe;
    private List<Recipe> favoriteRecipes;
    private String errorMessage;
    private boolean openFavourites;
    private String favouritesErrorMessage;


    public List<Recipe> getFavoriteRecipes() {
        return favoriteRecipes;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setFavoriteRecipes(List<Recipe> favoriteRecipes) {
        this.favoriteRecipes = favoriteRecipes;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Recipe getSelectedRecipe() {
        return selectedRecipe;
    }

    public void setSelectedRecipe(Recipe selectedRecipe) {
        this.selectedRecipe = selectedRecipe;
    }

    public boolean isOpenFavourites() {
        return openFavourites;
    }

    public void setOpenFavourites(boolean openFavourites) {
        this.openFavourites = openFavourites;
    }

    public String getFavouritesErrorMessage() {
        return this.favouritesErrorMessage;
    }

    public void setFavouritesErrorMessage(String message) {
        this.favouritesErrorMessage = message;
    }

}
