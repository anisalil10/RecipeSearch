package Main.view;

import Main.entity.Recipe;
import Main.interface_adapter.get_search_parameters.GetSearchParametersController;
import Main.interface_adapter.get_search_parameters.GetSearchParametersState;
import Main.interface_adapter.get_search_parameters.GetSearchParametersViewModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;

public class RecipeSearchView extends JPanel implements PropertyChangeListener {

    private static final String viewName = "Search Recipes";

    private final GetSearchParametersViewModel getSearchParametersViewModel;
    private final JTextField searchInputField = new JTextField(15);
    private final JComboBox<String> cuisineDropdown;
    private final JComboBox<String> mealTypeDropdown;
    private GetSearchParametersController getSearchParametersController;
    private UISettingsState uiSettingsState;

    private DefaultListModel<String> recipeListModel; // Dynamic list model for recipes

    private final JButton search;
    private final JButton cancel;
    private JButton toggleDarkMode;

    private boolean darkMode = false; // Flag for dark mode

    private static final String[] CUISINE_OPTIONS = { " ",
            "American", "Asian", "British", "Caribbean", "Central Europe",
            "Chinese", "Eastern Europe", "French", "Indian", "Italian",
            "Japanese", "Kosher", "Mediterranean", "Mexican", "Middle Eastern",
            "Nordic", "South American", "South East Asian"
    };

    private static final String[] MEAL_TYPE_OPTIONS = {
            " ", "Breakfast", "Dinner", "Lunch", "Snack", "Teatime"
    };

