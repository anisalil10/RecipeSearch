import javax.swing.*;

public class SearchView {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Search Recipes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JTextArea resultsArea = new JTextArea(10, 30);

        searchButton.addActionListener(e -> {
            String query = searchField.getText();
            resultsArea.setText("Results for: " + query + "\n1. Recipe A\n2. Recipe B\n3. Recipe C");
        });

        panel.add(new JLabel("Search:"));
        panel.add(searchField);
        panel.add(searchButton);
        panel.add(new JScrollPane(resultsArea));

        frame.add(panel);
        frame.setVisible(true);
    }
}
