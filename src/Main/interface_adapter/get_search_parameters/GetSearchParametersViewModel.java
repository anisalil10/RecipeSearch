package Main.interface_adapter.get_search_parameters;

import Main.interface_adapter.ViewModel;

public class GetSearchParametersViewModel extends ViewModel<GetSearchParametersState> {
    public static final String TITLE_LABEL = "Search Recipes";
    public static final String SEARCH = "Enter Search";
    public static final String CUISINE_MENU = "Enter Cuisine";
    public static final String MEAL_TYPE_MENU = "Enter Meal Type";

    public static final String SEARCH_BUTTON_LABEL = "Search";

    public GetSearchParametersViewModel() {
        super("Search Recipes");
        setState(new GetSearchParametersState());
    }

}
