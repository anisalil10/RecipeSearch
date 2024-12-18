package use_cases.signup;

import entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * DAO for the Signup Use Case.
 */
public interface SignupUserDataAccessInterface {

    /**
     * Checks if the given username exists.
     * @param username the username to look for
     * @return true if a user with the given username exists; false otherwise
     */
    boolean existsByName(String username) throws IOException;

    /**
     * Saves the user.
     * @param user the user to save
     */
    void save(User user) throws IOException;
}
