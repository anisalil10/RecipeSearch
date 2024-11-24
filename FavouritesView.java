import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FavouritesView {
    private static List<String> favourites = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Favourites");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add Recipe ID");
        JTextField recipeIdField = new JTextField(10);
        JTextArea favouritesArea = new JTextArea(10, 30);

        addButton.addActionListener(e -> {
            String recipeId = recipeIdField.getText();
            favourites.add(recipeId);
            favouritesArea.setText(String.join("\n", favourites));
        });

        panel.add(new JLabel("Recipe ID:"));
        panel.add(recipeIdField);
        panel.add(addButton);
        panel.add(new JScrollPane(favouritesArea));

        frame.add(panel);
        frame.setVisible(true);
    }
}
