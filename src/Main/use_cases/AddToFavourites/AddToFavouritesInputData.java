package Main.use_cases.AddToFavourites;

import Main.entity.Recipe;

public class AddToFavouritesInputData {
    private final int recipeId;
    private final String username;

    public AddToFavouritesInputData(int recipeId, String username) {
        this.recipeId = recipeId;
        this.username = username;
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    public String getUsername() {
        return username;
    }
}
