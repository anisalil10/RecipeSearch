import javax.swing.*;

public class ProfileView {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Profile");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        JLabel nameLabel = new JLabel("Name: John Doe");
        JLabel emailLabel = new JLabel("Email: john@example.com");
        JLabel preferencesLabel = new JLabel("Preferences: Vegan, Gluten-Free");

        panel.add(nameLabel);
        panel.add(emailLabel);
        panel.add(preferencesLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
