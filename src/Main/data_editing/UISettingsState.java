package Main.entity;

public class UISettingsState {
    private boolean isDarkMode; // true for dark mode, false for light mode

    public boolean isDarkMode() {
        return isDarkMode;
    }

    public void setDarkMode(boolean darkMode) {
        isDarkMode = darkMode;
    }
}
