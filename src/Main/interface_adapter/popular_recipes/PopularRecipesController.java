package interface_adapter.popular_recipes;

import entity.Recipe;
import use_cases.popular_recipes.PopularRecipesInputBoundary;
import use_cases.popular_recipes.PopularRecipesInputData;

/**
 * Controller for the PopularRecipes Use Case.
 */
public class PopularRecipesController {

    private final PopularRecipesInputBoundary popularRecipesInteractor;

    public PopularRecipesController(PopularRecipesInputBoundary popularRecipesInputBoundary) {
        this.popularRecipesInteractor = popularRecipesInputBoundary;
    }

    /**
     * Executes the openRecipe Use Case.
     * @param username the username to possible add to favourites
     * @param recipe the recipe to be viewed.
     */
    public void openRecipe(Recipe recipe, String username) {
        PopularRecipesInputData inputData = new PopularRecipesInputData(recipe, username);

        popularRecipesInteractor.openRecipe(inputData.getRecipe(), inputData.getUsername());
    }

    /**
     * Executes the addToFavourites Use Case.
     * @param username the username to possibly add to favourites
     * @param recipe the recipe to be viewed.
     */
    public void addToFavourites(Recipe recipe, String username) {
        PopularRecipesInputData inputData = new PopularRecipesInputData(recipe, username);

        popularRecipesInteractor.addToFavourites(inputData.getRecipe(), inputData.getUsername());
    }


    /**
     * Executes the back use case
     * @param username the username to return to GetSearchParameters view.
     */
    public void back(String username) {
        popularRecipesInteractor.back(username);
    }
}
