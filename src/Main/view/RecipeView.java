package Main.view;

import Main.interface_adapter.open_recipe.OpenRecipeController;
import Main.interface_adapter.open_recipe.OpenRecipeState;
import Main.interface_adapter.open_recipe.OpenRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RecipeView extends JPanel implements PropertyChangeListener {

    private final static String viewName = "Recipe";
    private final OpenRecipeViewModel openRecipeViewModel;

    private OpenRecipeController openRecipeController;

    private boolean darkMode = false; // Flag for dark mode

    private final JLabel recipeName;
    private final JLabel recipeCuisine;
    private final JLabel recipeMealType;

    public RecipeView(OpenRecipeViewModel openRecipeViewModel) {
        this.openRecipeViewModel = openRecipeViewModel;
        this.openRecipeViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel title = new JLabel("Recipe");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        recipeName = new JLabel();
        recipeCuisine = new JLabel();
        recipeMealType = new JLabel();

        recipeName.setAlignmentX(Component.CENTER_ALIGNMENT);
        recipeCuisine.setAlignmentX(Component.CENTER_ALIGNMENT);
        recipeMealType.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(recipeName);
        this.add(recipeCuisine);
        this.add(recipeMealType);

        applyDarkMode(); // Apply initial dark mode styling
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            final OpenRecipeState state = (OpenRecipeState) evt.getNewValue();
            recipeName.setText(state.getRecipeName());
            recipeCuisine.setText(state.getCuisine());
            recipeMealType.setText(state.getMealType());
        }
    }

    public static String getViewName() {
        return viewName;
    }

    public void setOpenRecipeController(OpenRecipeController openRecipeController) {
        this.openRecipeController = openRecipeController;
    }

    // New method to toggle dark mode
    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
        applyDarkMode();
    }

    // Apply dark mode styles dynamically
    private void applyDarkMode() {
        if (darkMode) {
            setBackground(Color.DARK_GRAY);
            recipeName.setForeground(Color.WHITE);
            recipeCuisine.setForeground(Color.WHITE);
            recipeMealType.setForeground(Color.WHITE);
        } else {
            setBackground(Color.LIGHT_GRAY);
            recipeName.setForeground(Color.BLACK);
            recipeCuisine.setForeground(Color.BLACK);
            recipeMealType.setForeground(Color.BLACK);
        }
        repaint();
        revalidate();
    }
}
