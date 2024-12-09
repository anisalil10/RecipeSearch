package interface_adapter.popular_recipes;

import entity.Recipe;

import java.util.List;

public class PopularRecipesState {

    private List<Recipe> topRecipes;
    private Recipe selectedRecipe;
    private String username;
    private String favouritesErrorMessage;

    public List<Recipe> getTopRecipes() {
        return topRecipes;
    }

    public void setTopRecipes(List<Recipe> topRecipes) {
        this.topRecipes = topRecipes;
    }

    public void setSelectedRecipe(Recipe recipe) {
        this.selectedRecipe = recipe;
    }

    public Recipe getSelectedRecipe() {
        return selectedRecipe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFavouritesErrorMessage() {
        return favouritesErrorMessage;
    }

    public void setFavouritesErrorMessage(String favouritesErrorMessage) {
        this.favouritesErrorMessage = favouritesErrorMessage;
    }

    public void setAllNull() {
        this.topRecipes = null;
        this.selectedRecipe = null;
        this.username = null;
        this.favouritesErrorMessage = null;
    }
}
