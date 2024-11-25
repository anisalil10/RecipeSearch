package Main.entity;

import java.util.ArrayList;


public class User {

    private String username;
    private String password;
    private UserPreferences userpreferences;
    private UISettings uiSettings;
    private ArrayList<RecipeId> favouriterecipes;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void addtofavourites(RecipeId recipeId) {
        this.favouriterecipes.add(recipeId);
    }
}