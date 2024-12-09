package use_cases.add_to_favourites;

public class AddToFavouritesOutputData {
    private String username;

    public AddToFavouritesOutputData(String username, String recipeId) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
