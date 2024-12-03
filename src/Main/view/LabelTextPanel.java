package Main.view;

import javax.swing.*;
import java.awt.*;

/**
 * A panel containing a label and a text field.
 */
class LabelTextPanel extends JPanel {
    private boolean darkMode;

    LabelTextPanel(JLabel label, JTextField textField, boolean darkMode) {
        this.darkMode = darkMode;
        applyTheme(label, textField);
        this.add(label);
        this.add(textField);
    }

    /**
     * Apply the theme based on the dark mode flag.
     */
    private void applyTheme(JLabel label, JTextField textField) {
        if (darkMode) {
            this.setBackground(Color.DARK_GRAY);
            label.setForeground(Color.WHITE);
            textField.setBackground(Color.GRAY);
            textField.setForeground(Color.WHITE);
            textField.setCaretColor(Color.WHITE);
        } else {
            this.setBackground(Color.LIGHT_GRAY);
            label.setForeground(Color.BLACK);
            textField.setBackground(Color.WHITE);
            textField.setForeground(Color.BLACK);
            textField.setCaretColor(Color.BLACK);
        }
    }

    /**
     * Update the panel's theme.
     */
    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
        // Update components with the new theme
        for (Component component : this.getComponents()) {
            if (component instanceof JLabel) {
                applyTheme((JLabel) component, null);
            } else if (component instanceof JTextField) {
                applyTheme(null, (JTextField) component);
            }
        }
        this.repaint();
        this.revalidate();
    }
}
