package Main.data_access;

import Main.entity.Recipe;
import Main.entity.SearchParameters;
import Main.entity.User;
import Main.use_cases.fetch_recipes.FetchRecipesDataAccessInterface;
import Main.use_cases.get_search_parameters.GetSearchParametersDataAccess;
import Main.use_cases.login.LoginUserDataAccessInterface;
import Main.use_cases.popular_recipes.PopularRecipeDataAccess;
import Main.use_cases.signup.SignupUserDataAccessInterface;
import com.google.gson.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface,
        GetSearchParametersDataAccess, FetchRecipesDataAccessInterface, PopularRecipeDataAccess {

    private static final String USERS_FILE_PATH = "src/main/resources/users.csv";
    private static final String RECIPES_FILE_PATH = "src/main/resources/recipes.csv";
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


    /**
     * Checks local CSV file for any users with the provided username.
     * @param username the username to look for
     * @return boolean for pre-existence of username
     */
    @Override
    public boolean existsByName(String username)  {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(USERS_FILE_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;

        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] columns = line.split(";");
            if (columns[0].equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Saves user entity into CSV file
     * @param user the user to save
     */
    @Override
    public void save(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String userpreferences = user.getUserpreferences();

        if (this.existsByName(user.getUsername())) {
            return;
        }

        try (FileWriter writer = new FileWriter(USERS_FILE_PATH, true)) {
            String formattedPreferences = (userpreferences == null || userpreferences.isEmpty())
                    ? "null" : userpreferences;

            writer.append(username).append(";")
                    .append(password).append(";")
                    .append(formattedPreferences)
                    .append(";").append("C").append("\n");
            System.out.println("User added");
        } catch (IOException e) {
            System.err.println("Error while adding user: " + e.getMessage());
        }
    }

    /**
     * Searches local CSV file for user with given username.
     * @param username the username to look up
     * @return User with given username
     */
    @Override
    public User finduser(String username) {

        User user = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(";");
                if (columns[0].equals(username)) {
                    user = new User(username, columns[1], columns[2]);
                    return user;
                }
            }

        } catch (IOException e) {
            System.err.println("Error while reading CSV: " + e.getMessage());
        }
        return user;
    }

    /**
     * Update favourites list in user database.
     * @param username
     * @param recipeId
     */
    @Override
    public void updateFavourites(String username, String recipeId) {
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(";");
                if (columns[0].equals(username)) {
                    if (columns[3].equals("C")) {
                        columns[3] = recipeId;
                    } else {
                        columns[3] += "," + recipeId;
                    }
                }
                updatedLines.add(String.join(";", columns));
            }
        } catch(IOException e) {
            System.err.println("Error while reading CSV: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE_PATH))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            System.out.println("Recipe updated successfully.");
        } catch (IOException e) {
            System.err.println("Error while writing to CSV: " + e.getMessage());
        }
        updateTally(recipeId);
    }

    public void updateTally(String recipeId) {
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(RECIPES_FILE_PATH))) {
            String line;
            boolean flag = false;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(";");
                if (columns[0].equals(recipeId)) {
                    columns[1] += "C";
                    flag = true;
                }
                updatedLines.add(String.join(";", columns));
            }
            if(!flag) {
                try (FileWriter writer = new FileWriter(RECIPES_FILE_PATH, true)) {
                    writer.append(recipeId).append(";").append("C").append("\n");
                    System.out.println("Recipe added");
                } catch (IOException e) {
                    System.err.println("Error while adding user: " + e.getMessage());
                }
            } else {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(RECIPES_FILE_PATH))) {
                    for (String updatedLine : updatedLines) {
                        writer.write(updatedLine);
                        writer.newLine();
                    }
                    System.out.println("Recipe updated successfully.");
                } catch (IOException e) {
                    System.err.println("Error while writing to CSV: " + e.getMessage());
                }
            }
        } catch(IOException e) {
            System.err.println("Error while reading CSV: " + e.getMessage());
            return;
        }


    }


    /**
     * Calls Edemame API to return a list of recipes based on search parameters initialized by used input.
     * @param searchParameters
     * @return a List of recipes.
     */
    @Override
    public List<Recipe> getRecipes(SearchParameters searchParameters) {
        String url = String.format(LIST_PARAMETERS,
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
                String recipeId = (recipe.get("uri").getAsString());
                List<String> ingredients = new ArrayList<>(List.of());
                for (JsonElement ingredient : recipe.get("ingredientLines").getAsJsonArray()) {
                    ingredients.add(ingredient.getAsString());
                }
                String cuisineType = recipe.getAsJsonArray("cuisineType").get(0).getAsString();
                int calories = (int) recipe.get("calories").getAsDouble();
                String mealType = recipe.get("mealType").getAsString();

                Recipe newrecipe = new Recipe(recipeId, recipename, cuisineType, mealType, ingredients, calories);

                recipes.add(newrecipe);
            }
        }

        catch (RuntimeException | IOException e) {
            return recipes;
        }
        return recipes;
    }

    /**
     * Checks a user's favourites to see if the given recipe is already added.
     * @param username
     * @param recipeId
     * @return boolean to check if recipe is in list
     */
    @Override
    public boolean recipeInFavourites(String username, String recipeId) {

        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(";");
                if (columns[0].equals(username)) {
                    if(columns[3].equals("C")) {
                        return false;
                    }
                    List<String> favourites = List.of(columns[3].split(","));
                    return favourites.contains(recipeId);
                }
            }

        } catch (IOException e) {
            System.err.println("Error while reading CSV: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<Recipe> getrecipes(SearchParameters searchParameters) {
        return List.of();
    }

    /**
     * Calls API to find return a single recipe based on a URI, which is used as a recipe's recipeID.
     * @param recipeId
     * @return Recipe given recipeID.
     */
    @Override
    public Recipe findrecipe(String recipeId) {
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

            String recipename = recipe.get("label").getAsString();
            String cuisineType = recipe.getAsJsonArray("cuisineType").get(0).getAsString();
            String mealtType = recipe.getAsJsonArray("mealType").getAsString();
            int calories = (int) recipe.get("calories").getAsDouble();

            newrecipe = new Recipe(recipeId, recipename, cuisineType, mealtType, ingredients, calories);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newrecipe;
    }


    @Override
    public List<Recipe> getTopRecipes() {
        List<Recipe> favouritedRecipes = new ArrayList<>(List.of());

        try (BufferedReader reader = new BufferedReader(new FileReader(RECIPES_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(";");
                Recipe recipe = findrecipe(columns[0]);
                recipe.setFavourties(columns[1].length());
                favouritedRecipes.add(recipe);
            }
            favouritedRecipes.sort(Comparator.comparingInt(Recipe::getFavourties));
            return favouritedRecipes;

        } catch (IOException e) {
            System.err.println("Error while reading CSV: " + e.getMessage());
        }
        return favouritedRecipes;
    }
}
