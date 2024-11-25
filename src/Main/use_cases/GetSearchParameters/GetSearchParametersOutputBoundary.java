package Main.use_cases.GetSearchParameters;

public interface GetSearchParametersOutputBoundary {

    void prepareSuccessView(GetSearchParametersOutputData outputData);

    void prepareFailView(String errormessage);
}
