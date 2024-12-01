package Main.interface_adapter.signup;

import Main.interface_adapter.ViewManagerModel;
import Main.interface_adapter.get_search_parameters.GetSearchParametersState;
import Main.interface_adapter.get_search_parameters.GetSearchParametersViewModel;
import Main.interface_adapter.login.LoginState;
import Main.interface_adapter.login.LoginViewModel;
import Main.use_cases.signup.SignupOutputBoundary;
import Main.use_cases.signup.SignupOutputData;

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
