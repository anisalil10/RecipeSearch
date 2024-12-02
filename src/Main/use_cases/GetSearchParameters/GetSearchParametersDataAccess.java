package Main.use_cases.GetSearchParameters;

import Main.entity.Recipe;
import Main.entity.SearchParameters;
import Main.entity.User;

import java.util.List;

public interface GetSearchParametersDataAccess {

    void saveSearchParameters(SearchParameters searchParameters);

    public List<Recipe> getrecipes(SearchParameters searchParameters);

}
