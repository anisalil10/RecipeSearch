package Main.use_cases.GetSearchParameters;

import Main.entity.SearchParameters;

public class GetSearchParametersInteractor implements GetSearchParametersInputBoundary {

    private final GetSearchParametersDataAccess searchParametersDataAccess;
    private final GetSearchParametersOutputBoundary searchPresenter;

    public GetSearchParametersInteractor(GetSearchParametersDataAccess searchParametersDataAccess, GetSearchParametersOutputBoundary searchPresenter) {
        this.searchParametersDataAccess = searchParametersDataAccess;
        this.searchPresenter = searchPresenter;
    }

    public void execute(GetSearchParametersInputData inputData) {
        SearchParameters searchParameters = new SearchParameters(inputData.getQuery(),
                inputData.getCuisineType(), inputData.getMealType(),
                inputData.getDiet(), inputData.getMaxResults());

        searchParametersDataAccess.saveSearchParameters(searchParameters);

        final GetSearchParametersOutputData outputData = new GetSearchParametersOutputData(searchParameters);
        searchPresenter.prepareSuccessView(outputData);
    }

}
