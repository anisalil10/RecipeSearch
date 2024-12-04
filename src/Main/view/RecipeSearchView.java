package Main.view;

import Main.entity.Recipe;
import Main.interface_adapter.get_search_parameters.GetSearchParametersController;
import Main.interface_adapter.get_search_parameters.GetSearchParametersState;
import Main.interface_adapter.get_search_parameters.GetSearchParametersViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecipeSearchView extends JPanel implements PropertyChangeListener {

    private static final String viewName = "Search Recipes";

    private final GetSearchParametersViewModel getSearchParametersViewModel;
    private final JTextField searchInputField = new JTextField(15);
    private final JComboBox<String> cuisineDropdown;
    private final JComboBox<String> mealTypeDropdown;
    private GetSearchParametersController getSearchParametersController;

    private final JButton search;
    private final JButton cancel;

    private boolean darkMode = false; // Flag for dark mode

    private static final String[] CUISINE_OPTIONS = {
            "American", "Asian", "British", "Caribbean", "Central Europe",
            "Chinese", "Eastern Europe", "French", "Indian", "Italian",
            "Japanese", "Kosher", "Mediterranean", "Mexican", "Middle Eastern",
            "Nordic", "South American", "South East Asian"
    };

    private static final String[] MEAL_TYPE_OPTIONS = {
            "Breakfast", "Dinner", "Lunch", "Snack", "Teatime"
    };
//
//    public RecipeSearchView(GetSearchParametersViewModel getSearchParametersViewModel, UISettingsState uiSettingsState) {
//
//    recipeListModel = new DefaultListModel<>();
//    recipeList = new JList<>(recipeListModel);
//        recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//    recipeListModel = new DefaultListModel<>();
//    recipeList = new JList<>(recipeListModel);
//        recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Single selection
//
//    JScrollPane scrollPane = new JScrollPane(recipeList);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        this.add(scrollPane);

    public RecipeSearchView(GetSearchParametersViewModel getSearchParametersViewModel) {
        this.getSearchParametersViewModel = getSearchParametersViewModel;
        this.getSearchParametersViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(GetSearchParametersViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel cuisine = new JPanel();
        final JPanel mealType = new JPanel();

        cuisine.setLayout(new BoxLayout(cuisine, BoxLayout.Y_AXIS));
        mealType.setLayout(new BoxLayout(mealType, BoxLayout.Y_AXIS));

        cuisineDropdown = new JComboBox<>(CUISINE_OPTIONS);
        mealTypeDropdown = new JComboBox<>(MEAL_TYPE_OPTIONS);

        final JLabel cuisineLbl = new JLabel("Choose Cuisine");
        final JLabel mealTypelbl = new JLabel("Choose Meal Type");

        cuisine.add(cuisineLbl);
        cuisine.add(cuisineDropdown);

        mealType.add(mealTypelbl);
        mealType.add(mealTypeDropdown);

        final LabelTextPanel searchInfo = new LabelTextPanel(
                new JLabel(GetSearchParametersViewModel.SEARCH), searchInputField);

        final JPanel buttons = new JPanel();

        search = new JButton(GetSearchParametersViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(search);

        cancel = new JButton("Cancel");
        buttons.add(cancel);

        final JPanel box = new JPanel();

        search.addActionListener(evt -> {
            if (evt.getSource().equals(search)) {
                final GetSearchParametersState currentState = getSearchParametersViewModel.getState();

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

                List<String> recipesList = new ArrayList<>(List.of());

                for(Recipe recipe : currentState.getRecipeList()) {
                    recipesList.add(recipe.getName() + "\n" + "   " + recipe.getMealType());
                }

                JList<String> recipes = new JList<>(recipesList.toArray(new String[0]));
                box.add(recipes);

                box.revalidate();
            }
        });


        cancel.addActionListener(evt -> {
            searchInputField.setText(""); // Clear the search field
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

        applyDarkMode(); // Apply initial dark mode styling
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final GetSearchParametersState state = (GetSearchParametersState) evt.getNewValue();
        searchInputField.setText(state.getQuery());
        cuisineDropdown.setSelectedItem(state.getCuisine());
        mealTypeDropdown.setSelectedItem(state.getMealType());
    }

    public static String getViewName() {
        return viewName;
    }

    public void setGetSearchParametersController(GetSearchParametersController controller) {
        this.getSearchParametersController = controller;
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
            searchInputField.setBackground(Color.BLACK);
            searchInputField.setForeground(Color.WHITE);
            cuisineDropdown.setBackground(Color.BLACK);
            cuisineDropdown.setForeground(Color.WHITE);
            mealTypeDropdown.setBackground(Color.BLACK);
            mealTypeDropdown.setForeground(Color.WHITE);
            search.setBackground(Color.GRAY);
            search.setForeground(Color.WHITE);
            cancel.setBackground(Color.GRAY);
            cancel.setForeground(Color.WHITE);
        } else {
            setBackground(Color.LIGHT_GRAY);
            searchInputField.setBackground(Color.WHITE);
            searchInputField.setForeground(Color.BLACK);
            cuisineDropdown.setBackground(Color.WHITE);
            cuisineDropdown.setForeground(Color.BLACK);
            mealTypeDropdown.setBackground(Color.WHITE);
            mealTypeDropdown.setForeground(Color.BLACK);
            search.setBackground(Color.WHITE);
            search.setForeground(Color.BLACK);
            cancel.setBackground(Color.WHITE);
            cancel.setForeground(Color.BLACK);
        }
        repaint();
        revalidate();
    }
}
