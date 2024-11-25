package Main.entity;

import java.util.List;


public class Recipe {
    private RecipeId recipeID;
    private String name;
    private String cuisine;
    //private String nutritionalinfo;
    private List<String> ingredients;
    private int calories;

    public Recipe(RecipeId recipeID, String name, String cuisine, List<String> ingredients,
                  int calories) {
        this.recipeID = recipeID;
        this.name = name;
        this.cuisine = cuisine;
        //this.nutritionalinfo = nutritionalinfo;
        this.ingredients = ingredients;
        this.calories = calories;
    }


    public RecipeId getRecipeID() {
        return recipeID;
    }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public int getCalories() {
        return calories;
    }
}