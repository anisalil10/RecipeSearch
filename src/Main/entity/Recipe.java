package Main.entity;

import java.util.List;


public class Recipe {
    private String recipeID;
    private String name;
    private String cuisine;
    private String instructions;
    private String nutritionalinfo;
    private List<String> ingredients;

    public Recipe(String recipeID, String name, String cuisine, String instructions, String nutritionalinfo,
                  List<String> ingredients) {
        this.recipeID = recipeID;
        this.name = name;
        this.cuisine = cuisine;
        this.instructions = instructions;
        this.nutritionalinfo = nutritionalinfo;
        this.ingredients = ingredients;
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

    public String getInstructions() {
        return instructions;
    }

    public String getNutritionalinfo() {
        return nutritionalinfo;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}