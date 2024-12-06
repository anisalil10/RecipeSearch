package Main.use_cases.popular_recipes;

import Main.entity.Recipe;

public interface PopularRecipesInputBoundary {

    void viewPopularRecipes();

    void openRecipe(Recipe recipe, String username);

    void addToFavourites(Recipe recipe, String username);
}