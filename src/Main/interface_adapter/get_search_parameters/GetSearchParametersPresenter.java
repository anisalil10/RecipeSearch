package Main.interface_adapter.get_search_parameters;

import Main.interface_adapter.ViewManagerModel;
import Main.interface_adapter.fetch_recipes.FetchRecipesState;
import Main.interface_adapter.fetch_recipes.FetchRecipesViewModel;
import Main.use_cases.get_search_parameters.GetSearchParametersOutputBoundary;
import Main.use_cases.get_search_parameters.GetSearchParametersOutputData;

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
        GetSearchParametersState getSearchParametersState = getSearchParametersViewModel.getState();
        fetchRecipesState.setUsername(getSearchParametersState.getUsername());

        this.fetchRecipesViewModel.setState(fetchRecipesState);
        fetchRecipesViewModel.firePropertyChanged();

        viewManagerModel.setState(fetchRecipesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String errormessage) {
        final GetSearchParametersState getSearchParametersState = getSearchParametersViewModel.getState();
        getSearchParametersState.setQueryError(errormessage);
        getSearchParametersViewModel.firePropertyChanged();
    }
}
