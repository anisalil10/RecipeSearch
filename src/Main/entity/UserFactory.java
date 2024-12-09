package Main.entity;

/**
 * Audience:
 * Developers responsible for creating User objects in the application, ensuring
 * a centralized and consistent method for instantiating users.

 * Context:
 * The UserFactory class provides a factory method for creating User objects.
 * This ensures that all User instances are created in a standardized way.

 * Content:
 * This class includes a single method, `create`, which takes the required parameters
 * to initialize a User object and returns a new User instance.

 * Examples:
 * Example usage:
 * UserFactory factory = new UserFactory();
 * User user = factory.create("john_doe", "password123", "Vegetarian");

 * Use Cases:
 * - Creating new User objects during user registration.
 * - Ensuring a standardized method for creating User instances.
 */
public class UserFactory {

    /**
     * Creates a new User object with the specified parameters.
     *
     * @param name             The username of the user.
     * @param password         The password of the user.
     * @param userpreferences  The preferences of the user (e.g., dietary restrictions).
     * @return A new User object with the specified attributes.
     */
    public User create(String name, String password, String userpreferences) {
        return new User(name, password, userpreferences);
    }
}
