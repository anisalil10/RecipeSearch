package Main.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RecipeView extends JPanel implements ActionListener, PropertyChangeListener {

    private final JButton addToFavourites;

    public RecipeView() {

        final JPanel buttons = new JPanel();
        this.addToFavourites = new JButton("Add To Favourites");
        buttons.add(addToFavourites);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
