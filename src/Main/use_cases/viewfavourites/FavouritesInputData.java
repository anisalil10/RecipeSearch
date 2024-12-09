package use_cases.viewfavourites;

public class FavouritesInputData {
    private final String username;

    public FavouritesInputData(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
