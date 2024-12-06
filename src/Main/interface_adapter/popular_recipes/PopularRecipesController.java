package Main.interface_adapter.popular_recipes;

import Main.entity.Recipe;
import Main.use_cases.popular_recipes.PopularRecipesInputBoundary;

public class PopularRecipesController {

    private final PopularRecipesInputBoundary popularRecipesInteractor;

    public PopularRecipesController(PopularRecipesInputBoundary popularRecipesInputBoundary) {
        this.popularRecipesInteractor = popularRecipesInputBoundary;
    }

    public void viewTopRecipes() {
        popularRecipesInteractor.viewPopularRecipes();
    }

    public void openRecipe(Recipe recipe, String username) {
        popularRecipesInteractor.openRecipe(recipe, username);
    }

    public void addToFavourites(Recipe recipe, String username) {
        popularRecipesInteractor.addToFavourites(recipe, username);
    }
}
