package entity;


import java.util.Comparator;
import java.util.List;

/**
 * The representation of a recipe in our program.
 */
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

    /**
     * @return a string representing the recipe's uri link
     */
    public String getRecipeID() {
        return recipeID;
    }

    /**
     * @return a string representing the recipe's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return a string representing the recipe's cuisine type.
     */
    public String getCuisine() {
        return cuisine;
    }

    /**
     * @return a list of Strings of ingredients in the recipe.
     */
    public List<String> getIngredients() {
        return ingredients;
    }

    /**
     * @return an int representing the recipe's calorie amount
     */
    public int getCalories() {
        return calories;
    }

    /**
     * @return a string representing the recipe's mealType
     */
    public String getMealType() {
        return mealType;
    }

    /**
     * @return a string representing the list of ingredients in a user-friendly way.
     */
    public String getIngredientsToString() {
        StringBuilder ingredients = new StringBuilder();
        for(String ingredient : this.getIngredients()) {
            ingredients.append(ingredient).append("\n");
        }
        return ingredients.toString();
    }

    /**
     * @return an int that represents how often a recipe is favourited.
     */
    public int getFavourties() {
        return favourties;
    }

    /**
     * sets the number of times the recipes has been favourited
     */
    public void setFavourties(int favourties) {
        this.favourties = favourties;
    }

    /**
     * Allows for easier sorting by overriding compare method.
     */
    @Override
    public int compare(Recipe o1, Recipe o2) {
        return Integer.compare(o1.getFavourties(), o2.getFavourties());
    }
}