import javax.swing.*;

public class SettingsView {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Settings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        JCheckBox darkMode = new JCheckBox("Dark Mode");
        JCheckBox notifications = new JCheckBox("Enable Notifications");

        JButton saveButton = new JButton("Save Settings");
        saveButton.addActionListener(e -> {
            String message = "Dark Mode: " + darkMode.isSelected() + "\nNotifications: " + notifications.isSelected();
            JOptionPane.showMessageDialog(frame, message);
        });

        panel.add(darkMode);
        panel.add(notifications);
        panel.add(saveButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
