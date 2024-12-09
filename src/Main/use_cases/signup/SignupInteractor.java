package use_cases.signup;

import entity.User;
import entity.UserFactory;

import java.io.IOException;

/**
 * The Signup Interactor.
 */
public class SignupInteractor implements SignupInputBoundary {

    private final SignupUserDataAccessInterface userDataAccessObject;
    private final SignupOutputBoundary userPresenter;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
    }

    @Override
    public void execute(SignupInputData signupInputData) throws IOException {
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        }
        else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        }
        else if(signupInputData.getUsername().isEmpty()) {
            userPresenter.prepareFailView("Username Blank");
        }
        else if(signupInputData.getPassword().isEmpty()) {
            userPresenter.prepareFailView("Enter a Password");
        }
        else if(signupInputData.getRepeatPassword().isEmpty()) {
            userPresenter.prepareFailView("Repeat Password");
        }
        else if(signupInputData.getUserPreferences().isEmpty()) {
            userPresenter.prepareFailView("Enter a dietary preference");
        }
        else {
            final User user = new User(signupInputData.getUsername(), signupInputData.getPassword(),
                    signupInputData.getUserPreferences());

            userDataAccessObject.save(user);

            final SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(),
                    user.getUserpreferences(), false);
            userPresenter.prepareSuccessView(signupOutputData);


        }
    }
    @Override
    public void switchToLoginView() {
        userPresenter.switchToLoginView();
    }
}
