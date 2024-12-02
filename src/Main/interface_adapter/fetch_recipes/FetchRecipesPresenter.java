package Main.interface_adapter.fetch_recipes;

import Main.interface_adapter.ViewManagerModel;
import Main.use_cases.FetchRecipes.FetchRecipesOutputBoundary;
import Main.use_cases.FetchRecipes.FetchRecipesOutputData;

public class FetchRecipesPresenter implements FetchRecipesOutputBoundary {
    private final FetchRecipesViewModel fetchRecipesViewModel;
    private final ViewManagerModel viewManagerModel;

    public FetchRecipesPresenter(FetchRecipesViewModel fetchRecipesViewModel, ViewManagerModel viewManagerModel) {
        this.fetchRecipesViewModel = fetchRecipesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(FetchRecipesOutputData outputData) {
        final FetchRecipesState fetchRecipesState = fetchRecipesViewModel.getState();
        fetchRecipesState.setRecipeList(outputData.getRecipeList());

        this.fetchRecipesViewModel.setState(fetchRecipesState);
        this.fetchRecipesViewModel.firePropertyChanged();

        viewManagerModel.setState(fetchRecipesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final FetchRecipesState fetchRecipesState = fetchRecipesViewModel.getState();
        fetchRecipesState.setRecipeError(errorMessage);
        fetchRecipesViewModel.firePropertyChanged();
    }
}
