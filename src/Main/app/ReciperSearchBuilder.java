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
import Main.interface_adapter.popular_recipes.PopularRecipesController;
import Main.interface_adapter.popular_recipes.PopularRecipesPresenter;
import Main.interface_adapter.popular_recipes.PopularRecipesViewModel;
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
import Main.use_cases.popular_recipes.PopularRecipesInputBoundary;
import Main.use_cases.popular_recipes.PopularRecipesInteractor;
import Main.use_cases.popular_recipes.PopularRecipesOutputBoundary;
import Main.use_cases.signup.SignupInputBoundary;
import Main.use_cases.signup.SignupInteractor;
import Main.use_cases.signup.SignupOutputBoundary;
import Main.view.*;

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
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoginView loginView;
    private GetSearchParametersViewModel getSearchParametersViewModel;
    private PopularRecipesViewModel popularRecipesViewModel;
    private ProfileView profileView;
    private FavouritesView favouritesView;


    public ReciperSearchBuilder() { cardPanel.setLayout(cardLayout); }

    /**
     * Adds the Signup View to the application.
     * @return this builder
     */
    public ReciperSearchBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    /**
     * Adds the Recipe Search View to the application.
     * @return this builder
     */
    public ReciperSearchBuilder addRecipeSearchView() {
        getSearchParametersViewModel = new GetSearchParametersViewModel();
        popularRecipesViewModel = new PopularRecipesViewModel();

        recipeSearchView = new RecipeSearchView(getSearchParametersViewModel);
        cardPanel.add(recipeSearchView, recipeSearchView.getViewName());
        return this;
    }

    public ReciperSearchBuilder addPopularRecipesView() {
        popularRecipesViewModel = new PopularRecipesViewModel();

        popularRecipesView = new PopularRecipesView(popularRecipesViewModel);
        cardPanel.add(popularRecipesView, popularRecipesView.getViewName());
        return this;
    }

    /**
     * Adds the Login View to the application.
     * @return this builder
     */
    public ReciperSearchBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
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
     * Adds the Profile View to the application.
     * @return this builder
     */
    public ReciperSearchBuilder addProfileView(String username) {
        profileView = new ProfileView(username);

        // Add action for navigating to favourites

        return this;
    }

    /**
     * Adds the Favourites View to the application.
     * @return this builder
     */

    public ReciperSearchBuilder addFavouritesView(String username) {
        favouritesView = new FavouritesView();

        // Populate the favourites list with data from DataAccessObject
        favouritesView.updateRecipeList(dataAccessObject.getFavoriteRecipeNames(username));

        // Add action for navigating back to the profile view

        return this;
    }


    /**
     * Adds the Recipe Search Use Case to the application.
     * @return this builder
     */
    public ReciperSearchBuilder addRecipeSearchUseCase() {
        final GetSearchParametersOutputBoundary outputBoundary = new GetSearchParametersPresenter(
                getSearchParametersViewModel, popularRecipesViewModel, viewManagerModel);
        final GetSearchParametersInputBoundary getSearchParametersInteractor = new GetSearchParametersInteractor(
                dataAccessObject, outputBoundary);

        final GetSearchParametersController getSearchParametersController = new GetSearchParametersController(
                getSearchParametersInteractor);
        recipeSearchView.setGetSearchParametersController(getSearchParametersController);
        return this;
    }

    public ReciperSearchBuilder addPopularRecipesUseCase() {
        final PopularRecipesOutputBoundary outputBoundary = new PopularRecipesPresenter(popularRecipesViewModel,
                viewManagerModel);
        final PopularRecipesInputBoundary popularRecipesInteractor = new PopularRecipesInteractor(dataAccessObject,
                outputBoundary);

        final PopularRecipesController popularRecipesController =
                new PopularRecipesController(popularRecipesInteractor);
        popularRecipesView.setPopularRecipesController(popularRecipesController);
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


}
