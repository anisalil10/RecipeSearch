package Main.entity;

import java.util.ArrayList;
import java.util.List;


public class User {

    private String username;
    private String password;
    private String userpreferences;
    private List<String> favouriterecipes;

    public User(String username, String password, String userpreferences) {
        this.username = username;
        this.password = password;
        this.userpreferences = userpreferences;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getFavouriterecipes() {
        return favouriterecipes;
    }

    public void addtofavourites(String recipeId) {
        this.favouriterecipes.add(recipeId);
    }

    public String getPassword() {
        return password;
    }

    public String getUserpreferences() {
        return userpreferences;
    }
}