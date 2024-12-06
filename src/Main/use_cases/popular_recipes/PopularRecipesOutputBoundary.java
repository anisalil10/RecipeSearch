package Main.use_cases.popular_recipes;

import Main.entity.Recipe;

import java.util.List;

public interface PopularRecipesOutputBoundary {

    void viewTopRecipes(List<Recipe> topRecipes);

    public void openRecipe(Recipe recipe, String username);

    void addToFavouritesFail(String message);

    void addToFavouritesSuccess(String s);
}
