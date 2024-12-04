package Main.use_cases.fetch_recipes;

import Main.entity.Recipe;
import Main.entity.SearchParameters;

import java.util.List;

public interface FetchRecipesDataAccessInterface {

    List<Recipe> getrecipes(SearchParameters searchParameters);

    Recipe findrecipe(String RecipeId);

}
