package Main.use_cases.OpenRecipe;

import Main.entity.RecipeId;

public class OpenRecipeInputData {

    private String recipeId;

    public OpenRecipeInputData(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeId() {
        return this.recipeId;
    }
}
