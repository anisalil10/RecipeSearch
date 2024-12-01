package Main.interface_adapter.open_recipe;

import Main.interface_adapter.ViewManagerModel;
import Main.use_cases.OpenRecipe.OpenRecipeOutputBoundary;
import Main.use_cases.OpenRecipe.OpenRecipeOutputData;

public class OpenRecipePresenter implements OpenRecipeOutputBoundary {
    private final OpenRecipeViewModel openRecipeViewModel;
    private final ViewManagerModel viewManagerModel;

    public OpenRecipePresenter(OpenRecipeViewModel openRecipeViewModel, ViewManagerModel viewManagerModel) {
        this.openRecipeViewModel = openRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(OpenRecipeOutputData openRecipeOutputData) {
        final OpenRecipeState openRecipeState = openRecipeViewModel.getState();
        openRecipeState.setRecipeId(openRecipeState.getRecipeId());

        viewManagerModel.setState(openRecipeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String message) {
        final OpenRecipeState openRecipeState = openRecipeViewModel.getState();
        openRecipeState.setRecipeIdError(message);
        openRecipeViewModel.firePropertyChanged();
    }
}
