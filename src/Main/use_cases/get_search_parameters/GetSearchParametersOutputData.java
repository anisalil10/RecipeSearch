package Main.use_cases.get_search_parameters;


import Main.entity.Recipe;

import java.util.List;

public class GetSearchParametersOutputData {
    private final List<Recipe> recipeList;

    public GetSearchParametersOutputData(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }
}
