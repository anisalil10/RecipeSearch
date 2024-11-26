package Main.use_cases.FetchRecipes;

import Main.entity.Recipe;
import Main.entity.RecipeId;
import Main.entity.SearchParameters;

import java.util.List;

public interface FetchRecipesDataAccessInterface {

    List<Recipe> getrecipes(SearchParameters searchParameters);

}
