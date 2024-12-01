package Main.interface_adapter.get_search_parameters;

public class GetSearchParametersState {
    private String query = "";
    private String queryError;
    private String cuisine;
    private String mealType;
    private String diet;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQueryError() {
        return this.queryError;
    }

    public void setQueryError(String queryError) {
        this.queryError = queryError;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    @Override
    public String toString() {
        return "Filters{"
                + "query='" + query + '\''
                + ", cuisine='" + cuisine + '\''
                + ", mealType='" + mealType + '\''
                + ", diet=" + diet + '\''
                + '}';
    }
}
