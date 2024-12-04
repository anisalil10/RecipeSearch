package Main.use_cases.open_recipe;

import Main.entity.Recipe;

public interface OpenRecipeDataAccessInterface {

    Recipe findrecipe(String recipeId);
}
