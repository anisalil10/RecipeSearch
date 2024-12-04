package Main.use_cases.get_search_parameters;

public interface GetSearchParametersOutputBoundary {

    void prepareSuccessView(GetSearchParametersOutputData outputData);

    void prepareFailView(String errormessage);
}
