package Main.view;

import Main.interface_adapter.open_recipe.OpenRecipeController;
import Main.interface_adapter.open_recipe.OpenRecipeState;
import Main.interface_adapter.open_recipe.OpenRecipeViewModel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.Objects;

import javax.swing.*;

public class RecipeView extends JPanel implements PropertyChangeListener {

    private final static String viewName = "Recipe";
    private final OpenRecipeViewModel openRecipeViewModel;

    private OpenRecipeController openRecipeController;

    private final JButton viewRecipe;

    public RecipeView(OpenRecipeViewModel openRecipeViewModel) {
        this.openRecipeViewModel = openRecipeViewModel;
        this.openRecipeViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel();
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        final JPanel recipeInfo = new JPanel();

        viewRecipe = new JButton("view recipe");
        buttons.add(viewRecipe);

        viewRecipe.addActionListener(e -> {
                final OpenRecipeState currentState = openRecipeViewModel.getState();

                final JLabel recipeName = new JLabel(currentState.getRecipeName());
                final JLabel recipeCuisine = new JLabel(currentState.getCuisine());
                final JLabel recipeMealType = new JLabel(currentState.getMealType());

                recipeInfo.add(recipeName);
                recipeInfo.add(recipeCuisine);
                recipeInfo.add(recipeMealType);

                recipeInfo.revalidate();
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(recipeInfo);
        recipeInfo.setLayout(new BoxLayout(recipeInfo, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final OpenRecipeState state = (OpenRecipeState) evt.getNewValue();
    }

    public static String getViewName() {
        return viewName;
    }

    public void setOpenRecipeController(OpenRecipeController openRecipeController) {
        this.openRecipeController = openRecipeController;
    }
}
