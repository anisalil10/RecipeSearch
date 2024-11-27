package Main.app;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final ReciperSearchBuilder appBuilder = new ReciperSearchBuilder();
        // Added logout use case to the app
        final JFrame application = appBuilder
                .addLoginView()
                .addSignupView()
                .addSignupUseCase()
                .addLoginUseCase()
                .build();

        application.pack();
        application.setVisible(true);
    }
}
