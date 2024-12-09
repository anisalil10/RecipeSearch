package Main.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Audience:
 * Developers managing user profiles and their associated preferences and favorite recipes.

 * Context:
 * The User class represents a user in the application. It stores information such as username, password,
 * preferences, and a list of favorite recipes.

 * Content:
 * This class includes fields for the username, password, user preferences, and a list of favorite recipes.
 * It provides methods to get user details and manage favorite recipes.

 * Examples:
 * Example usage:
 * User user = new User("john_doe", "password123", "Vegetarian");
 * user.addtofavourites("recipe1");
 * List<String> favourites = user.getFavouriterecipes();

 * Use Cases:
 * - Storing user profiles with their associated data.
 * - Managing a user's favorite recipes.
 * - Retrieving user preferences for recipe search customization.
 */
public class User {

    /**
     * The username of the user.
     */
    private String username;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * The user’s preferences (e.g., dietary restrictions).
     */
    private String userpreferences;

    /**
     * A list of recipe IDs representing the user's favorite recipes.
     */
    private List<String> favouriterecipes;

    /**
     * Constructs a User object with the given username, password, and preferences.
     *
     * @param username       The username of the user.
     * @param password       The password of the user.
     * @param userpreferences The preferences of the user (e.g., dietary restrictions).
     */
    public User(String username, String password, String userpreferences) {
        this.username = username;
        this.password = password;
        this.userpreferences = userpreferences;
        this.favouriterecipes = new ArrayList<>();
    }

    /**
     * Retrieves the username of the user.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the user's list of favorite recipes.
     *
     * @return A list of recipe IDs.
     */
    public List<String> getFavouriterecipes() {
        return favouriterecipes;
    }

    /**
     * Adds a recipe ID to the user's list of favorites.
     *
     * @param recipeId The ID of the recipe to add to favorites.
     */
    public void addtofavourites(String recipeId) {
        this.favouriterecipes.add(recipeId);
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieves the user's preferences.
     *
     * @return The user preferences.
     */
    public String getUserpreferences() {
        return userpreferences;
    }

    /**
     * Sets the user's list of favorite recipes.
     *
     * @param favouriterecipes The list of recipe IDs to set as favorites.
     */
    public void setFavouriterecipes(List<String> favouriterecipes) {
        this.favouriterecipes = favouriterecipes;
    }
}
