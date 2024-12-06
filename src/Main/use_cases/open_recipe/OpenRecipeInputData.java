package Main.use_cases.open_recipe;

import Main.entity.Recipe;

public class OpenRecipeInputData {

    private Recipe recipe;
    private String username;

    public OpenRecipeInputData(Recipe recipe, String username) {
        this.recipe = recipe;
        this.username = username;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public String getUsername() {
        return username;
    }
}
