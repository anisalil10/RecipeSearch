package interface_adapter.popular_recipes;

import entity.Recipe;
import use_cases.popular_recipes.PopularRecipesInputBoundary;
import use_cases.popular_recipes.PopularRecipesInputData;

public class PopularRecipesController {

    private final PopularRecipesInputBoundary popularRecipesInteractor;

    public PopularRecipesController(PopularRecipesInputBoundary popularRecipesInputBoundary) {
        this.popularRecipesInteractor = popularRecipesInputBoundary;
    }

    public void viewTopRecipes() {
        popularRecipesInteractor.viewPopularRecipes();
    }

    public void openRecipe(Recipe recipe, String username) {
        PopularRecipesInputData inputData = new PopularRecipesInputData(recipe, username);

        popularRecipesInteractor.openRecipe(inputData.getRecipe(), inputData.getUsername());
    }

    public void addToFavourites(Recipe recipe, String username) {
        PopularRecipesInputData inputData = new PopularRecipesInputData(recipe, username);

        popularRecipesInteractor.addToFavourites(inputData.getRecipe(), inputData.getUsername());
    }
}
