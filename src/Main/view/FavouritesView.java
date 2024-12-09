package view;

import entity.Recipe;
import interface_adapter.popular_recipes.PopularRecipesState;
import interface_adapter.viewfavourites.FavouritesController;
import interface_adapter.viewfavourites.FavouritesState;
import interface_adapter.viewfavourites.FavouritesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavouritesView extends JPanel implements ActionListener, PropertyChangeListener {

    private static final String viewName = "Favorite Recipes";

    private final FavouritesViewModel favouritesViewModel;
    private FavouritesController favouritesController;

    private final JPanel display;
    private final JPanel buttons;

    private final JButton backButton;

    public FavouritesView(FavouritesViewModel favouritesViewModel) {
        this.favouritesViewModel = favouritesViewModel;
        this.favouritesViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Favourite Recipes");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttons = new JPanel();

        // Create a Back button
        backButton = new JButton("Back");
        buttons.add(backButton);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        display = new JPanel();
        // Add action listener for the Back button
        backButton.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle Back button action
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property change events if needed
        final FavouritesState state = (FavouritesState) evt.getNewValue();

        if(state.isOpenFavourites()) {
            favouritesController.getFavoriteRecipes(state.getUsername());
        }

        if(state.getFavoriteRecipes() != null) {
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

            recipes.addListSelectionListener(e -> {
                selectedRecipe[0] = recipeNames.get(recipes.getSelectedValue());
            });

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

    }

    public void setFavouritesController(FavouritesController favouritesController) {
        this.favouritesController = favouritesController;
    }

    public static String getViewName() {
        return viewName;
    }
}
