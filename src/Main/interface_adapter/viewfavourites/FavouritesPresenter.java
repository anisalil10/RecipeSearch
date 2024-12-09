package interface_adapter.viewfavourites;

import entity.Recipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.popular_recipes.PopularRecipesState;
import use_cases.viewfavourites.FavouritesOutputBoundary;
import use_cases.viewfavourites.FavouritesOutputData;

import java.util.List;

public class FavouritesPresenter implements FavouritesOutputBoundary {

    private final FavouritesViewModel favouritesViewModel;
    private final ViewManagerModel viewManagerModel;

    public FavouritesPresenter(FavouritesViewModel favouritesViewModel, ViewManagerModel viewManagerModel) {
        this.favouritesViewModel = favouritesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void presentFavoriteRecipes(FavouritesOutputData outputData) {
        List<Recipe> recipeNames = outputData.getFavoriteRecipeNames();

        FavouritesState favouritesState = favouritesViewModel.getState();
        favouritesState.setFavoriteRecipes(recipeNames);
        favouritesState.setOpenFavourites(false);
        favouritesViewModel.setState(favouritesState);

        favouritesViewModel.firePropertyChanged();
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void openRecipe(Recipe recipe, String username) {
        final FavouritesState state = favouritesViewModel.getState();
        state.setSelectedRecipe(recipe);
        state.setUsername(username);
        favouritesViewModel.firePropertyChanged();
    }

    @Override
    public void presentError(String errorMessage) {
        final FavouritesState state = favouritesViewModel.getState();
        state.setErrorMessage(errorMessage);
        favouritesViewModel.firePropertyChanged();
    }

}
