package Main.use_cases.OpenRecipe;

import Main.entity.Recipe;

public interface OpenRecipeDataAccessInterface {

    Recipe findrecipe(String recipeId);
}
