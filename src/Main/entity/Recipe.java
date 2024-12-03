package Main.entity;

import java.util.List;

public class Recipe {
    private String recipeID;
    private String name;
    private String cuisine;
    private String mealType;
    //private String nutritionalinfo;
    private List<String> ingredients;
    private int calories;

    public Recipe(String recipeID, String name, String cuisine, String mealType, List<String> ingredients,
                  int calories) {
        this.recipeID = recipeID;
        this.name = name;
        this.cuisine = cuisine;
        this.mealType = mealType;
        //this.nutritionalinfo = nutritionalinfo;
        this.ingredients = ingredients;
        this.calories = calories;
    }


    public String getRecipeID() {
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

    public String getMealType() {
        return mealType;
    }
}