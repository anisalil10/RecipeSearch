package Main.use_cases.popular_recipes;

import Main.entity.Recipe;

public class PopularRecipesInteractor implements PopularRecipesInputBoundary{

    private final PopularRecipeDataAccess popularRecipeDataAccess;
    private final PopularRecipesOutputBoundary recipesPresenter;

    public PopularRecipesInteractor(PopularRecipeDataAccess popularRecipeDataAccess,
                                    PopularRecipesOutputBoundary recipesPresenter) {
        this.popularRecipeDataAccess = popularRecipeDataAccess;
        this.recipesPresenter = recipesPresenter;
    }

    @Override
    public void viewPopularRecipes() {
        recipesPresenter.viewTopRecipes(popularRecipeDataAccess.getTopRecipes());
    }

    @Override
    public void openRecipe(Recipe recipe, String username) {
        recipesPresenter.openRecipe(recipe, username);
    }

    @Override
    public void addToFavourites(Recipe recipe, String username) {
        if(popularRecipeDataAccess.recipeInFavourites(username, recipe.getRecipeID())) {
            recipesPresenter.addToFavouritesFail("recipe already in favourites");
        }
        else {
            popularRecipeDataAccess.updateFavourites(username, recipe.getRecipeID());
            recipesPresenter.addToFavouritesSuccess("");
        }
    }
}
