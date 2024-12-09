package view;

import entity.Recipe;
import interface_adapter.popular_recipes.PopularRecipesController;
import interface_adapter.popular_recipes.PopularRecipesState;
import interface_adapter.popular_recipes.PopularRecipesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;

public class PopularRecipesView extends JPanel implements ActionListener, PropertyChangeListener {
    private static final String viewName = "Popular Recipes";
    private final PopularRecipesViewModel popularRecipesViewModel;

    private final JPanel display;
    private final JButton back;

    private PopularRecipesController popularRecipesController;

    public PopularRecipesView(PopularRecipesViewModel popularRecipesViewModel) {
        this.popularRecipesViewModel = popularRecipesViewModel;
        this.popularRecipesViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Recipe Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        display = new JPanel();

        final JPanel buttons = new JPanel();

        back = new JButton("Back");
        buttons.add(back);

        back.addActionListener(e -> {
            final PopularRecipesState popularRecipesState = popularRecipesViewModel.getState();

            display.removeAll();
            display.revalidate();
            popularRecipesState.setAllNull();
            popularRecipesController.back(popularRecipesState.getUsername());
        });

        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final PopularRecipesState state = (PopularRecipesState) evt.getNewValue();

        if(state.getTopRecipes() != null) {
            display.removeAll();
            display.revalidate();
            final PopularRecipesState currentState = popularRecipesViewModel.getState();

            List<String> recipesList = new ArrayList<>(List.of());
            Map<String, Recipe> recipeNames = new HashMap<>();

            for(Recipe recipe : currentState.getTopRecipes()) {
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
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            this.add(scrollPane);

            display.revalidate();

            selectRecipe.addActionListener(e -> {
                popularRecipesController.openRecipe(selectedRecipe[0], currentState.getUsername());
                currentState.setSelectedRecipe(selectedRecipe[0]);
            });
            this.revalidate();
            state.setTopRecipes(null);
        }

        if(state.getFavouritesErrorMessage() != null) {
            JOptionPane.showMessageDialog(this, state.getFavouritesErrorMessage());
            state.setFavouritesErrorMessage(null);
        }

        else if(state.getSelectedRecipe() != null & state.getFavouritesErrorMessage() == null){
            Recipe selectedRecipe = state.getSelectedRecipe();
            String message = "\nCuisine: " + selectedRecipe.getCuisine() + "\nMeal Type: " +
                    selectedRecipe.getMealType() + "\nCalories: " + selectedRecipe.getCalories() + "\nIngredients: "
                    + selectedRecipe.getIngredientsToString();

            int option = JOptionPane.showConfirmDialog(this, message,
                    selectedRecipe.getName(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(option == 0) {
                popularRecipesController.addToFavourites(state.getSelectedRecipe(), state.getUsername());
            }
            state.setSelectedRecipe(null);
        }
    }

    public static String getViewName() {
        return viewName;
    }

    public void setPopularRecipesController(PopularRecipesController popularRecipesController) {
        this.popularRecipesController = popularRecipesController;
    }
}
