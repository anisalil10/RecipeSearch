package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_search_parameters.GetSearchParametersState;
import interface_adapter.get_search_parameters.GetSearchParametersViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_cases.signup.SignupOutputBoundary;
import use_cases.signup.SignupOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class SignupPresenter implements SignupOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;
    private final GetSearchParametersViewModel getSearchParametersViewModel;

    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel, LoginViewModel loginViewModel,
                           GetSearchParametersViewModel getSearchParametersViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
        this.getSearchParametersViewModel = getSearchParametersViewModel;
    }

    @Override
    public void prepareSuccessView(SignupOutputData response) {
        // On success, switch to the RecipeSearch view.
        final GetSearchParametersState getSearchParametersState = getSearchParametersViewModel.getState();
        getSearchParametersState.setDiet(response.getUserpreferences());
        getSearchParametersState.setUsername(response.getUsername());

        this.getSearchParametersViewModel.setState(getSearchParametersState);
        getSearchParametersViewModel.firePropertyChanged();
        viewManagerModel.setState(getSearchParametersViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }

    @Override
    public void switchToLoginView() {
        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
