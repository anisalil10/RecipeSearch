package Main.use_cases.fetch_recipes;

public interface FetchRecipesInputBoundary {

    void execute(FetchRecipesInputData fetchRecipesInputData);

    void openRecipe(String recipeId, String username);
}
