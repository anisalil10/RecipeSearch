package Main.use_cases.AddToFavourites;

import Main.entity.User;

public interface AddToFavouritesUserDataAccessInterface {

    User finduser(String username);

    void updatefavourites(User user);
}
