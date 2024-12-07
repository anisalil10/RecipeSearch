package Main.interface_adapter.popular_recipes;

import Main.interface_adapter.ViewModel;

public class PopularRecipesViewModel extends ViewModel<PopularRecipesState> {

    public static final String TITLE_LABEL = "Popular Recipes";

    public PopularRecipesViewModel() {
        super("Popular Recipes");
        setState(new PopularRecipesState());
    }
}
