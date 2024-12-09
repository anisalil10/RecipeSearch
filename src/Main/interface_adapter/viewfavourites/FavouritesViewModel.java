package interface_adapter.viewfavourites;

import interface_adapter.ViewModel;

public class FavouritesViewModel extends ViewModel<FavouritesState> {

    public FavouritesViewModel() {
        super("Favourite Recipes");
        setState(new FavouritesState());
    }
}