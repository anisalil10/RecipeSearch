package Main.use_cases.AddToFavourites;

import Main.entity.Recipe;
import Main.entity.RecipeId;

public class AddToFavouritesInputData {
    private final RecipeId recipeId;
    private final String username;

    public AddToFavouritesInputData(RecipeId recipeId, String username) {
        this.recipeId = recipeId;
        this.username = username;
    }

    public RecipeId getRecipeId() {
        return this.recipeId;
    }

    public String getUsername() {
        return username;
    }
}
