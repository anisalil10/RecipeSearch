package app;

import data_access.DataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_search_parameters.GetSearchParametersController;
import interface_adapter.get_search_parameters.GetSearchParametersPresenter;
import interface_adapter.get_search_parameters.GetSearchParametersViewModel;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.popular_recipes.PopularRecipesController;
import interface_adapter.popular_recipes.PopularRecipesPresenter;
import interface_adapter.popular_recipes.PopularRecipesViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;


import interface_adapter.viewfavourites.FavouritesController;
import interface_adapter.viewfavourites.FavouritesPresenter;
import interface_adapter.viewfavourites.FavouritesViewModel;
import use_cases.get_search_parameters.GetSearchParametersInputBoundary;
import use_cases.get_search_parameters.GetSearchParametersInteractor;
import use_cases.get_search_parameters.GetSearchParametersOutputBoundary;
import use_cases.login.LoginOutputBoundary;
import use_cases.login.LoginInputBoundary;
import use_cases.login.LoginInteractor;
import use_cases.popular_recipes.PopularRecipesInputBoundary;
import use_cases.popular_recipes.PopularRecipesInteractor;
import use_cases.popular_recipes.PopularRecipesOutputBoundary;
import use_cases.signup.SignupInputBoundary;
import use_cases.signup.SignupInteractor;
import use_cases.signup.SignupOutputBoundary;
import use_cases.viewfavourites.FavouritesInputBoundary;
import use_cases.viewfavourites.FavouritesInteractor;
import use_cases.viewfavourites.FavouritesOutputBoundary;
import view.*;

import javax.swing.*;
import java.awt.*;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
public class ReciperSearchBuilder {

    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?

    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final DataAccessObject dataAccessObject = new DataAccessObject();

    private SignupView signupView;
    private RecipeSearchView recipeSearchView;
    private PopularRecipesView popularRecipesView;
    private FavouritesView favouritesView;
    private LoginView loginView;

    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private GetSearchParametersViewModel getSearchParametersViewModel;
    private PopularRecipesViewModel popularRecipesViewModel;
    private FavouritesViewModel favouritesViewModel;

    public ReciperSearchBuilder() { cardPanel.setLayout(cardLayout); }

    /**
     * Adds the Signup View to the application.
     * @return this builder
     */
    public ReciperSearchBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, SignupView.getViewName());
        return this;
    }

    /**
     * Adds the Recipe Search View to the application.
     * @return this builder
     */
    public ReciperSearchBuilder addRecipeSearchView() {
        getSearchParametersViewModel = new GetSearchParametersViewModel();

        recipeSearchView = new RecipeSearchView(getSearchParametersViewModel);
        cardPanel.add(recipeSearchView, RecipeSearchView.getViewName());
        return this;
    }

    public ReciperSearchBuilder addPopularRecipesView() {
        popularRecipesViewModel = new PopularRecipesViewModel();

        popularRecipesView = new PopularRecipesView(popularRecipesViewModel);
        cardPanel.add(popularRecipesView, PopularRecipesView.getViewName());
        return this;
    }

    /**
     * Adds the Login View to the application.
     * @return this builder
     */
    public ReciperSearchBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, LoginView.getViewName());
        return this;
    }

    public ReciperSearchBuilder addFavouritesView() {
        favouritesViewModel = new FavouritesViewModel();

        favouritesView = new FavouritesView(favouritesViewModel);
        cardPanel.add(favouritesView, FavouritesView.getViewName());
        return this;
    }

    /**
     * Adds the Signup Use Case to the application.
     * @return this builder
     */
    public ReciperSearchBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel, getSearchParametersViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                dataAccessObject, signupOutputBoundary);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    /**
     * Adds the Login Use Case to the application.
     * @return this builder
     */
    public ReciperSearchBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                getSearchParametersViewModel, loginViewModel, signupViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                dataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;

    }


    /**
     * Adds the Recipe Search Use Case to the application.
     * @return this builder
     */
    public ReciperSearchBuilder addRecipeSearchUseCase() {
        final GetSearchParametersOutputBoundary outputBoundary = new GetSearchParametersPresenter(
                getSearchParametersViewModel, popularRecipesViewModel, favouritesViewModel, viewManagerModel);
        final GetSearchParametersInputBoundary getSearchParametersInteractor = new GetSearchParametersInteractor(
                dataAccessObject, outputBoundary);

        final GetSearchParametersController getSearchParametersController = new GetSearchParametersController(
                getSearchParametersInteractor);
        recipeSearchView.setGetSearchParametersController(getSearchParametersController);
        return this;
    }

    public ReciperSearchBuilder addPopularRecipesUseCase() {
        final PopularRecipesOutputBoundary outputBoundary = new PopularRecipesPresenter(popularRecipesViewModel,
                getSearchParametersViewModel, viewManagerModel);
        final PopularRecipesInputBoundary popularRecipesInteractor = new PopularRecipesInteractor(dataAccessObject,
                outputBoundary);

        final PopularRecipesController popularRecipesController =
                new PopularRecipesController(popularRecipesInteractor);
        popularRecipesView.setPopularRecipesController(popularRecipesController);
        return this;
    }

    public ReciperSearchBuilder addFavouritesUseCase() {
        final FavouritesOutputBoundary outputBoundary = new FavouritesPresenter(favouritesViewModel,
                viewManagerModel);
        final FavouritesInputBoundary favouritesInteractor = new FavouritesInteractor(dataAccessObject,
                outputBoundary);

        final FavouritesController favouritesController =
                new FavouritesController(favouritesInteractor);
        favouritesView.setFavouritesController(favouritesController);
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("Recipe Search");
        Dimension d = new Dimension(300, 300);
        application.setSize(d);
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(LoginView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }


}
