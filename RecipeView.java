import javax.swing.*;

public class RecipeView {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Recipes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        String[] recipes = {"Recipe A", "Recipe B", "Recipe C"};
        JList<String> recipeList = new JList<>(recipes);

        frame.add(new JScrollPane(recipeList));
        frame.setVisible(true);
    }
}
