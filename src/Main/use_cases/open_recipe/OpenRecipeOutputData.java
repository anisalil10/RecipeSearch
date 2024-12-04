package Main.use_cases.open_recipe;

import Main.entity.Recipe;

public class OpenRecipeOutputData {

    private Recipe recipe;
    private String username;

    public OpenRecipeOutputData(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }
}
