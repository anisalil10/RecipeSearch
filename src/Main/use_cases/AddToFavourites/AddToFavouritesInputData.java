package Main.use_cases.AddToFavourites;

import Main.entity.Recipe;

public class AddToFavouritesInputData {
    private final Recipe recipe;
    private final String username;

    public AddToFavouritesInputData(Recipe newRecipe, String username) {
        this.recipe = newRecipe;
        this.username = username;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public String getUsername() {
        return username;
    }
}
