package Main.data_access;

import Main.entity.User;
import Main.use_cases.AddToFavourites.AddToFavouritesUserDataAccessInterface;
import Main.use_cases.login.LoginUserDataAccessInterface;
import Main.use_cases.signup.DataAccessException;
import Main.use_cases.signup.SignupUserDataAccessInterface;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface,
        AddToFavouritesUserDataAccessInterface {

    private static final String FILE_PATH = "src/main/resources/users.csv";;
    private String currentUsername;

    @Override
    public boolean existsByName(String username)  {
        List<String> updatedLines = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;

        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] columns = line.split(",");
            if (columns[0].equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(User user) throws IOException {
        String username = user.getUsername();
        String password = user.getPassword();
        String prefernces = user.getUserpreferences();

        if (this.existsByName(user.getUsername())) {
            return;
        }

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String formattedPreferences = (prefernces == null || prefernces.isEmpty())
                    ? "null" : prefernces;
            writer.append(username).append(",")
                    .append(password).append(",")
                    .append(formattedPreferences).append("\n");
            System.out.println("User added");
        } catch (IOException e) {
            System.err.println("Error while adding user: " + e.getMessage());
        }
    }

    @Override
    public String getCurrentUsername() {
        return "";
    }

    @Override
    public void setCurrentUsername(String username) {
        this.currentUsername = username;
    }

    @Override
    public User finduser(String username) {

        User user = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[0].equals(username)) {
                    user = new User(username, columns[1], columns[2]);
                }
            }

        } catch (IOException e) {
            System.err.println("Error while reading CSV: " + e.getMessage());
        }
        return user;
    }

    @Override
    public void updatefavourites(String username, String recipeId) {

    }
}
