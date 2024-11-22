import java.util.List;

public class Userpreferences {

    private List<String> cuisinepreferences;
    private List<String> dietaryrestrictions;
    private List<Ingredient> excludedingredients;

    public Userpreferences(List<String> cuisinepreferences, List<String> dietaryrestrictions,
     List<Ingredient> excludedingredients) {
        this.cuisinepreferences = cuisinepreferences;;
        this.dietaryrestrictions = dietaryrestrictions;
        this.excludedingredients = excludedingredients;
    }
}