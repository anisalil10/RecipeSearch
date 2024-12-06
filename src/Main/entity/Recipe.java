package Main.entity;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class Recipe implements Comparator<Recipe> {
    private String recipeID;
    private String name;
    private String cuisine;
    private String mealType;
    //private String nutritionalinfo;
    private List<String> ingredients;
    private int calories;
    private int favourties = 0;

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

    public String getIngredientsToString() {
        StringBuilder ingredients = new StringBuilder();
        for(String ingredient : this.ingredients) {
            ingredients.append(ingredient + "\n");
        }
        return ingredients.toString();
    }

    public int getFavourties() {
        return favourties;
    }

    public void setFavourties(int favourties) {
        this.favourties = favourties;
    }

    @Override
    public int compare(Recipe o1, Recipe o2) {
        if(o1.getFavourties() < o2.getFavourties()) {
            return -1;
        }
        else if (o1.getFavourties() > o2.getFavourties()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}