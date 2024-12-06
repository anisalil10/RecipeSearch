package Main.use_cases.popular_recipes;

import Main.entity.Recipe;

import java.util.List;

public interface PopularRecipeDataAccess {

    List<Recipe> getTopRecipes();

    public void updateFavourites(String username, String recipeId);

    boolean recipeInFavourites(String username, String recipeID);
}