    public RecipeSearchView(GetSearchParametersViewModel getSearchParametersViewModel) {
        this.getSearchParametersViewModel = getSearchParametersViewModel;
        this.getSearchParametersViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(GetSearchParametersViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel searchInfo = new LabelTextPanel(
                new JLabel(GetSearchParametersViewModel.SEARCH), searchInputField);

        final JPanel box = new JPanel();
        final JPanel buttons = new JPanel();
        final JPanel cuisine = new JPanel();
        final JPanel mealType = new JPanel();

        cuisine.setLayout(new BoxLayout(cuisine, BoxLayout.Y_AXIS));
        mealType.setLayout(new BoxLayout(mealType, BoxLayout.Y_AXIS));

        cuisineDropdown = new JComboBox<>(CUISINE_OPTIONS);
        mealTypeDropdown = new JComboBox<>(MEAL_TYPE_OPTIONS);

        cuisineDropdown.setMaximumSize(cuisineDropdown.getPreferredSize());
        cuisineDropdown.setAlignmentX(Component.CENTER_ALIGNMENT);
        cuisineDropdown.setLayout(new BoxLayout(cuisineDropdown, BoxLayout.Y_AXIS));

        mealTypeDropdown.setMaximumSize(mealTypeDropdown.getPreferredSize());
        mealTypeDropdown.setAlignmentX(Component.CENTER_ALIGNMENT);
        mealTypeDropdown.setLayout(new BoxLayout(mealTypeDropdown, BoxLayout.Y_AXIS));

        final JLabel cuisineLbl = new JLabel("Choose Cuisine");
        cuisineLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel mealTypelbl = new JLabel("Choose Meal Type");
        mealTypelbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        cuisine.add(cuisineLbl);
        cuisine.add(cuisineDropdown);

        mealType.add(mealTypelbl);
        mealType.add(mealTypeDropdown);

        search = new JButton(GetSearchParametersViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(search);

        cancel = new JButton("Cancel");
        buttons.add(cancel);

//        toggleDarkMode = new JButton("Toggle Dark Mode");
//        buttons.add(toggleDarkMode);

        search.addActionListener(evt -> {
                final GetSearchParametersState currentState = getSearchParametersViewModel.getState();
                box.removeAll();

                currentState.setQuery(searchInputField.getText());
                currentState.setCuisine(Objects.requireNonNull(
                        cuisineDropdown.getSelectedItem()).toString().toLowerCase());
                currentState.setMealType(Objects.requireNonNull(
                        mealTypeDropdown.getSelectedItem().toString().toLowerCase()));

                getSearchParametersController.execute(
                        currentState.getQuery(),
                        currentState.getCuisine(),
                        currentState.getMealType(),
                        currentState.getDiet()
                );

                if(currentState.getQueryError() == null) {
                    List<String> recipesList = new ArrayList<>(List.of());
                    Map<String, Recipe> recipeNames = new HashMap<>();

                    for(Recipe recipe : currentState.getRecipeList()) {
                        recipesList.add(recipe.getName());
                        recipeNames.put(recipe.getName(), recipe);
                    }

                    recipeListModel = new DefaultListModel<>();

                    JList<String> recipes = new JList<>(recipesList.toArray(new String[0]));
                    recipes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                    final Recipe[] selectedRecipe = new Recipe[1];

                    recipes.addListSelectionListener(e -> {
                        selectedRecipe[0] = recipeNames.get(recipes.getSelectedValue());
                    });

                    JButton selectRecipe = new JButton("select recipe");

                    box.add(recipes);
                    box.add(selectRecipe);

                    JScrollPane scrollPane = new JScrollPane(box);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    this.add(scrollPane);

                    box.revalidate();

                    selectRecipe.addActionListener(e -> {
                        getSearchParametersController.openRecipe(selectedRecipe[0], currentState.getUsername());
                        currentState.setSelectedRecipe(selectedRecipe[0]);
                    });
                    this.revalidate();
                }
                this.revalidate();
        });



//        toggleDarkMode = new JButton("Toggle Dark Mode");
//        toggleDarkMode.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        toggleDarkMode.addActionListener(evt -> {
//            boolean isDarkMode = uiSettingsState.isDarkMode();
//            uiSettingsState.setDarkMode(!isDarkMode); // Toggle dark mode
//            this.applyDarkMode();
//        });

        cancel.addActionListener(evt -> {
            searchInputField.setText(" "); // Clear the search field
            cuisineDropdown.setSelectedIndex(0); // Reset dropdown to default
            mealTypeDropdown.setSelectedIndex(0); // Reset dropdown to default
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(searchInfo);
        this.add(cuisine);
        this.add(mealType);
        this.add(buttons);
        this.add(box);

//        applyDarkMode(); // Apply initial dark mode styling
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final GetSearchParametersState state = (GetSearchParametersState) evt.getNewValue();
        searchInputField.setText(state.getQuery());
        cuisineDropdown.setSelectedItem(state.getCuisine());
        mealTypeDropdown.setSelectedItem(state.getMealType());
        if(state.getQueryError() != null) {
            JOptionPane.showMessageDialog(this, state.getQueryError());
        } else if(state.getAddToFavouritesMessage() != "") {
            JOptionPane.showMessageDialog(this, state.getAddToFavouritesMessage());
            state.setAddToFavouritesMessage("");
        } else if(state.getSelectedRecipe() != null){
            Recipe selectedRecipe = state.getSelectedRecipe();
            String message = "\nCuisine: " + selectedRecipe.getCuisine() + "\nMeal Type: " +
                    selectedRecipe.getMealType() + "\nCalories: " + selectedRecipe.getCalories() + "\nIngredients: "
                    + selectedRecipe.getIngredientsToString();

            JOptionPane jop = new JOptionPane();
            int option = jop.showConfirmDialog(this, message,
                    selectedRecipe.getName(), 0, 3);

            if(option == 0) {
                getSearchParametersController.addToFavourites(state.getSelectedRecipe(), state.getUsername());
            }
        }

    }

    public static String getViewName() {
        return viewName;
    }

    public void setGetSearchParametersController(GetSearchParametersController controller) {
        this.getSearchParametersController = controller;
    }
//
//    // New method to toggle dark mode
//    public void setDarkMode(boolean darkMode) {
//        this.darkMode = darkMode;
//        applyDarkMode();
//    }
//
//    // Apply dark mode styles dynamically
////    private void applyDarkMode() {
////        if (darkMode) {
////            setBackground(Color.DARK_GRAY);
////            searchInputField.setBackground(Color.BLACK);
////            searchInputField.setForeground(Color.WHITE);
////            cuisineDropdown.setBackground(Color.BLACK);
////            cuisineDropdown.setForeground(Color.WHITE);
////            mealTypeDropdown.setBackground(Color.BLACK);
////            mealTypeDropdown.setForeground(Color.WHITE);
////            search.setBackground(Color.GRAY);
////            search.setForeground(Color.WHITE);
////            cancel.setBackground(Color.GRAY);
////            cancel.setForeground(Color.WHITE);
////        } else {
////            setBackground(Color.WHITE);
////            searchInputField.setBackground(Color.WHITE);
////            searchInputField.setForeground(Color.BLACK);
////            cuisineDropdown.setBackground(Color.WHITE);
////            cuisineDropdown.setForeground(Color.BLACK);
////            mealTypeDropdown.setBackground(Color.WHITE);
////            mealTypeDropdown.setForeground(Color.BLACK);
////            search.setBackground(Color.WHITE);
////            search.setForeground(Color.BLACK);
////            cancel.setBackground(Color.WHITE);
////            cancel.setForeground(Color.BLACK);
////        }
////        repaint();
////        revalidate();
// }

}
