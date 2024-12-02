package Main.view;

import Main.interface_adapter.get_search_parameters.GetSearchParametersController;
import Main.interface_adapter.get_search_parameters.GetSearchParametersState;
import Main.interface_adapter.get_search_parameters.GetSearchParametersViewModel;
import Main.interface_adapter.login.LoginState;
import Main.interface_adapter.signup.SignupState;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class RecipeSearchView extends JPanel implements ActionListener, PropertyChangeListener {

    private static final String viewName = "Search Recipes";

    private final GetSearchParametersViewModel getSearchParametersViewModel;
    private final JTextField searchInputField = new JTextField(15);
    private final JTextField cuisineInputField = new JTextField(15);
    private final JTextField mealTypeInputField = new JTextField(15);
    private GetSearchParametersController getSearchParametersController;

    private final JButton search;

    public RecipeSearchView(GetSearchParametersViewModel getSearchParametersViewModel) {
        this.getSearchParametersViewModel = getSearchParametersViewModel;
        this.getSearchParametersViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(GetSearchParametersViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel searchInfo = new LabelTextPanel(
                new JLabel(GetSearchParametersViewModel.SEARCH), searchInputField);
        final LabelTextPanel cuisineInfo = new LabelTextPanel(
                new JLabel(GetSearchParametersViewModel.CUISINE_MENU), cuisineInputField);
        final LabelTextPanel mealTypeInfo = new LabelTextPanel(
                new JLabel(GetSearchParametersViewModel.MEAL_TYPE_MENU), mealTypeInputField);

        final JPanel buttons = new JPanel();

        search = new JButton(GetSearchParametersViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(search);

        search.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(search)) {
                            final GetSearchParametersState currentState = getSearchParametersViewModel.getState();

                            getSearchParametersController.execute(
                                    currentState.getQuery(),
                                    currentState.getCuisine(),
                                    currentState.getMealType(),
                                    currentState.getDiet()
                            );
                        }
                    }
                }
        );

        addSearchListener();
        addCuisineListener();
        addMealTypeListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(searchInfo);
        this.add(cuisineInfo);
        this.add(mealTypeInfo);
        this.add(buttons);


    }

    private void addSearchListener() {
        searchInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final GetSearchParametersState currentState = getSearchParametersViewModel.getState();
                currentState.setQuery(searchInputField.getText());
                getSearchParametersViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });


    }

    private void addCuisineListener() {
        cuisineInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final GetSearchParametersState currentState = getSearchParametersViewModel.getState();
                currentState.setCuisine(cuisineInputField.getText());
                getSearchParametersViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addMealTypeListener() {
        mealTypeInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final GetSearchParametersState currentState = getSearchParametersViewModel.getState();
                currentState.setMealType(mealTypeInputField.getText());
                getSearchParametersViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final GetSearchParametersState state = (GetSearchParametersState) evt.getNewValue();
        setFields(state);
        if (state.getQueryError() != null) {
            JOptionPane.showMessageDialog(this, state.getQueryError());
        }
    }

    private void setFields(GetSearchParametersState state) {
        searchInputField.setText(state.getQuery());
        cuisineInputField.setText(state.getCuisine());
        mealTypeInputField.setText(state.getMealType());
    }


    public static String getViewName() {return  viewName; }

    public void setGetSearchParametersController(GetSearchParametersController controller) {
        this.getSearchParametersController = controller;
    }
}


