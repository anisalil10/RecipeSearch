package Main.interface_adapter.get_search_parameters;

import Main.interface_adapter.ViewModel;
import Main.interface_adapter.signup.SignupState;

public class GetSearchParametersViewModel extends ViewModel<GetSearchParametersState> {
    public static final String TITLE_LABEL = "Find Recipe";
    public static final String SEARCH = "Enter Search";
    public static final String CUISINE_MENU = "Choose Cuisine";
    public static final String MEAL_TYPE_MENU = "Choose Meal Type";
    public static final String DIET_MENU = "Choose Diet";

    public GetSearchParametersViewModel() {
        super("find recipe");
        setState(new GetSearchParametersState());
    }

}
