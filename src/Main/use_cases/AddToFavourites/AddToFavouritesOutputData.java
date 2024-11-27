package Main.use_cases.AddToFavourites;

import Main.entity.RecipeId;

public class AddToFavouritesOutputData {
    private String username;

    public AddToFavouritesOutputData(String username, String recipeId) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
