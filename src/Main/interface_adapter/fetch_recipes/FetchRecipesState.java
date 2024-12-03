package Main.interface_adapter.fetch_recipes;

import Main.entity.Recipe;
import Main.entity.SearchParameters;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class FetchRecipesState {
    private SearchParameters searchParameters;
    private String username;
    private List<Recipe> recipeList; // Existing: List of Recipe objects
    private List<String> recipeIds;  // New: List of Recipe IDs
    private String recipeError;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // Getters and Setters for Recipe List
    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
        // Notify listeners about the new recipes
        this.recipeIds = recipeList.stream().map(Recipe::getRecipeID).toList();
        support.firePropertyChange("recipes", null, this);
    }

    // Getters and Setters for Recipe IDs
    public List<String> getRecipeIds() {
        return recipeIds;
    }

    public void setRecipeIds(List<String> recipeIds) {
        this.recipeIds = recipeIds;
        support.firePropertyChange("recipes", null, this);
    }

    // Getter and Setter for Username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for Search Parameters
    public SearchParameters getSearchParameters() {
        return searchParameters;
    }

    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    // Getter and Setter for Recipe Error
    public String getRecipeError() {
        return recipeError;
    }

    public void setRecipeError(String recipeError) {
        this.recipeError = recipeError;
        support.firePropertyChange("recipeError", null, this.recipeError);
    }

    // Property Change Support
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
