package Main.use_cases.AddToFavourites;

import Main.entity.Recipe;
import Main.entity.RecipeId;

public class AddToFavouritesInputData {
    private final String recipeId;
    private final String username;

    public AddToFavouritesInputData(String recipeId, String username) {
        this.recipeId = recipeId;
        this.username = username;
    }

    public String getRecipeId() {
        return this.recipeId;
    }

    public String getUsername() {
        return username;
    }
}
