package Main.entity;

import java.util.List;


public class Recipe {
    private int recipeID;
    private String name;
    private String cuisine;
    private String instructions;
    private NutritionalInfo nutritionalinfo;
    private List<Ingredient> ingredients;
    private String mealtime;
    private int popularityCount;

    public int getRecipeID() {
        return recipeID;
    }

}