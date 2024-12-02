package Main.use_cases.add_to_favourites;

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
