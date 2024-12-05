package Main.app;

import Main.data_access.DataAccessObject;
import Main.interface_adapter.ViewManagerModel;
import Main.interface_adapter.fetch_recipes.FetchRecipesController;
import Main.interface_adapter.fetch_recipes.FetchRecipesPresenter;
import Main.interface_adapter.fetch_recipes.FetchRecipesViewModel;
import Main.interface_adapter.get_search_parameters.GetSearchParametersController;
import Main.interface_adapter.get_search_parameters.GetSearchParametersPresenter;
import Main.interface_adapter.get_search_parameters.GetSearchParametersViewModel;
import Main.interface_adapter.login.LoginPresenter;
import Main.interface_adapter.login.LoginViewModel;
import Main.interface_adapter.login.LoginController;
import Main.interface_adapter.open_recipe.OpenRecipeController;
import Main.interface_adapter.open_recipe.OpenRecipePresenter;
import Main.interface_adapter.open_recipe.OpenRecipeViewModel;
import Main.interface_adapter.signup.SignupController;
import Main.interface_adapter.signup.SignupPresenter;
import Main.interface_adapter.signup.SignupViewModel;


import Main.use_cases.fetch_recipes.FetchRecipesInputBoundary;
import Main.use_cases.fetch_recipes.FetchRecipesInteractor;
import Main.use_cases.fetch_recipes.FetchRecipesOutputBoundary;
import Main.use_cases.get_search_parameters.GetSearchParametersInputBoundary;
import Main.use_cases.get_search_parameters.GetSearchParametersInteractor;
import Main.use_cases.get_search_parameters.GetSearchParametersOutputBoundary;
import Main.use_cases.login.LoginOutputBoundary;
import Main.use_cases.login.LoginInputBoundary;
import Main.use_cases.login.LoginInteractor;
import Main.use_cases.open_recipe.OpenRecipeInputBoundary;
import Main.use_cases.open_recipe.OpenRecipeInteractor;
import Main.use_cases.open_recipe.OpenRecipeOutputBoundary;
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

    private final DataAccessObject dataAccessObject = new DataAccessObject();

    private SignupView signupView;
    private RecipeSearchView recipeSearchView;
    private RecipeMenuView recipeMenuView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoginView loginView;
    private RecipeView recipeView;
    private GetSearchParametersViewModel getSearchParametersViewModel;
    private FetchRecipesViewModel fetchRecipesViewModel;
    private OpenRecipeViewModel openRecipeViewModel;


    public ReciperSearchBuilder() { cardPanel.setLayout(cardLayout); }

    public ReciperSearchBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    public ReciperSearchBuilder addRecipeSearchView() {
        getSearchParametersViewModel = new GetSearchParametersViewModel();
        fetchRecipesViewModel = new FetchRecipesViewModel();
        recipeSearchView = new RecipeSearchView(getSearchParametersViewModel);
        cardPanel.add(recipeSearchView, recipeSearchView.getViewName());
        return this;
    }

    public ReciperSearchBuilder addRecipeMenuView() {
//        fetchRecipesViewModel = new FetchRecipesViewModel();
//        recipeMenuView = new RecipeMenuView(fetchRecipesViewModel);
//        cardPanel.add(recipeMenuView, recipeMenuView.getViewName());
        return this;
    }

    public ReciperSearchBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    public ReciperSearchBuilder addRecipeView() {
        openRecipeViewModel = new OpenRecipeViewModel();
        recipeView = new RecipeView(openRecipeViewModel);
        cardPanel.add(recipeView, recipeView.getViewName());
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("Recipe Login");
        Dimension d = new Dimension(300, 300);
        application.setSize(d);
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
                dataAccessObject, signupOutputBoundary);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    public ReciperSearchBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                this.getSearchParametersViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                dataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    public ReciperSearchBuilder addRecipeSearchUseCase() {
        final GetSearchParametersOutputBoundary outputBoundary = new GetSearchParametersPresenter(
                getSearchParametersViewModel, openRecipeViewModel, viewManagerModel);
        final GetSearchParametersInputBoundary getSearchParametersInteractor = new GetSearchParametersInteractor(
                dataAccessObject, outputBoundary);

        final GetSearchParametersController getSearchParametersController = new GetSearchParametersController(
                getSearchParametersInteractor);
        recipeSearchView.setGetSearchParametersController(getSearchParametersController);
        return this;
    }

    public ReciperSearchBuilder addRecipeMenuUseCase() {
//        final FetchRecipesOutputBoundary outputBoundary = new FetchRecipesPresenter(
//                fetchRecipesViewModel, openRecipeViewModel, viewManagerModel);
//        final FetchRecipesInputBoundary fetchRecipesInteractor = new FetchRecipesInteractor(
//                dataAccessObject, outputBoundary);
//        final FetchRecipesController fetchRecipesController = new FetchRecipesController(
//                fetchRecipesInteractor);
//
//        recipeMenuView.setFetchRecipesController(fetchRecipesController);
        return this;
    }

    public ReciperSearchBuilder addOpenRecipeUseCase() {
        final OpenRecipeOutputBoundary outputBoundary = new OpenRecipePresenter(
                openRecipeViewModel, viewManagerModel);
        final OpenRecipeInputBoundary openRecipeInteractor = new OpenRecipeInteractor(dataAccessObject, outputBoundary);
        final OpenRecipeController openRecipeController = new OpenRecipeController(openRecipeInteractor);

        recipeView.setOpenRecipeController(openRecipeController);
        return this;
    }


}
