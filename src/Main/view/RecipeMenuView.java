package Main.view;

import Main.interface_adapter.fetch_recipes.FetchRecipesController;
import Main.interface_adapter.fetch_recipes.FetchRecipesState;
import Main.interface_adapter.fetch_recipes.FetchRecipesViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RecipeMenuView extends JPanel implements PropertyChangeListener {

    private final String viewName = "search results";
    private final FetchRecipesViewModel fetchRecipesViewModel;

    private final DefaultListModel<String> recipeListModel; // Dynamic list model for recipes
    private final JList<String> recipeList;                 // List to display recipe names
    private final JButton viewRecipe;                       // Button to view selected recipe
    private FetchRecipesController fetchRecipesController;

    private boolean darkMode = false;                       // Dark mode flag

    public RecipeMenuView(FetchRecipesViewModel fetchRecipesViewModel) {
        this.fetchRecipesViewModel = fetchRecipesViewModel;
        this.fetchRecipesViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Title
        final JLabel title = new JLabel("Recipe Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        // Recipe List and Scroll Pane
        recipeListModel = new DefaultListModel<>();
        recipeList = new JList<>(recipeListModel);
        recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Single selection

        JScrollPane scrollPane = new JScrollPane(recipeList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane);

        // View Recipe Button
        viewRecipe = new JButton("View Recipe");
        viewRecipe.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewRecipe.addActionListener(evt -> {
            String selectedRecipeId = recipeList.getSelectedValue(); // Get selected recipe ID
            if (selectedRecipeId != null) {
                final FetchRecipesState currentState = fetchRecipesViewModel.getState();
                fetchRecipesController.openRecipe(selectedRecipeId, currentState.getUsername());
            } else {
                JOptionPane.showMessageDialog(this, "Please select a recipe to view.");
            }
        });
        this.add(viewRecipe);

        applyDarkMode(); // Apply initial dark mode styling
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("recipes".equals(evt.getPropertyName())) {
            FetchRecipesState state = (FetchRecipesState) evt.getNewValue();
            updateRecipeList(state.getRecipeIds()); // Dynamically update the recipe list
        }
    }

    private void updateRecipeList(java.util.List<String> recipeIds) {
        recipeListModel.clear(); // Clear existing recipes
        for (String recipeId : recipeIds) {
            recipeListModel.addElement(recipeId); // Add each recipe to the list
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setFetchRecipesController(FetchRecipesController fetchRecipesController) {
        this.fetchRecipesController = fetchRecipesController;
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
            recipeList.setBackground(Color.BLACK);
            recipeList.setForeground(Color.WHITE);
            viewRecipe.setBackground(Color.GRAY);
            viewRecipe.setForeground(Color.WHITE);
        } else {
            setBackground(Color.LIGHT_GRAY);
            recipeList.setBackground(Color.WHITE);
            recipeList.setForeground(Color.BLACK);
            viewRecipe.setBackground(Color.WHITE);
            viewRecipe.setForeground(Color.BLACK);
        }
        repaint();
        revalidate();
    }
}
