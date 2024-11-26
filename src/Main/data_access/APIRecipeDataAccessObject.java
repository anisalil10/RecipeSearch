package Main.data_access;

import Main.entity.Recipe;
import Main.entity.RecipeId;
import Main.entity.SearchParameters;
import Main.use_cases.FetchRecipes.FetchRecipesDataAccessInterface;

import com.google.gson.JsonElement;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class APIRecipeDataAccessObject implements FetchRecipesDataAccessInterface {

    private static final String APP_ID = "c03d65b1";
    private static final String APP_KEY = "c3c27ee6dc05a7492855a611751fe8dc";
    private static final String BASE_URL = "https://api.edamam.com/api/recipes/v2";
    private static final String PARAMETERS = "%s?type=public&q=%s&app_id=%s&app_key=%s&cuisineType=%s&mealType=%s&diet=%s";

    private final SearchParameters searchParameters;

    public APIRecipeDataAccessObject(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }
// Mallika's work!!!
    @Override
    public List<Recipe> getrecipes(SearchParameters searchParameters) {
        String url = String.format(PARAMETERS,
                BASE_URL,
                URLEncoder.encode(searchParameters.getQuery(), StandardCharsets.UTF_8),
                APP_ID,
                APP_KEY,
                URLEncoder.encode(searchParameters.getCuisineType(), StandardCharsets.UTF_8),
                URLEncoder.encode(searchParameters.getMealType(), StandardCharsets.UTF_8),
                URLEncoder.encode(searchParameters.getDiet(), StandardCharsets.UTF_8)
        );

        List<Recipe> recipes = new ArrayList<>();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            String response = httpClient.execute(request, httpResponse ->
                    EntityUtils.toString(httpResponse.getEntity()));

            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);
            JsonArray hits = jsonResponse.getAsJsonArray("hits");

            for (int i = 0; i < Math.min(searchParameters.getMaxResults(), hits.size()); i++) {

                JsonObject recipe = hits.get(i).getAsJsonObject().getAsJsonObject("recipe");
                String recipename = recipe.get("label").getAsString();
                RecipeId recipeId = new RecipeId(recipe.get("url").getAsString());
                List<String> ingredients = new ArrayList<>(List.of());
                for (JsonElement ingredient : recipe.get("ingredientLines").getAsJsonArray()) {
                    ingredients.add(ingredient.getAsString());
                }
                String cuisineType = recipe.getAsJsonArray("cuisineType").get(0).getAsString();
                int calories = (int) recipe.get("calories").getAsDouble();

                Recipe newrecipe = new Recipe(recipeId, recipename, cuisineType, ingredients, calories);

                recipes.add(newrecipe);
            }
        }

        catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }

        return recipes;
        }
    }
