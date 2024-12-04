package Main.app;

import Main.entity.UISettingsState;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Initialize UISettingsState to manage dark mode
        final UISettingsState uiSettingsState = new UISettingsState();
        uiSettingsState.setDarkMode(false); // Default to light mode (can be toggled later)

        final ReciperSearchBuilder appBuilder = new ReciperSearchBuilder();
        // Added logout use case to the app and passed UISettingsState
        final JFrame application = appBuilder
                .setUISettingsState(uiSettingsState) // Set UISettingsState for dark mode
                .addLoginView()
                .addSignupView()
                .addRecipeSearchView()
                .addRecipeMenuView()
                .addRecipeView()
                .addRecipeMenuUseCase()
                .addOpenRecipeUseCase()
                .addSignupUseCase()
                .addLoginUseCase()
                .addRecipeSearchUseCase()
                .build();

        application.pack();
        application.setVisible(true);
    }
}
