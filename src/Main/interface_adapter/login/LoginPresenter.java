package Main.interface_adapter.login;

import Main.interface_adapter.ViewManagerModel;
import Main.interface_adapter.change_password.LoggedInState;
import Main.interface_adapter.change_password.LoggedInViewModel;
import Main.interface_adapter.get_search_parameters.GetSearchParametersState;
import Main.interface_adapter.get_search_parameters.GetSearchParametersViewModel;
import Main.use_cases.login.LoginOutputBoundary;
import Main.use_cases.login.LoginOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final GetSearchParametersViewModel getSearchParametersViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          GetSearchParametersViewModel getSearchParametersViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.getSearchParametersViewModel = getSearchParametersViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the menu view.

        final GetSearchParametersState getSearchParametersState = getSearchParametersViewModel.getState();
        getSearchParametersState.setDiet(response.getUserpreferences());
        this.getSearchParametersViewModel.setState(getSearchParametersState);
        this.getSearchParametersViewModel.firePropertyChanged();

        this.viewManagerModel.setState(getSearchParametersViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final LoginState loginState = loginViewModel.getState();
        loginState.setLoginError(error);
        loginViewModel.firePropertyChanged();
    }
}
