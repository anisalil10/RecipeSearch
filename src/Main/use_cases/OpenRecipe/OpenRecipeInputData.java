package Main.use_cases.OpenRecipe;

import Main.entity.RecipeId;

public class OpenRecipeInputData {

    private RecipeId recipeId;

    public OpenRecipeInputData(RecipeId recipeId) {
        this.recipeId = recipeId;
    }

    public RecipeId getRecipeId() {
        return this.recipeId;
    }
}
