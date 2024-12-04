package Main.use_cases.open_recipe;

public class OpenRecipeInputData {

    private String recipeId;
    private String username;

    public OpenRecipeInputData(String recipeId, String username) {
        this.recipeId = recipeId;
        this.username = username;
    }

    public String getRecipeId() {
        return this.recipeId;
    }

    public String getUsername() {
        return username;
    }
}
