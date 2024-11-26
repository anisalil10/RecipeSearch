package Main.interface_adapter.fetch_recipes;

import Main.interface_adapter.ViewModel;

public class FetchRecipesViewModel extends ViewModel<FetchRecipesState> {

    public static final String TITLE_LABEL = "Search Results";
    public static final String VIEW_RECIPE = "View Recipe";

    public FetchRecipesViewModel(String viewName) {
        super("search results");
        setState(new FetchRecipesState());

    }


}
