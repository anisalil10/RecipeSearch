package entity;

import java.util.ArrayList;


public class User {

    private String username;
    private String password;
    private UserPreferences userpreferences;
    private UISettings uiSettings;
    private ArrayList<Integer> favouriterecipes;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addtofavourites(Recipe recipe) {
        Integer r_id = recipe.getRecipeID();
        this.favouriterecipes.add(r_id);
    }
}