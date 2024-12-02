package Main.view;

import Main.interface_adapter.open_recipe.OpenRecipeController;
import Main.interface_adapter.open_recipe.OpenRecipeState;
import Main.interface_adapter.open_recipe.OpenRecipeViewModel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RecipeView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "recipe";
    private final OpenRecipeViewModel openRecipeViewModel;

    private final JButton addToFavourites;
    private OpenRecipeController openRecipeController;

    public RecipeView(OpenRecipeViewModel openRecipeViewModel) {
        this.openRecipeViewModel = openRecipeViewModel;
        this.openRecipeViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Recipe View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        addToFavourites = new JButton("add to favourites");
        buttons.add(addToFavourites);

        addToFavourites.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(addToFavourites)) {
                            final OpenRecipeState currentState = openRecipeViewModel.getState();

                            openRecipeController.execute(currentState.getRecipeId(), currentState.getUsername());

                        }
                    }
                }
        );

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
