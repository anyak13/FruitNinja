import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

// Anya Kothari
// 4/20/24
public class FruitNinja implements ActionListener, MouseListener, MouseMotionListener {
    //private Fruit[] fruits;
    private ArrayList<Fruit> fruits;
    private Image[] fruitImages;
    private boolean gameOver;
    private int numMistakes;
    private int score;
    private FruitNinjaView window;
    public static final int WELCOME = 0;
    public static final int INSTRUCTIONS = 1;
    public static final int STARTING = 2;
    public static final int GAME = 3;
    public static final int FRUIT_CLICKED = 4;
    public static final int GAME_OVER = 5;
    public static final int MADE_MISTAKE = 6;
    private static int state = WELCOME;
    public static final int DELAY_IN_MILLISEC = 20;
    private static int FRUIT_TYPES = 13;
    public FruitNinja() {
        this.window = new FruitNinjaView(this);
        gameOver = false;
        score = 0;
        numMistakes = 0;

        //fruits = new Fruit[FRUIT_TYPES];
        fruits = new ArrayList<Fruit>();
        fruits.add(new Fruit(new ImageIcon("Resources/fruit1.png").getImage()));
//        for (int i = 0; i < FRUIT_TYPES; i++) {
//            fruits[i] = new Fruit(new ImageIcon("Resources/fruit" + (i + 1) + ".png").getImage());
//        }

        Timer clock = new Timer(DELAY_IN_MILLISEC, this);
        clock.start();

        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
    }

//    public void createFruits {
//        fruits = new Fruit[]
//    }
    public void fruitClicked(int mouseX, int mouseY) {
        // Update score if a fruit is clicked before going off-screen
        // game over if fruit is a bomb
        // remove fruit from screen
        //if (mouseX >= )
//        System.out.println("mouse click x position: " + mouseX);
//        System.out.println("current fruit x position: " + fruits.get(0).getX());
        //if (((mouseX - fruits[0].getX() < 100) && (mouseX - fruits[0].getX() >= 0)) || ((fruits[0].getX() - mouseX < 100) && (fruits[0].getX() - mouseX >= 0)))
        if (mouseX >= fruits.get(0).getX() && mouseX <= (fruits.get(0).getX() + fruits.get(0).getWidth()) && mouseY >= fruits.get(0).getY() && mouseY <= fruits.get(0).getY() + fruits.get(0).getHeight()) {
            updateScore();
            state = FRUIT_CLICKED;
            window.repaint();
        }
    }

    public void addRandomFruit() {
        fruits.add(new Fruit(new ImageIcon("Resources/fruit" + (int)(Math.random() * 13) + ".png").getImage()));
    }

    public int getState() {
        return state;
    }

    public void setState(int newState) {
        state = newState;
        //System.out.println("changing state to : " + newState);
        // Repaint to update and sync the front-end
        //window.removeAll();
        window.repaint();
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
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
//        for (Fruit fruit : fruits) {
//            fruit.move();
//        }
        //System.out.println("about to call move in actionPerformed");
        if (state == GAME)
        {
            for (Fruit fruit : fruits) {
                fruit.move();
                if (fruit.getY() > window.WINDOW_HEIGHT) {
                    numMistakes++;
                    state = MADE_MISTAKE;
                    fruits.remove(fruit);
                    addRandomFruit();
                }

            }
            window.repaint();
            checkGameOver();
            //fruits.get(0).move();
//            if (fruits.get(0).getY() > 800) {
//                numMistakes++;
//                state = MADE_MISTAKE;
//                checkGameOver();
//            }
//            window.repaint();
        }
        //fruits.get(0).move();

    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        if (gameOver) {
            state = GAME_OVER;
        }

    }

    public void updateScore() {
        score++;
        window.repaint();
    }

    public void checkGameOver() {
        if (numMistakes == 3) {
            setGameOver(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (state == WELCOME) {
            //System.out.println("in welcome state");
            setState(INSTRUCTIONS);
            //System.out.println(game.getState());
            //window.repaint();
            //System.out.println("hi");
        }
        else if (state == INSTRUCTIONS) {
            //System.out.println("in instructions state");
            setState(STARTING);
            //window.repaint();
        }
        else if (state == STARTING) {
            //System.out.println("in starting state");
            setState(GAME);
            //repaint();
        }
        else if (state == GAME) {
            //if(fruitImages.get(0).getX()) {
            //setState(FRUIT_CLICKED);
            int xClicked= e.getX();
            int yClicked= e.getY();
            System.out.println(xClicked);
            fruitClicked(xClicked, yClicked);
            //repaint();
        }
        window.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
    public static void main(String[] args) {
        FruitNinja game = new FruitNinja();
       // game.playGame();
    }


    // Run repaint() to draw and run the front-end
   /* public void playGame()
    {
        window.repaint();
    }*/
}


//}
