package Main.use_cases.OpenRecipe;

import Main.entity.RecipeId;

public class OpenRecipeOutputData {

    private RecipeId recipeId;

    public OpenRecipeOutputData(RecipeId recipeId) {
        this.recipeId = recipeId;
    }

    public RecipeId getRecipeId() {
        return this.recipeId;
    }
}
