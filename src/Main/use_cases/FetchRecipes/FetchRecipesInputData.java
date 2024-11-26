package Main.use_cases.FetchRecipes;

import Main.entity.SearchParameters;

public class FetchRecipesInputData {

    private final SearchParameters searchParameters;

    public FetchRecipesInputData(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    public SearchParameters getSearchParameters() {
        return searchParameters;
    }
}
