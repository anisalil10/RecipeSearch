package Main.interface_adapter.get_search_parameters;

import Main.use_cases.GetSearchParameters.GetSearchParametersInputBoundary;
import Main.use_cases.GetSearchParameters.GetSearchParametersInputData;

public class GetSearchParametersController {
    private final GetSearchParametersInputBoundary searchParametersInteractor;

    public GetSearchParametersController(GetSearchParametersInputBoundary searchParametersInteractor) {
        this.searchParametersInteractor = searchParametersInteractor;
    }

    public void execute(String query, String cuisine, String mealType, String diet) {
        final GetSearchParametersInputData searchParametersInputData = new GetSearchParametersInputData(query, cuisine,
                mealType, diet);

        searchParametersInteractor.execute(searchParametersInputData);
    }

}
