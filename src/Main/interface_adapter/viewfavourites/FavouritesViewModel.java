package interface_adapter.viewfavourites;

import interface_adapter.ViewModel;

public class FavouritesViewModel extends ViewModel<FavouritesState> {
    public static final String TITLE_LABEL = "Favorite Recipes";
    public static final String ERROR_LABEL = "An error occurred";
    public static final String NO_FAVOURITES_LABEL = "You have no favorite recipes.";

    public FavouritesViewModel() {
        super("Favorite Recipes");
        setState(new FavouritesState());
    }
}