package Main.data_access;

import Main.entity.Recipe;
import Main.entity.SearchParameters;
import Main.entity.User;
import Main.entity.UserPreferences;

import java.io.IOException;
import java.util.List;

public class test {

    public static void main(String[] args) throws IOException {
        SearchParameters searchParameters = new SearchParameters("pasta", "italian", "dinner",
                "high-protein", 2);
        APIRecipeDataAccessObject apiDataAccess = new APIRecipeDataAccessObject(searchParameters);
        List<Recipe> recipeList = apiDataAccess.getrecipes(searchParameters);
       for (Recipe recipe : recipeList) {
           System.out.println(recipe.getName() + recipe.getCuisine() + recipe.getIngredients());
       }
       if (recipeList.isEmpty()) {
           System.out.println("no results");
       }

    }

}
