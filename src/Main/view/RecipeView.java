package Main.view;

import Main.interface_adapter.open_recipe.OpenRecipeController;
import Main.interface_adapter.open_recipe.OpenRecipeState;
import Main.interface_adapter.open_recipe.OpenRecipeViewModel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.*;

public class RecipeView extends JPanel implements ActionListener, PropertyChangeListener {

    private final static String viewName = "Recipe";
    private final OpenRecipeViewModel openRecipeViewModel;

    private OpenRecipeController openRecipeController;

    public RecipeView(OpenRecipeViewModel openRecipeViewModel) {
        this.openRecipeViewModel = openRecipeViewModel;
        this.openRecipeViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Recipe");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();

        OpenRecipeState currentState = openRecipeViewModel.getState();

        final JLabel recipeName = new JLabel(currentState.getRecipeName());
        final JLabel recipeCuisine = new JLabel(currentState.getCuisine());
        final JLabel recipeMealType = new JLabel(currentState.getMealType());

        this.add(recipeName);
        this.add(recipeCuisine);
        this.add(recipeMealType);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final OpenRecipeState state = (OpenRecipeState) evt.getNewValue();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    public static String getViewName() {
        return viewName;
    }

    public void setOpenRecipeController(OpenRecipeController openRecipeController) {
        this.openRecipeController = openRecipeController;
    }
}
