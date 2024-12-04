package Main.use_cases.get_search_parameters;

import Main.entity.SearchParameters;

public class GetSearchParametersOutputData {
    private final SearchParameters searchParameters;

    public GetSearchParametersOutputData(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    public SearchParameters getSearchParameters() {
        return searchParameters;
    }
}
