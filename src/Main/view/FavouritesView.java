package Main.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class FavouritesView extends JFrame implements ActionListener, PropertyChangeListener {
    private final JList<String> recipeList;
    private final JButton backButton;

    public FavouritesView() {
        // Set up the JFrame
        setTitle("Favorite Recipes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a JList to display recipes
        recipeList = new JList<>();
        recipeList.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(recipeList);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

        // Create a Back button
        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listener for the Back button
        backButton.addActionListener(this);
    }

    /**
     * Updates the recipe list displayed in the view.
     *
     * @param recipes List of recipe names to display.
     */
    public void updateRecipeList(List<String> recipes) {
        recipeList.setListData(recipes.toArray(new String[0]));
    }

    /**
     * Adds an ActionListener to the Back button.
     *
     * @param listener ActionListener for the Back button.
     */
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle Back button action
        if (e.getSource() == backButton) {
            System.out.println("Back button clicked! Returning to profile...");
            dispose(); // Close the current window
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property change events if needed
        if ("recipeList".equals(evt.getPropertyName())) {
            @SuppressWarnings("unchecked")
            List<String> recipes = (List<String>) evt.getNewValue();
            updateRecipeList(recipes);
        }
    }

    public static void main(String[] args) {
        // Test the FavouritesView
        FavouritesView favouritesView = new FavouritesView();

        // Simulate some recipes
        List<String> recipes = List.of("Pasta", "Salad", "Pizza", "Soup", "Burger");

        // Update the recipe list
        favouritesView.updateRecipeList(recipes);

        // Simulate Back button action
        favouritesView.addBackButtonListener(e -> {
            System.out.println("Back button clicked! Returning to profile...");
            favouritesView.dispose(); // Close the current window
        });

        favouritesView.setVisible(true);
    }
}
