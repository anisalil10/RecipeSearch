package interface_adapter.popular_recipes;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the PopularRecipes View.
 */
public class PopularRecipesViewModel extends ViewModel<PopularRecipesState> {

    public static final String TITLE_LABEL = "Popular Recipes";

    public PopularRecipesViewModel() {
        super("Popular Recipes");
        setState(new PopularRecipesState());
    }
}
