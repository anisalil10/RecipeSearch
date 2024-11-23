package use_cases.AddToFavourites;

import entity.User;

public interface AddToFavouritesUserDataAccessInterface {

    void addToFavourites(User user, int recipe_id);
}
