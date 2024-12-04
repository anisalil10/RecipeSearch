package Main.interface_adapter.open_recipe;

import Main.interface_adapter.ViewManagerModel;
import Main.use_cases.open_recipe.OpenRecipeOutputBoundary;
import Main.use_cases.open_recipe.OpenRecipeOutputData;

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
        openRecipeState.setRecipeName(openRecipeState.getRecipeName());
        openRecipeState.setIngredients(openRecipeState.getIngredients());
        openRecipeState.setCuisine(openRecipeState.getCuisine());
        openRecipeState.setMealType(openRecipeState.getMealType());
        openRecipeState.setCalories(openRecipeState.getCalories());

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
