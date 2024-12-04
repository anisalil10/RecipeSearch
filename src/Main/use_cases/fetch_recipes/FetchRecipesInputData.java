package Main.use_cases.fetch_recipes;

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
