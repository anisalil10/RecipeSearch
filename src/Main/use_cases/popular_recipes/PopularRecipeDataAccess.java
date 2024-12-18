package use_cases.popular_recipes;

import entity.Recipe;

import java.util.List;

public interface PopularRecipeDataAccess {

    List<Recipe> getTopRecipes();

    void updateFavourites(String username, String recipeId);

    boolean recipeInFavourites(String username, String recipeID);

    String getDiet(String username);
}
