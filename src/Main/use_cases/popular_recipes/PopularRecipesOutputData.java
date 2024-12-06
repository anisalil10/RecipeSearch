package Main.use_cases.popular_recipes;

import Main.entity.Recipe;

import java.util.List;

public class PopularRecipesOutputData {

    private final List<Recipe> topRecipes;

    public PopularRecipesOutputData(List<Recipe> topRecipes) {
        this.topRecipes = topRecipes;
    }

    public List<Recipe> getTopRecipes() {
        return topRecipes;
    }
}
