package Main.use_cases.OpenRecipe;

import Main.entity.Recipe;

public class OpenRecipeOutputData {

    private Recipe recipe;

    public OpenRecipeOutputData(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }
}
