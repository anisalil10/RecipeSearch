package Main.app;

import javax.swing.*;

/**
 * The Main class the Recipe Search App.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        final ReciperSearchBuilder appBuilder = new ReciperSearchBuilder();
        final JFrame application = appBuilder
                .addLoginView()
                .addSignupView()
                .addRecipeSearchView()
                .addSignupUseCase()
                .addLoginUseCase()
                .addRecipeSearchUseCase()
                .build();

        application.setSize(1000, 250);
        application.setVisible(true);
    }
}
