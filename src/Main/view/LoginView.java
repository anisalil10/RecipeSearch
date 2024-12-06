package Main.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Main.interface_adapter.login.LoginController;
import Main.interface_adapter.login.LoginState;
import Main.interface_adapter.login.LoginViewModel;

/**
 * The View for when the user is logging into the program.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    private final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    private final JButton logIn;
    private final JButton goToSignUp;
    private final JButton cancel;
    private LoginController loginController;

    private boolean darkMode = false; // New field for dark mode

    public LoginView(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), usernameInputField);
        final LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);

        final JPanel buttons = new JPanel();
        goToSignUp = new JButton("Go To Sign Up");
        buttons.add(goToSignUp);
        logIn = new JButton("Log In");
        buttons.add(logIn);
        cancel = new JButton("Cancel");
        buttons.add(cancel);

        logIn.addActionListener(evt -> {
            if (evt.getSource().equals(logIn)) {
                final LoginState currentState = loginViewModel.getState();
                try {
                    loginController.execute(
                            currentState.getUsername(),
                            currentState.getPassword()
                    );
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        goToSignUp.addActionListener(evt -> {
            loginController.goToSignup();
        });

        cancel.addActionListener(this);

        usernameInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText());
                loginViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoginState currentState = loginViewModel.getState();
                currentState.setPassword(new String(passwordInputField.getPassword()));
                loginViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        this.add(title);
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(passwordInfo);
        this.add(buttons);

        applyDarkMode(); // Apply initial dark mode state
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
        usernameErrorField.setText(state.getLoginError());
    }

    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
        passwordInputField.setText(state.getPassword());
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    // New method to toggle dark mode
    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
        applyDarkMode();
    }

    // Apply dark mode styles dynamically
    private void applyDarkMode() {
        if (darkMode) {
            setBackground(Color.DARK_GRAY);
            usernameInputField.setBackground(Color.BLACK);
            usernameInputField.setForeground(Color.WHITE);
            passwordInputField.setBackground(Color.BLACK);
            passwordInputField.setForeground(Color.WHITE);
            usernameErrorField.setForeground(Color.RED);
            passwordErrorField.setForeground(Color.RED);
            logIn.setBackground(Color.GRAY);
            logIn.setForeground(Color.WHITE);
            cancel.setBackground(Color.GRAY);
            cancel.setForeground(Color.WHITE);
        } else {
            setBackground(Color.LIGHT_GRAY);
            usernameInputField.setBackground(Color.WHITE);
            usernameInputField.setForeground(Color.BLACK);
            passwordInputField.setBackground(Color.WHITE);
            passwordInputField.setForeground(Color.BLACK);
            usernameErrorField.setForeground(Color.BLACK);
            passwordErrorField.setForeground(Color.BLACK);
            logIn.setBackground(Color.WHITE);
            logIn.setForeground(Color.BLACK);
            cancel.setBackground(Color.WHITE);
            cancel.setForeground(Color.BLACK);
        }
        repaint();
        revalidate();
    }
}
