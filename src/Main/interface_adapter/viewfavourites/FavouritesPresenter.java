package Main.interface_adapter.viewfavourites;

import Main.use_cases.viewfavourites.FavouritesOutputBoundary;
import Main.use_cases.viewfavourites.FavouritesOutputData;
import Main.interface_adapter.viewfavourites.FavouritesView;

import java.util.List;

public class FavouritesPresenter implements FavouritesOutputBoundary {
    private final FavouritesView view;

    public FavouritesPresenter(FavouritesView view) {
        this.view = view;
    }

    @Override
    public void presentFavoriteRecipes(FavouritesOutputData outputData) {
        List<String> recipeNames = outputData.getFavoriteRecipeNames();

        // Format the output as a user-friendly message
        StringBuilder formattedOutput = new StringBuilder("Your favorite recipes:\n");
        for (String recipeName : recipeNames) {
            formattedOutput.append("- ").append(recipeName).append("\n");
        }

        view.displayFavoriteRecipes(formattedOutput.toString());
    }

    @Override
    public void presentError(String message) {
        view.displayError(message);
    }
}
