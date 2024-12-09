package interface_adapter.popular_recipes;

import entity.Recipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_search_parameters.GetSearchParametersState;
import interface_adapter.get_search_parameters.GetSearchParametersViewModel;
import use_cases.popular_recipes.PopularRecipesOutputBoundary;

import java.util.List;

/**
 * The Presenter for the PopularRecipes Use Case.
 */
public class PopularRecipesPresenter implements PopularRecipesOutputBoundary {

    private final PopularRecipesViewModel popularRecipesViewModel;
    private final GetSearchParametersViewModel getSearchParametersViewModel;
    private final ViewManagerModel viewManagerModel;

    public PopularRecipesPresenter(PopularRecipesViewModel popularRecipesViewModel, GetSearchParametersViewModel getSearchParametersViewModel, ViewManagerModel viewManagerModel) {
        this.popularRecipesViewModel = popularRecipesViewModel;
        this.getSearchParametersViewModel = getSearchParametersViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void viewTopRecipes(List<Recipe> topRecipes) {
        PopularRecipesState popularRecipesState = popularRecipesViewModel.getState();
        popularRecipesState.setTopRecipes(topRecipes);
        popularRecipesViewModel.setState(popularRecipesState);

        popularRecipesViewModel.firePropertyChanged();
        viewManagerModel.firePropertyChanged();
    }

    public void openRecipe(Recipe recipe, String username) {
        final PopularRecipesState state = popularRecipesViewModel.getState();
        state.setSelectedRecipe(recipe);
        state.setUsername(username);
        popularRecipesViewModel.firePropertyChanged();
    }

    @Override
    public void addToFavouritesFail(String message) {
        final PopularRecipesState popularRecipesState = popularRecipesViewModel.getState();
        popularRecipesState.setFavouritesErrorMessage(message);
        popularRecipesViewModel.firePropertyChanged();
    }

    @Override
    public void addToFavouritesSuccess(String s) {
        final PopularRecipesState popularRecipesState = popularRecipesViewModel.getState();
        popularRecipesState.setFavouritesErrorMessage(s);
        popularRecipesViewModel.firePropertyChanged();
    }

    @Override
    public void back(String username, String diet) {
        final GetSearchParametersState getSearchParametersState = getSearchParametersViewModel.getState();

        getSearchParametersState.setUsername(username);
        getSearchParametersState.setDiet(diet);
        getSearchParametersState.setQuery(null);
        getSearchParametersState.setMealType(null);
        getSearchParametersState.setCuisine(null);
        getSearchParametersState.setRecipeList(null);
        getSearchParametersState.setSelectedRecipe(null);

        this.getSearchParametersViewModel.setState(getSearchParametersState);
        getSearchParametersViewModel.firePropertyChanged();
        viewManagerModel.setState(getSearchParametersViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
