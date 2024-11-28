package Main.app;

import Main.data_access.APIRecipeDataAccessObject;
import Main.data_access.DBUserDataAccessObject;
import Main.interface_adapter.ViewManagerModel;
import Main.interface_adapter.change_password.LoggedInViewModel;
import Main.interface_adapter.fetch_recipes.FetchRecipesController;
import Main.interface_adapter.fetch_recipes.FetchRecipesPresenter;
import Main.interface_adapter.fetch_recipes.FetchRecipesState;
import Main.interface_adapter.fetch_recipes.FetchRecipesViewModel;
import Main.interface_adapter.get_search_parameters.GetSearchParametersController;
import Main.interface_adapter.get_search_parameters.GetSearchParametersPresenter;
import Main.interface_adapter.get_search_parameters.GetSearchParametersViewModel;
import Main.interface_adapter.login.LoginPresenter;
import Main.interface_adapter.login.LoginViewModel;
import Main.interface_adapter.login.LoginController;
import Main.interface_adapter.signup.SignupController;
import Main.interface_adapter.signup.SignupPresenter;
import Main.interface_adapter.signup.SignupViewModel;


import Main.use_cases.FetchRecipes.FetchRecipesInputBoundary;
import Main.use_cases.FetchRecipes.FetchRecipesInteractor;
import Main.use_cases.FetchRecipes.FetchRecipesOutputBoundary;
import Main.use_cases.GetSearchParameters.GetSearchParametersInputBoundary;
import Main.use_cases.GetSearchParameters.GetSearchParametersInteractor;
import Main.use_cases.GetSearchParameters.GetSearchParametersOutputBoundary;
import Main.use_cases.login.LoginOutputBoundary;
import Main.use_cases.login.LoginInputBoundary;
import Main.use_cases.login.LoginInteractor;
import Main.use_cases.signup.SignupInputBoundary;
import Main.use_cases.signup.SignupInteractor;
import Main.use_cases.signup.SignupOutputBoundary;
import Main.view.*;

import javax.swing.*;
import java.awt.*;


public class ReciperSearchBuilder {

    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?

    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final DBUserDataAccessObject userDataAccessObject = new DBUserDataAccessObject();
    private final APIRecipeDataAccessObject recipeDataAccessObject = new APIRecipeDataAccessObject();


    private SignupView signupView;
    private RecipeSearchView recipeSearchView;
    private RecipeMenuView recipeMenuView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;
    private GetSearchParametersViewModel getSearchParametersViewModel;
    private FetchRecipesViewModel fetchRecipesViewModel;


    public ReciperSearchBuilder() { cardPanel.setLayout(cardLayout); }

    public ReciperSearchBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    public ReciperSearchBuilder addRecipeSearchView() {
        getSearchParametersViewModel = new GetSearchParametersViewModel();
        recipeSearchView = new RecipeSearchView(getSearchParametersViewModel);
        cardPanel.add(recipeSearchView, recipeSearchView.getViewName());
        return this;
    }

    public ReciperSearchBuilder addRecipeMenuView() {
        fetchRecipesViewModel = new FetchRecipesViewModel();
        recipeMenuView = new RecipeMenuView(fetchRecipesViewModel);
        cardPanel.add(recipeMenuView, recipeMenuView.getViewName());
        return this;
    }

    public ReciperSearchBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("Recipe Login");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(SignupView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }

    public ReciperSearchBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel, getSearchParametersViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    public ReciperSearchBuilder addRecipeSearchUseCase() {
        final GetSearchParametersOutputBoundary outputBoundary = new GetSearchParametersPresenter(
                getSearchParametersViewModel, fetchRecipesViewModel, viewManagerModel);
        final GetSearchParametersInputBoundary getSearchParametersInteractor = new GetSearchParametersInteractor(
                userDataAccessObject, outputBoundary);

        final GetSearchParametersController getSearchParametersController = new GetSearchParametersController(
                getSearchParametersInteractor);
        recipeSearchView.setGetSearchParametersController(getSearchParametersController);
        return this;
    }

    public ReciperSearchBuilder addRecipeMenuUseCase() {
        final FetchRecipesOutputBoundary outputBoundary = new FetchRecipesPresenter(
                fetchRecipesViewModel, viewManagerModel);
        final FetchRecipesInputBoundary fetchRecipesInteractor = new FetchRecipesInteractor(
                recipeDataAccessObject, outputBoundary);

        final FetchRecipesController fetchRecipesController = new FetchRecipesController(
                fetchRecipesInteractor);
        recipeMenuView.setFetchRecipesController(fetchRecipesController);
        return this;
    }

    public ReciperSearchBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                this.loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }


}
