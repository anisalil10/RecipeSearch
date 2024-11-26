package Main.use_cases.FetchRecipes;

import Main.entity.Recipe;

import java.util.List;

public class FetchRecipesOutputData {

    private List<Recipe> recipeList;


    public FetchRecipesOutputData(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }
}
