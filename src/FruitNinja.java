import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

// Anya Kothari
// 4/20/24
public class FruitNinja implements ActionListener {
    private ArrayList<Fruit> fruits;
    private boolean gameOver;
    private int numMistakes;
    private String score;
    private FruitNinjaView window;
    public static final int WELCOME = 0;
    public static final int INSTRUCTIONS = 1;
    public static final int STARTING = 2;
    public static final int GAME = 3;
    public static final int FRUIT_CLICKED = 4;
    public static final int GAME_OVER = 5;
    public static final int MADE_MISTAKE = 6;
    private static int state = GAME;
    public static final int DELAY_IN_MILLISEC = 20;
    public FruitNinja() {
        this.window = new FruitNinjaView(this);

        fruits = new ArrayList<Fruit>();
        fruits.add(new Fruit("Watermelon", new ImageIcon("Resources/watermelon.png").getImage()));
        fruits.add(new Fruit("Banana", new ImageIcon("Resources/banana.png").getImage()));
        fruits.add(new Fruit("Pineapple", new ImageIcon("Resources/pineapple.png").getImage()));
        fruits.add(new Fruit("Coconut", new ImageIcon("Resources/coconut.png").getImage()));
        fruits.add(new Fruit("Red Apple", new ImageIcon("Resources/red apple.png").getImage()));
        fruits.add(new Fruit("Green Apple", new ImageIcon("Resources/green apple.png").getImage()));
        fruits.add(new Fruit("Lemon", new ImageIcon("Resources/lemon.png").getImage()));
        fruits.add(new Fruit("Orange", new ImageIcon("Resources/orange.png").getImage()));
        fruits.add(new Fruit("Lime", new ImageIcon("Resources/lime.png").getImage()));
        fruits.add(new Fruit("Passion Fruit", new ImageIcon("Resources/passion fruit.png").getImage()));
        fruits.add(new Fruit("Pear", new ImageIcon("Resources/pear.png").getImage()));
        fruits.add(new Fruit("Strawberry", new ImageIcon("Resources/strawberry.png").getImage()));
        fruits.add(new Fruit("Mango", new ImageIcon("Resources/mango.png").getImage()));

        Timer clock = new Timer(DELAY_IN_MILLISEC, this);
        clock.start();
    }

    public int getState() {
        return state;
    }

    public void setState(int newState)
    {
        state = newState;
        System.out.println("changing state to : " + newState);
        // Repaint to update and sync the front-end
        //window.removeAll();
        window.repaint();
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getNumMistakes() {
        return numMistakes;
    }

    public void setNumMistakes(int numMistakes) {
        this.numMistakes = numMistakes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Fruit fruit : fruits) {
            fruit.move();
        }
        //fruits.get(0).move();
        window.repaint();
    }
    public static void main(String[] args) {
        FruitNinja game = new FruitNinja();
        game.playGame();
    }


    // Run repaint() to draw and run the front-end
    public void playGame()
    {
        window.repaint();
    }
}


//}
