package Main.view;

import Main.interface_adapter.fetch_recipes.FetchRecipesController;
import Main.interface_adapter.fetch_recipes.FetchRecipesState;
import Main.interface_adapter.fetch_recipes.FetchRecipesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RecipeMenuView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "search results";
    private final FetchRecipesViewModel fetchRecipesViewModel;

    private final JButton viewRecipe;
    private FetchRecipesController fetchRecipesController;

    public RecipeMenuView(FetchRecipesViewModel fetchRecipesViewModel) {
        this.fetchRecipesViewModel = fetchRecipesViewModel;
        this.fetchRecipesViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Recipe Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        viewRecipe = new JButton("view recipe");
        buttons.add(viewRecipe);

        String recipeId = "http://www.edamam.com/ontologies/edamam.owl#recipe_6dc325d44c7bc6c220f9e5a0dba2a333";

        viewRecipe.addActionListener(
                evt -> {
                    final FetchRecipesState currentState = fetchRecipesViewModel.getState();

                    fetchRecipesController.openRecipe(recipeId, currentState.getUsername());
                }
        );
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final FetchRecipesState state = (FetchRecipesState) evt.getNewValue();
    }

    public String getViewName() {
        return viewName;
    }

    public void setFetchRecipesController(FetchRecipesController fetchRecipesController) {
        this.fetchRecipesController = fetchRecipesController;
    }
}
