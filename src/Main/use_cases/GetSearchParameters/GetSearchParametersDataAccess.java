package Main.use_cases.GetSearchParameters;

import Main.entity.SearchParameters;
import Main.entity.User;

public interface GetSearchParametersDataAccess {

    void saveSearchParameters(SearchParameters searchParameters);

    User finduser(String username);
}
