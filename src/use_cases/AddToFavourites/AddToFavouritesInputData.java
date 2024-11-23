package use_cases.AddToFavourites;

import entity.Recipe;

public class AddToFavouritesInputData {
    private final int recipe_id;
    private final String user

    public AddToFavouritesInputData(Recipe recipe) {
        this.recipe_id = recipe.getRecipeID();
    }

    public int getRecipe_id() {
        return recipe_id;
    }

}
