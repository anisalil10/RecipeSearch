package Main.entity;

import java.util.ArrayList;
import java.util.List;


public class User {

    private String username;
    private String password;
    private String userpreferences;
    private List<RecipeId> favouriterecipes;

    public User(String username, String password, String userpreferences) {
        this.username = username;
        this.password = password;
        this.userpreferences = userpreferences;
    }

    public String getUsername() {
        return username;
    }

    public List<RecipeId> getFavouriterecipes() {
        return favouriterecipes;
    }

    public void addtofavourites(RecipeId recipeId) {
        this.favouriterecipes.add(recipeId);
    }

    public String getPassword() {
        return password;
    }

    public String getUserpreferences() {
        return userpreferences;
    }
}