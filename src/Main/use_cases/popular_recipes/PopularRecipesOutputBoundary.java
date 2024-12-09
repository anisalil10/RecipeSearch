package use_cases.popular_recipes;

import entity.Recipe;

import java.util.List;

public interface PopularRecipesOutputBoundary {

    void viewTopRecipes(List<Recipe> topRecipes);

    void openRecipe(Recipe recipe, String username);

    void addToFavouritesFail(String message);

    void addToFavouritesSuccess(String s);

    void back(String username, String diet);
}
