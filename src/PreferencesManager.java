public class PreferencesManager {
    import java.util.Scanner;

    public class PreferencesManager {

        public static void updateDietaryPreferences(User user) {
            Scanner scanner = new Scanner(System.in);
            UserPreferences preferences = user.getPreferences();

            System.out.println("Current Preferences: " + preferences);

            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Add a dietary restriction");
                System.out.println("2. Remove a dietary restriction");
                System.out.println("3. View current preferences");
                System.out.println("4. Save and exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the dietary restriction to add: ");
                        String addRestriction = scanner.nextLine();
                        preferences.addDietaryRestriction(addRestriction);
                        System.out.println("Added: " + addRestriction);
                        break;

                    case 2:
                        System.out.print("Enter the dietary restriction to remove: ");
                        String removeRestriction = scanner.nextLine();
                        preferences.removeDietaryRestriction(removeRestriction);
                        System.out.println("Removed: " + removeRestriction);
                        break;

                    case 3:
                        System.out.println("Current Preferences: " + preferences);
                        break;

                    case 4:
                        System.out.println("Preferences updated: " + preferences);
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

}
