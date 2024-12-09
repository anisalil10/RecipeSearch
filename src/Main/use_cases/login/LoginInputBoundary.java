package use_cases.login;

import java.io.IOException;

/**
 * Input Boundary for actions which are related to logging in.
 */
public interface LoginInputBoundary {

    /**
     * Executes the login use case.
     * @param loginInputData the input data
     */
    void execute(LoginInputData loginInputData) throws IOException;

    void goToSignup();
}
