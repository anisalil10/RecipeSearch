package Main.use_cases.OpenRecipe;

import Main.entity.Recipe;
import Main.entity.User;

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
