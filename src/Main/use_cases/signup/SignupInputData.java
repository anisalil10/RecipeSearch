package use_cases.signup;

import entity.UserPreferences;

/**
 * The Input Data for the Signup Use Case.
 */
public class SignupInputData {

    private final String username;
    private final String password;
    private final String repeatPassword;
    private final String userPreferences;

    public SignupInputData(String username, String password, String repeatPassword, String userPreferences) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.userPreferences = userPreferences;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getUserPreferences() {
        return userPreferences;
    }
}
