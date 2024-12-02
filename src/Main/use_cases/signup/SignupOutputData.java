package Main.use_cases.signup;

/**
 * Output Data for the Signup Use Case.
 */
public class SignupOutputData {

    private final String username;
    private final String userpreferences;

    private final boolean useCaseFailed;

    public SignupOutputData(String username, String userpreferences, boolean useCaseFailed) {
        this.username = username;
        this.userpreferences = userpreferences;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public String getUserpreferences() {
        return userpreferences;
    }
}
