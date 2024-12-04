package Main.use_cases.open_recipe;

import java.io.IOException;

public interface OpenRecipeInputBoundary {

    void execute(OpenRecipeInputData openRecipeInputData) throws IOException;

    void addToFavourites(OpenRecipeInputData openRecipeInputData);
}
