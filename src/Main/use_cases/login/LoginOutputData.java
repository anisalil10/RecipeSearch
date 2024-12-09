package use_cases.login;

/**
 * Output Data for the Login Use Case.
 */
public class LoginOutputData {

    private final String username;
    private final String userpreferences;
    private final boolean useCaseFailed;

    public LoginOutputData(String username, String userpreferences, boolean useCaseFailed) {
        this.username = username;
        this.userpreferences = userpreferences;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public String getUserpreferences() {
        return userpreferences;
    }
}
