package Main.interface_adapter.fetch_recipes;

import Main.entity.Recipe;
import Main.interface_adapter.ViewManagerModel;
import Main.interface_adapter.open_recipe.OpenRecipeState;
import Main.interface_adapter.open_recipe.OpenRecipeViewModel;
import Main.use_cases.fetch_recipes.FetchRecipesOutputBoundary;
import Main.use_cases.fetch_recipes.FetchRecipesOutputData;

public class FetchRecipesPresenter implements FetchRecipesOutputBoundary {
    private final FetchRecipesViewModel fetchRecipesViewModel;
    private final OpenRecipeViewModel openRecipeViewModel;
    private final ViewManagerModel viewManagerModel;

    public FetchRecipesPresenter(FetchRecipesViewModel fetchRecipesViewModel, OpenRecipeViewModel openRecipeViewModel,
                                 ViewManagerModel viewManagerModel) {
        this.fetchRecipesViewModel = fetchRecipesViewModel;
        this.openRecipeViewModel = openRecipeViewModel;
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

    @Override
    public void openRecipe(Recipe recipe, String username) {
        final OpenRecipeState openRecipeState = openRecipeViewModel.getState();
        openRecipeState.setRecipe(recipe);
        openRecipeState.setUsername(username);

        this.openRecipeViewModel.setState(openRecipeState);

        viewManagerModel.setState(openRecipeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
