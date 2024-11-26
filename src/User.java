public class User {

    import java.util.List;

    public class User {
        private String username;
        private String password;
        private String email;
        private UserPreferences preferences;

        public User(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.preferences = new UserPreferences();
        }

        public UserPreferences getPreferences() {
            return preferences;
        }

        public void updatePreferences(UserPreferences newPreferences) {
            this.preferences = newPreferences;
        }
    }

}
