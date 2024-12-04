package Main.data_access;

import Main.entity.Recipe;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class test2 {

    private static final String APP_ID = "c03d65b1";
    private static final String APP_KEY = "c3c27ee6dc05a7492855a611751fe8dc";
    private static final String BASE_URL = "https://api.edamam.com/api/recipes/v2";
    private static final String BASE_URI = "https://api.edamam.com/api/recipes/v2/by-uri?";
    private static final String LIST_PARAMETERS = "%s?type=public&q=%s&app_id=%s&app_key=%s&cuisineType=%s&mealType=" +
            "%s&diet=%s";
    private static final String URI_PARAMETERS = "%stype=public&beta=true&uri=%s&app_id=%s&app_key=%s" +
            "&field=label&field=image&field=images&field=source&field=url&field=shareAs&field=yield&fi" +
            "eld=dietLabels&field=healthLabels&field=cautions&field=ingredientLines&field=ingredients&field=calories" +
            "&field=totalWeight&field=totalTime&field=cuisineType&field=mealType&field=dishType";


    public static void main(String[] args) {

        final String recipeId = "http://www.edamam.com/ontologies/edamam.owl#recipe_6dc325d44c7bc6c220f9e5a0dba2a333";
        String url = String.format(
                URI_PARAMETERS, BASE_URI, URLEncoder.encode(recipeId, StandardCharsets.UTF_8), APP_ID, APP_KEY
        );

        Recipe newrecipe;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            String response = httpClient.execute(request, httpResponse ->
                    EntityUtils.toString(httpResponse.getEntity()));

            Gson gson = new Gson();

            JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);
            JsonArray hits = jsonResponse.getAsJsonArray("hits");

            JsonObject recipe = hits.get(0).getAsJsonObject().getAsJsonObject("recipe");

            List<String> ingredients = new ArrayList<>(List.of());
            for (JsonElement ingredient : recipe.get("ingredientLines").getAsJsonArray()) {
                ingredients.add(ingredient.getAsString());
            }

            String recipeName = recipe.get("label").getAsString();
            String cuisineType = recipe.getAsJsonArray("cuisineType").get(0).getAsString();
            String mealtType = recipe.getAsJsonArray("mealType").getAsString();
            int calories = (int) recipe.get("calories").getAsDouble();

            newrecipe = new Recipe(recipeId, recipeName, cuisineType, mealtType, ingredients, calories);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(newrecipe.getName());
    }

}
