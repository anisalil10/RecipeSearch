package Main.interface_adapter.viewfavourites;
import java.util.List;

public class FavouritesState {
    private final List<String> favoriteRecipes;
    private final String errorMessage;

    public FavouritesState(List<String> favoriteRecipes, String errorMessage) {
        this.favoriteRecipes = favoriteRecipes;
        this.errorMessage = errorMessage;
    }

    public List<String> getFavoriteRecipes() {
        return favoriteRecipes;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
