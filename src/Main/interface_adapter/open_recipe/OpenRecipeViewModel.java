package Main.interface_adapter.open_recipe;

import Main.entity.Recipe;
import Main.interface_adapter.ViewModel;

public class OpenRecipeViewModel extends ViewModel<OpenRecipeState> {

    private static OpenRecipeState openRecipeState;

    public static final String TITLE_LABEL = openRecipeState.getRecipeId() + "Recipe";
    public static final String VIEW_RECIPE = "View Recipe";

    public OpenRecipeViewModel(String viewName) {
        super("Recipe");
        setState(new OpenRecipeState());
    }
}
