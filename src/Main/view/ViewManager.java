package Main.view;

import Main.interface_adapter.ViewManagerModel;
import Main.entity.UISettingsState;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View Manager for the program. It listens for property change events
 * in the ViewManagerModel and updates which View should be visible.
 * It also updates the UI theme based on the global dark mode setting.
 */
public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private final ViewManagerModel viewManagerModel;
    private final UISettingsState uiSettingsState; // Manage UI settings like dark mode.

    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel, UISettingsState uiSettingsState) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.uiSettingsState = uiSettingsState;

        this.viewManagerModel.addPropertyChangeListener(this);
        this.uiSettingsState.addPropertyChangeListener(evt -> {
            if ("darkMode".equals(evt.getPropertyName())) {
                updateTheme(); // Update theme when dark mode setting changes.
            }
        });

        updateTheme(); // Apply the initial theme based on current dark mode setting.
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            final String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
        }
    }

    /**
     * Updates the UI theme for all views based on the dark mode setting.
     */
    private void updateTheme() {
        Color backgroundColor = uiSettingsState.isDarkMode() ? Color.DARK_GRAY : Color.LIGHT_GRAY;
        Color foregroundColor = uiSettingsState.isDarkMode() ? Color.WHITE : Color.BLACK;

        // Set background color for the main panel
        views.setBackground(backgroundColor);

        // Iterate over child components to update their appearance
        for (Component component : views.getComponents()) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                panel.setBackground(backgroundColor);
                panel.setForeground(foregroundColor);
                updateChildComponents(panel, backgroundColor, foregroundColor);
            }
        }
    }

    /**
     * Recursively updates background and foreground colors of child components.
     *
     * @param parent           The parent component whose children need updates.
     * @param backgroundColor  The background color to apply.
     * @param foregroundColor  The foreground color to apply.
     */
    private void updateChildComponents(Container parent, Color backgroundColor, Color foregroundColor) {
        for (Component child : parent.getComponents()) {
            child.setBackground(backgroundColor);
            child.setForeground(foregroundColor);
            if (child instanceof Container) {
                updateChildComponents((Container) child, backgroundColor, foregroundColor);
            }
        }
    }
}
