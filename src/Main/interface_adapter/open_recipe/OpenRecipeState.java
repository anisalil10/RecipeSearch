package Main.interface_adapter.open_recipe;

import Main.entity.Recipe;
import Main.entity.RecipeId;
import Main.use_cases.OpenRecipe.OpenRecipeInputBoundary;
import Main.use_cases.OpenRecipe.OpenRecipeInputData;

public class OpenRecipeState {
    private RecipeId recipeId;
    private Recipe recipe;
    private String recipeIdError;

    public RecipeId getRecipeId() {
        return recipeId;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setRecipeId(RecipeId recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeIdError() {
        return recipeIdError;
    }

    public void setRecipeIdError(String recipeIdError) {
        this.recipeIdError = recipeIdError;
    }
}
