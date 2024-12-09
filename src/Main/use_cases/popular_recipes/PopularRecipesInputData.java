package use_cases.popular_recipes;

import entity.Recipe;

public class PopularRecipesInputData {

    private final Recipe recipe;
    private final String username;

    public PopularRecipesInputData(Recipe recipe, String username) {
        this.recipe = recipe;
        this.username = username;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public String getUsername() {
        return username;
    }
}
