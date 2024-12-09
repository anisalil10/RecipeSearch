package use_cases.fetch_recipes;

import entity.SearchParameters;

public class FetchRecipesInputData {

    private final SearchParameters searchParameters;

    public FetchRecipesInputData(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    public SearchParameters getSearchParameters() {
        return searchParameters;
    }
}
