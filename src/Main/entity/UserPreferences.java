package entity;

import java.util.List;

public class UserPreferences {

    private List<String> cuisinepreferences;
    private List<String> dietaryrestrictions;
    private List<Ingredient> excludedingredients;

    public UserPreferences(List<String> cuisinepreferences, List<String> dietaryrestrictions,
                           List<Ingredient> excludedingredients) {
        this.cuisinepreferences = cuisinepreferences;;
        this.dietaryrestrictions = dietaryrestrictions;
        this.excludedingredients = excludedingredients;
    }
}