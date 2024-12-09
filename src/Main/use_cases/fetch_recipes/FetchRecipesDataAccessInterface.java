package use_cases.fetch_recipes;

import entity.Recipe;
import entity.SearchParameters;

import java.util.List;

public interface FetchRecipesDataAccessInterface {

    List<Recipe> getrecipes(SearchParameters searchParameters);

    Recipe findrecipe(String RecipeId);

}
