package entity;


import java.util.Comparator;
import java.util.List;

public class Recipe implements Comparator<Recipe> {
    private final String recipeID;
    private final String name;
    private final String cuisine;
    private final String mealType;
    private final List<String> ingredients;
    private final int calories;
    private int favourties = 0;

    public Recipe(String recipeID, String name, String cuisine, String mealType, List<String> ingredients,
                  int calories) {
        this.recipeID = recipeID;
        this.name = name;
        this.cuisine = cuisine;
        this.mealType = mealType;
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
            ingredients.append(ingredient).append("\n");
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
        return Integer.compare(o1.getFavourties(), o2.getFavourties());
    }
}