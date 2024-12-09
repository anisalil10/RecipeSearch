package interface_adapter.open_recipe;

import interface_adapter.ViewModel;

import javax.swing.*;

public class OpenRecipeViewModel extends ViewModel<OpenRecipeState> {

    private static OpenRecipeState openRecipeState;

    public static final String TITLE_LABEL = "Recipe";
    public static final String VIEW_RECIPE = "View Recipe";
    private String recipeName = "blank";

    public OpenRecipeViewModel() {
        super("Recipe");
        setState(new OpenRecipeState());
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
