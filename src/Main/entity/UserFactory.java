package entity;

public class UserFactory {

    public User create(String name, String password, String userpreferences) {
        return new User(name, password, userpreferences);
    }
}

