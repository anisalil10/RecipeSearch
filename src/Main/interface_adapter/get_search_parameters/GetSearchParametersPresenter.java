package Main.interface_adapter.get_search_parameters;

import Main.interface_adapter.ViewManagerModel;
import Main.interface_adapter.fetch_recipes.FetchRecipesState;
import Main.interface_adapter.fetch_recipes.FetchRecipesViewModel;
import Main.use_cases.GetSearchParameters.GetSearchParametersOutputBoundary;
import Main.use_cases.GetSearchParameters.GetSearchParametersOutputData;

public class GetSearchParametersPresenter implements GetSearchParametersOutputBoundary {

    private final GetSearchParametersViewModel getSearchParametersViewModel;
    private final FetchRecipesViewModel fetchRecipesViewModel;
    private final ViewManagerModel viewManagerModel;

    public GetSearchParametersPresenter(GetSearchParametersViewModel getSearchParametersViewModel,
                                        FetchRecipesViewModel fetchRecipesViewModel,
                                        ViewManagerModel viewManagerModel) {
        this.getSearchParametersViewModel = getSearchParametersViewModel;
        this.fetchRecipesViewModel = fetchRecipesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(GetSearchParametersOutputData outputData) {
        final FetchRecipesState fetchRecipesState = fetchRecipesViewModel.getState();
        fetchRecipesState.setSearchParameters(outputData.getSearchParameters());
        this.fetchRecipesViewModel.setState(fetchRecipesState);
        fetchRecipesViewModel.firePropertyChanged();

        viewManagerModel.setState(fetchRecipesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String errormessage) {
        final GetSearchParametersState getSearchParametersState = getSearchParametersViewModel.getState();
        getSearchParametersState.getQueryError(errormessage);
    }
}
