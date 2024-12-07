package Main.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileView extends JFrame {
    private final JButton helloButton;
    private final JButton favouritesButton;

    public ProfileView(String username) {
        // Set up JFrame
        setTitle("Profile");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create "Hello" button
        helloButton = new JButton("Hello, " + username + "!");
        helloButton.setFont(new Font("Arial", Font.BOLD, 14));
        helloButton.setEnabled(false); // Disable it since it's informational
        add(helloButton, BorderLayout.NORTH);

        // Create "View Favourites" button
        favouritesButton = new JButton("View Favourites");
        favouritesButton.setFont(new Font("Arial", Font.PLAIN, 14));
        add(favouritesButton, BorderLayout.CENTER);

        // Add action listener for the favourites button
        favouritesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to FavouritesView
                ProfileView.this.dispose(); // Close the profile view
                FavouritesView favouritesView = new FavouritesView();
                favouritesView.updateRecipeList(java.util.List.of("Pasta", "Salad", "Pizza")); // Sample recipes
                favouritesView.addBackButtonListener(evt -> {
                    favouritesView.dispose();
                    new ProfileView(username).setVisible(true); // Return to profile view
                });
                favouritesView.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        // Test the ProfileView
        SwingUtilities.invokeLater(() -> {
            ProfileView profileView = new ProfileView("John Doe");
            profileView.setVisible(true);
        });
    }
}
