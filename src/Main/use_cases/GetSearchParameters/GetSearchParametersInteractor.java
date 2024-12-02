package Main.use_cases.GetSearchParameters;

import Main.entity.SearchParameters;
import Main.entity.User;

public class GetSearchParametersInteractor implements GetSearchParametersInputBoundary {

    private final GetSearchParametersDataAccess searchParametersDataAccess;
    private final GetSearchParametersOutputBoundary searchPresenter;

    public GetSearchParametersInteractor(GetSearchParametersDataAccess searchParametersDataAccess,
                                         GetSearchParametersOutputBoundary searchPresenter) {
        this.searchParametersDataAccess = searchParametersDataAccess;
        this.searchPresenter = searchPresenter;
    }

    public void execute(GetSearchParametersInputData inputData) {
        SearchParameters searchParameters = new SearchParameters(inputData.getQuery(),
                inputData.getCuisineType(), inputData.getMealType(),
                inputData.getDiet(), inputData.getMaxResults());

        if(inputData.getQuery().isEmpty()) {
            searchPresenter.prepareFailView("Enter a search");
        }
        else if(inputData.getCuisineType().isEmpty()) {
            searchPresenter.prepareFailView("Enter a cuisine");
        }
        else if(inputData.getMealType().isEmpty()) {
            searchPresenter.prepareFailView("Enter a meal time");
        }
        else if(searchParametersDataAccess.getrecipes(searchParameters).isEmpty()) {
            searchPresenter.prepareFailView("No recipes found");
        }
        else {
            searchParametersDataAccess.saveSearchParameters(searchParameters);

            final GetSearchParametersOutputData outputData = new GetSearchParametersOutputData(searchParameters);
            searchPresenter.prepareSuccessView(outputData);
        }
    }

}
