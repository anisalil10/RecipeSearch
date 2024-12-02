package Main.interface_adapter.open_recipe;

import Main.entity.Recipe;
import Main.entity.RecipeId;

import java.util.ArrayList;
import java.util.List;

public class OpenRecipeState {
    private Recipe recipe;
    private String recipeIdError;
    private String username = " ";
    private String recipeName = " ";
    private String mealType = " ";
    private String cuisine = " ";
    private List<String> ingredients = new ArrayList<>();
    private int calories = 0;


    public String getRecipeIdError() {
        return recipeIdError;
    }

    public void setRecipeIdError(String recipeIdError) {
        this.recipeIdError = recipeIdError;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
