package view;

import entity.Recipe;
import interface_adapter.viewfavourites.FavouritesController;
import interface_adapter.viewfavourites.FavouritesState;
import interface_adapter.viewfavourites.FavouritesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;

public class FavouritesView extends JPanel implements ActionListener, PropertyChangeListener {

    private static final String viewName = "Favourite Recipes";

    private final FavouritesViewModel favouritesViewModel;
    private FavouritesController favouritesController;

    private final JPanel display;

    public FavouritesView(FavouritesViewModel favouritesViewModel) {
        this.favouritesViewModel = favouritesViewModel;
        this.favouritesViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Favourite Recipes");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        display = new JPanel();
        // Add action listener for the Back button

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property change events if needed
        final FavouritesState state = (FavouritesState) evt.getNewValue();

        if(state.isOpenFavourites()) {
            favouritesController.getFavoriteRecipes(state.getUsername());
        }

        else if(state.getFavoriteRecipes() != null) {
            final FavouritesState currentState = favouritesViewModel.getState();

            List<String> recipesList = new ArrayList<>(List.of());
            Map<String, Recipe> recipeNames = new HashMap<>();

            for(Recipe recipe : currentState.getFavoriteRecipes()) {
                recipesList.add(recipe.getName());
                recipeNames.put(recipe.getName(), recipe);
            }

            JList<String> recipes = new JList<>(recipesList.toArray(new String[0]));
            recipes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            final Recipe[] selectedRecipe = new Recipe[1];

            recipes.addListSelectionListener(e -> selectedRecipe[0] = recipeNames.get(recipes.getSelectedValue()));

            JButton selectRecipe = new JButton("select recipe");

            display.add(recipes);
            display.add(selectRecipe);

            JScrollPane scrollPane = new JScrollPane(display);
            recipes.setFont(new Font("Arial", Font.PLAIN, 14));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(scrollPane, BorderLayout.CENTER);
            this.add(scrollPane);

            display.revalidate();

            selectRecipe.addActionListener(e -> {
                favouritesController.openRecipe(selectedRecipe[0], currentState.getUsername());
                currentState.setSelectedRecipe(selectedRecipe[0]);
            });
            this.revalidate();
            state.setFavoriteRecipes(null);
        }

        else if(state.getSelectedRecipe() != null & state.getFavouritesErrorMessage() == null){
            Recipe selectedRecipe = state.getSelectedRecipe();
            String message = "\nCuisine: " + selectedRecipe.getCuisine() + "\nMeal Type: " +
                    selectedRecipe.getMealType() + "\nCalories: " + selectedRecipe.getCalories() + "\nIngredients: "
                    + selectedRecipe.getIngredientsToString();

            int option = JOptionPane.showConfirmDialog(this, message,
                    selectedRecipe.getName(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(option == 0) {
                favouritesController.addToFavourites(state.getSelectedRecipe(), state.getUsername());
            }
            state.setSelectedRecipe(null);
        }
        else if(!Objects.equals(state.getFavouritesErrorMessage(), "")) {
            JOptionPane.showMessageDialog(this, state.getFavouritesErrorMessage());
            state.setFavouritesErrorMessage("");
        }

    }

    public void setFavouritesController(FavouritesController favouritesController) {
        this.favouritesController = favouritesController;
    }

    public static String getViewName() {
        return viewName;
    }
}
