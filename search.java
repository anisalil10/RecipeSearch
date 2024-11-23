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

/**
 * Search - A simple application to fetch recipes from the Edamam Recipe Search API.
 */
public class Search {

    // Edamam API credentials
    private static final String APP_ID = "c03d65b1";
    private static final String APP_KEY = "c3c27ee6dc05a7492855a611751fe8dc";
    private static final String BASE_URL = "https://api.edamam.com/api/recipes/v2";

    public static void main(String[] args) {
        // Example user input
        String query = "chicken";          // Keyword for the recipe search
        String cuisineType = "Italian";   // Cuisine filter (optional)
        String mealType = "Dinner";       // Meal type filter (optional)
        String diet = "low-carb";         // Diet filter (optional)
        int maxResults = 5;               // Limit for the number of recipes displayed

        try {
            // Perform recipe search
            searchRecipes(query, cuisineType, mealType, diet, maxResults);

            // Run test case
            testRecipeSearch();
        } catch (IOException e) {
            System.err.println("Error while fetching recipes: " + e.getMessage());
        }
    }

    /**
     * Searches for recipes using the Edamam Recipe Search API.
     *
     * @param query       The main keyword for the recipe search (e.g., "chicken").
     * @param cuisineType Optional filter for cuisine type (e.g., "Italian").
     * @param mealType    Optional filter for meal type (e.g., "Dinner").
     * @param diet        Optional filter for dietary preferences (e.g., "low-carb").
     * @param maxResults  The maximum number of recipes to display.
     * @throws IOException If there is an error with the API request or response parsing.
     */
    public static void searchRecipes(String query, String cuisineType, String mealType, String diet, int maxResults) throws IOException {
        // Build query parameters
        String url = String.format(
                "%s?type=public&q=%s&app_id=%s&app_key=%s&cuisineType=%s&mealType=%s&diet=%s",
                BASE_URL,
                URLEncoder.encode(query, StandardCharsets.UTF_8),
                APP_ID,
                APP_KEY,
                URLEncoder.encode(cuisineType, StandardCharsets.UTF_8),
                URLEncoder.encode(mealType, StandardCharsets.UTF_8),
                URLEncoder.encode(diet, StandardCharsets.UTF_8)
        );

        // Create an HTTP client and execute the GET request
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            String response = httpClient.execute(request, httpResponse -> {
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    throw new IOException("Failed API call: HTTP " + statusCode + " - " + httpResponse.getStatusLine().getReasonPhrase());
                }
                return EntityUtils.toString(httpResponse.getEntity());
            });


            // Parse and display the response
            parseAndDisplayRecipes(response, maxResults);
        }
    }

    /**
     * Parses the API response and displays the top recipes.
     *
     * @param response   The JSON response from the API.
     * @param maxResults The maximum number of recipes to display.
     */
    private static void parseAndDisplayRecipes(String response, int maxResults) {
        // Parse JSON response using Gson
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);
        JsonArray hits = jsonResponse.getAsJsonArray("hits");

        System.out.println("Top Recipes:");
        for (int i = 0; i < Math.min(maxResults, hits.size()); i++) {
            JsonObject recipe = hits.get(i).getAsJsonObject().getAsJsonObject("recipe");
            String label = recipe.get("label").getAsString();
            String url = recipe.get("url").getAsString();
            String cuisineType = recipe.getAsJsonArray("cuisineType").get(0).getAsString();
            int calories = (int) recipe.get("calories").getAsDouble();

            System.out.println((i + 1) + ". " + label);
            System.out.println("   Cuisine: " + cuisineType);
            System.out.println("   URL: " + url);
            System.out.println("   Calories: " + calories);
            System.out.println();
        }
    }

    /**
     * Test case for recipe search.
     */
    private static void testRecipeSearch() {
        System.out.println("\nRunning Test Case: Recipe Search");

        String testQuery = "salmon";
        String testCuisineType = "Asian";
        String testMealType = "Dinner";
        String testDiet = "low-fat";

        try {
            // Perform a recipe search
            List<String> results = searchAndReturnRecipeNames(testQuery, testCuisineType, testMealType, testDiet, 3);

            // Validate results
            if (results.size() > 0) {
                System.out.println("Test Passed: Recipes returned successfully.");
                for (String recipe : results) {
                    System.out.println("   Recipe: " + recipe);
                }
            } else {
                System.out.println("Test Failed: No recipes returned.");
            }
        } catch (IOException e) {
            System.out.println("Test Failed: Error occurred - " + e.getMessage());
        }
    }

    /**
     * Helper function to return recipe names as a list (used for testing).
     *
     * @param query       The main keyword for the recipe search (e.g., "salmon").
     * @param cuisineType Optional filter for cuisine type.
     * @param mealType    Optional filter for meal type.
     * @param diet        Optional filter for dietary preferences.
     * @param maxResults  The maximum number of recipes to fetch.
     * @return List of recipe names.
     * @throws IOException If there is an error with the API request or response parsing.
     */
    private static List<String> searchAndReturnRecipeNames(String query, String cuisineType, String mealType, String diet, int maxResults) throws IOException {
        String url = String.format(
                "%s?type=public&q=%s&app_id=%s&app_key=%s&cuisineType=%s&mealType=%s&diet=%s",
                BASE_URL,
                URLEncoder.encode(query, StandardCharsets.UTF_8),
                APP_ID,
                APP_KEY,
                URLEncoder.encode(cuisineType, StandardCharsets.UTF_8),
                URLEncoder.encode(mealType, StandardCharsets.UTF_8),
                URLEncoder.encode(diet, StandardCharsets.UTF_8)
        );

        List<String> recipeNames = new ArrayList<>();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            String response = httpClient.execute(request, httpResponse -> {
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    throw new IOException("Failed API call: HTTP " + statusCode + " - " + httpResponse.getStatusLine().getReasonPhrase());
                }
                return EntityUtils.toString(httpResponse.getEntity());
            });


            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);
            JsonArray hits = jsonResponse.getAsJsonArray("hits");

            for (int i = 0; i < Math.min(maxResults, hits.size()); i++) {
                JsonObject recipe = hits.get(i).getAsJsonObject().getAsJsonObject("recipe");
                recipeNames.add(recipe.get("label").getAsString());
            }
        }

        return recipeNames;
    }
}
