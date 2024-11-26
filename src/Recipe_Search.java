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
import java.util.List;

/**
 * Recipe_Search - A simple application to fetch recipes from the Edamam Recipe Search API.
 */
public class Recipe_Search {

    // Edamam API credentials
    private static final String APP_ID = "c03d65b1";
    private static final String APP_KEY = "c3c27ee6dc05a7492855a611751fe8dc";
    private static final String BASE_URL = "https://api.edamam.com/api/recipes/v2";

    public static void main(String[] args) {
        // Create a user and update dietary preferences
        User user = new User("Dave", "password123", "dave@example.com");
        System.out.println("Updating dietary preferences...");
        PreferencesManager.updateDietaryPreferences(user);

        // Perform a recipe search using updated preferences
        System.out.println("\nSearching for recipes...");
        try {
            searchRecipesWithPreferences(user, "chicken", 5);
        } catch (IOException e) {
            System.err.println("Error while fetching recipes: " + e.getMessage());
        }
    }

    /**
     * Searches for recipes using the Edamam Recipe Search API with dietary preferences.
     *
     * @param user       The user object containing dietary preferences.
     * @param query      The main keyword for the recipe search (e.g., "chicken").
     * @param maxResults The maximum number of recipes to display.
     * @throws IOException If there is an error with the API request or response parsing.
     */
    public static void searchRecipesWithPreferences(User user, String query, int maxResults) throws IOException {
        UserPreferences preferences = user.getPreferences();
        List<String> dietaryRestrictions = preferences.getDietaryRestrictions();

        // Build query parameters
        StringBuilder urlBuilder = new StringBuilder(String.format(
                "%s?type=public&q=%s&app_id=%s&app_key=%s",
                BASE_URL,
                URLEncoder.encode(query, StandardCharsets.UTF_8),
                APP_ID,
                APP_KEY
        ));

        // Add dietary restrictions to the query
        for (String restriction : dietaryRestrictions) {
            urlBuilder.append("&health=").append(URLEncoder.encode(restriction, StandardCharsets.UTF_8));
        }

        String url = urlBuilder.toString();

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
}
