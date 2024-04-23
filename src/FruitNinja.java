import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Anya Kothari
// 4/20/24
public class FruitNinja implements ActionListener {
    private ArrayList<Fruit> fruits;
    private boolean gameOver;
    private int numMistakes;
    private int score;
    private FruitNinjaView window;
    public FruitNinja() {
        this.window = new FruitNinjaView(this);
    }

    public void bombClicked() {

    }

    public void fruitClicked() {

    }

    public void checkGameOver() {

    }
    public void actionPerformed(ActionEvent e) {
    }
    public static void main(String[] args) {
        FruitNinja game = new FruitNinja();
    }
}
