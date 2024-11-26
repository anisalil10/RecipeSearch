import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EditUser {
    public static void main(String[] args) {
        String filePath = "src/main/resources/users.csv"; // Path to the CSV file
        String username = "john_doe";                    // Replace with the target username
        String newPassword = "new_password123";          // Replace with the new password
        String newPreferences = "keto";                  // Replace with new preferences (or "null")

        editUser(filePath, username, newPassword, newPreferences);
    }

    /**
     * Edits a user's password and preferences in the CSV file.
     * @param filePath Path to the CSV file.
     * @param username Username of the user to edit.
     * @param newPassword New password for the user.
     * @param newPreferences New dietary preferences for the user (null if not specified).
     */
    public static void editUser(String filePath, String username, String newPassword, String newPreferences) {
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[0].equals(username)) {
                    // Update the password and preferences
                    columns[1] = newPassword;
                    columns[2] = (newPreferences == null || newPreferences.isEmpty()) ? "null" : newPreferences;
                }
                updatedLines.add(String.join(",", columns));
            }
        } catch (IOException e) {
            System.err.println("Error while reading CSV: " + e.getMessage());
            return;
        }

        // Write the updated data back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            System.out.println("User updated successfully.");
        } catch (IOException e) {
            System.err.println("Error while writing to CSV: " + e.getMessage());
        }
    }
}
