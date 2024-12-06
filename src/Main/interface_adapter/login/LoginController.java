package Main.interface_adapter.login;

import Main.use_cases.login.LoginInputBoundary;
import Main.use_cases.login.LoginInputData;

import java.io.IOException;

/**
 * The controller for the Login Use Case.
 */
public class LoginController {

    private final LoginInputBoundary loginUseCaseInteractor;

    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * Executes the Login Use Case.
     * @param username the username of the user logging in
     * @param password the password of the user logging in
     */
    public void execute(String username, String password) throws IOException {
        final LoginInputData loginInputData = new LoginInputData(
                username, password);

        loginUseCaseInteractor.execute(loginInputData);
    }

    public void goToSignup() {loginUseCaseInteractor.goToSignup();}
}
