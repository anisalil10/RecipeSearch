import java.io.FileWriter;
import java.io.IOException;

public class AddNewUser {
    public static void main(String[] args) {
        String filePath = "src/main/resources/users.csv"; // Path to the CSV file
        String username = "new_user";                    // Replace with user input
        String password = "new_password";                // Replace with user input
        String preferences = "vegan";                    // Replace with user input (or "null")

        addUser(filePath, username, password, preferences);
    }

    /**
     * Adds a new user to the CSV file.
     * @param filePath Path to the CSV file.
     * @param username Username of the user.
     * @param password Password of the user.
     * @param preferences Dietary preferences (null if not specified).
     */
    public static void addUser(String filePath, String username, String password, String preferences) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            String formattedPreferences = (preferences == null || preferences.isEmpty()) ? "null" : preferences;
            writer.append(username).append(",")
                    .append(password).append(",")
                    .append(formattedPreferences).append("\n");
            System.out.println("User added successfully.");
        } catch (IOException e) {
            System.err.println("Error while adding user: " + e.getMessage());
        }
    }
}
