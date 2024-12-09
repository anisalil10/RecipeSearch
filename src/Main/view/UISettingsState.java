package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UISettingsState {
    private boolean isDarkMode; // true for dark mode, false for light mode

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public boolean isDarkMode() {
        return isDarkMode;
    }

    public void setDarkMode(boolean darkMode) {
        boolean oldDarkMode = this.isDarkMode;
        this.isDarkMode = darkMode;
        // Notify listeners of the change
        support.firePropertyChange("darkMode", oldDarkMode, darkMode);
    }

    // Add PropertyChangeListener for dynamic updates
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
