package Main.interface_adapter.get_search_parameters;

import Main.entity.Recipe;
import Main.interface_adapter.ViewManagerModel;
import Main.interface_adapter.popular_recipes.PopularRecipesState;
import Main.interface_adapter.popular_recipes.PopularRecipesViewModel;
import Main.use_cases.get_search_parameters.GetSearchParametersOutputBoundary;
import Main.use_cases.get_search_parameters.GetSearchParametersOutputData;

public class GetSearchParametersPresenter implements GetSearchParametersOutputBoundary {

    private final GetSearchParametersViewModel getSearchParametersViewModel;
    private final PopularRecipesViewModel popularRecipesViewModel;
    private final ViewManagerModel viewManagerModel;

    public GetSearchParametersPresenter(GetSearchParametersViewModel getSearchParametersViewModel, PopularRecipesViewModel popularRecipesViewModel,
                                        ViewManagerModel viewManagerModel) {
        this.getSearchParametersViewModel = getSearchParametersViewModel;
        this.popularRecipesViewModel = popularRecipesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(GetSearchParametersOutputData outputData) {
        final GetSearchParametersState getSearchParametersState = getSearchParametersViewModel.getState();
        getSearchParametersState.setRecipeList(outputData.getRecipeList());
        getSearchParametersState.setQueryError(null);

        getSearchParametersViewModel.firePropertyChanged();
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final GetSearchParametersState getSearchParametersState = getSearchParametersViewModel.getState();
        getSearchParametersState.setQueryError(errorMessage);
        getSearchParametersViewModel.firePropertyChanged();
    }

    @Override
    public void openRecipe(Recipe recipe, String username) {
        final GetSearchParametersState state = getSearchParametersViewModel.getState();
        state.setSelectedRecipe(recipe);
        state.setUsername(username);
        getSearchParametersViewModel.firePropertyChanged();
    }

    @Override
    public void addToFavouritesFail(String message) {
        final GetSearchParametersState getSearchParametersState = getSearchParametersViewModel.getState();
        getSearchParametersState.setAddToFavouritesMessage(message);
        getSearchParametersViewModel.firePropertyChanged();
    }

    @Override
    public void addToFavouritesSuccess(String message) {
        final GetSearchParametersState getSearchParametersState = getSearchParametersViewModel.getState();
        getSearchParametersState.setAddToFavouritesMessage(message);
        getSearchParametersViewModel.firePropertyChanged();
    }

    @Override
    public void viewPopularRecipes(String username) {
        final PopularRecipesState popularRecipesState = popularRecipesViewModel.getState();
        popularRecipesState.setUsername(username);

        this.popularRecipesViewModel.setState(popularRecipesState);
        popularRecipesViewModel.firePropertyChanged();
        viewManagerModel.setState(popularRecipesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
