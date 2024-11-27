package Main.app;

import Main.data_access.DBUserDataAccessObject;
import Main.interface_adapter.ViewManagerModel;
import Main.interface_adapter.change_password.LoggedInViewModel;
import Main.interface_adapter.login.LoginPresenter;
import Main.interface_adapter.login.LoginViewModel;
import Main.interface_adapter.login.LoginController;
import Main.interface_adapter.signup.SignupController;
import Main.interface_adapter.signup.SignupPresenter;
import Main.interface_adapter.signup.SignupViewModel;

import Main.use_cases.login.LoginOutputBoundary;
import Main.use_cases.login.LoginInputBoundary;
import Main.use_cases.login.LoginInteractor;
import Main.use_cases.signup.SignupInputBoundary;
import Main.use_cases.signup.SignupInteractor;
import Main.use_cases.signup.SignupOutputBoundary;
import Main.view.LoggedInView;
import Main.view.LoginView;
import Main.view.SignupView;
import Main.view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class ReciperSearchBuilder {

    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?

    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final DBUserDataAccessObject userDataAccessObject = new DBUserDataAccessObject();


    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;


    public ReciperSearchBuilder() { cardPanel.setLayout(cardLayout); }

    public ReciperSearchBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    public ReciperSearchBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(signupView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }

    public ReciperSearchBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    public ReciperSearchBuilder addLoginUseCase() {
        LoggedInViewModel loggedInViewModel;
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                this.loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }
}
