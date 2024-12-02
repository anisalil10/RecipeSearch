package Main.use_cases.AddToFavourites;

import Main.entity.User;

public interface AddToFavouritesUserDataAccessInterface {

    void updatefavourites(String username, String recipeId);
}
