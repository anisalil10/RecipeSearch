import java.util.ArrayList;


public class User {

    private String username;
    private String password;
    private String email;
    private Userpreferences userpreferences;
    private UISettings uiSettings;
    private ArrayList<Recipe> favouriterecipes;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}