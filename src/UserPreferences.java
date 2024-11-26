public class UserPreferences {
    import java.util.ArrayList;
import java.util.List;

    public class UserPreferences {
        private List<String> dietaryRestrictions;

        public UserPreferences() {
            this.dietaryRestrictions = new ArrayList<>();
        }

        public List<String> getDietaryRestrictions() {
            return dietaryRestrictions;
        }

        public void addDietaryRestriction(String restriction) {
            if (!dietaryRestrictions.contains(restriction)) {
                dietaryRestrictions.add(restriction);
            }
        }

        public void removeDietaryRestriction(String restriction) {
            dietaryRestrictions.remove(restriction);
        }

        @Override
        public String toString() {
            return "Dietary Restrictions: " + dietaryRestrictions;
        }
    }

}
