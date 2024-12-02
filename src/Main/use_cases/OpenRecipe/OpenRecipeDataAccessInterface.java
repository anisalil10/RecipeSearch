package Main.use_cases.OpenRecipe;

import Main.entity.Recipe;
import Main.entity.RecipeId;

public interface OpenRecipeDataAccessInterface {

    Recipe findrecipe(String recipeId);
}
