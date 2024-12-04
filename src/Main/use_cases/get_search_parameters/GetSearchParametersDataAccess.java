package Main.use_cases.get_search_parameters;

import Main.entity.Recipe;
import Main.entity.SearchParameters;

import java.util.List;

public interface GetSearchParametersDataAccess {

    void saveSearchParameters(SearchParameters searchParameters);

    public List<Recipe> getrecipes(SearchParameters searchParameters);

}
