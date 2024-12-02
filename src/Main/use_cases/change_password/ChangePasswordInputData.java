package Main.use_cases.change_password;

/**
 * The input data for the Change Password Use Case.
 */
public class ChangePasswordInputData {

    private final String password;
    private final String username;
    private final String userpreferences;

    public ChangePasswordInputData(String password, String username, String userpreferences) {
        this.password = password;
        this.username = username;
        this.userpreferences = userpreferences;
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }

    public String getUserpreferences() {
        return userpreferences;
    }
}
