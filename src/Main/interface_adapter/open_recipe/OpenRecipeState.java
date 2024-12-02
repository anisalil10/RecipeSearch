package Main.interface_adapter.open_recipe;

import Main.entity.RecipeId;

public class OpenRecipeState {
    private String recipeId;
    private String recipeIdError;
    private String username;


    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeIdError() {
        return recipeIdError;
    }

    public void setRecipeIdError(String recipeIdError) {
        this.recipeIdError = recipeIdError;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
