package interface_adapter.get_search_parameters;

import entity.Recipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.popular_recipes.PopularRecipesState;
import interface_adapter.popular_recipes.PopularRecipesViewModel;
import interface_adapter.viewfavourites.FavouritesState;
import interface_adapter.viewfavourites.FavouritesViewModel;
import use_cases.get_search_parameters.GetSearchParametersOutputBoundary;
import use_cases.get_search_parameters.GetSearchParametersOutputData;

import java.util.List;

public class GetSearchParametersPresenter implements GetSearchParametersOutputBoundary {

    private final GetSearchParametersViewModel getSearchParametersViewModel;
    private final PopularRecipesViewModel popularRecipesViewModel;
    private final FavouritesViewModel favouritesViewModel;
    private final ViewManagerModel viewManagerModel;

    public GetSearchParametersPresenter(GetSearchParametersViewModel getSearchParametersViewModel,
                                        PopularRecipesViewModel popularRecipesViewModel,
                                        FavouritesViewModel favouritesViewModel,
                                        ViewManagerModel viewManagerModel) {
        this.getSearchParametersViewModel = getSearchParametersViewModel;
        this.popularRecipesViewModel = popularRecipesViewModel;
        this.favouritesViewModel = favouritesViewModel;
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
    public void viewPopularRecipes(String username, List<Recipe> topRecipes) {
        final PopularRecipesState popularRecipesState = popularRecipesViewModel.getState();
        popularRecipesState.setUsername(username);
        popularRecipesState.setTopRecipes(topRecipes);

        this.popularRecipesViewModel.setState(popularRecipesState);
        popularRecipesViewModel.firePropertyChanged();
        viewManagerModel.setState(popularRecipesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void openfavouriteRecipes(String username) {
        final FavouritesState favouritesState = favouritesViewModel.getState();
        favouritesState.setUsername(username);
        favouritesState.setOpenFavourites(true);

        this.favouritesViewModel.setState(favouritesState);
        favouritesViewModel.firePropertyChanged();
        viewManagerModel.setState(favouritesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
