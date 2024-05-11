import javax.swing.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

// Anya Kothari
// 4/20/24
public class FruitNinja implements ActionListener, MouseListener, MouseMotionListener {
    private ArrayList<Fruit> fruits;
    private FruitNinjaView window;
    private boolean gameOver;
    private int numMistakes;
    private int score;
    private boolean sliceActive;
    private int sliceX;
    private int sliceY;
    public static final int WELCOME = 0;
    public static final int INSTRUCTIONS = 1;
    public static final int STARTING = 2;
    public static final int GAME = 3;
    public static final int GAME_OVER = 4;
    public static final int BOMB_CLICKED = 5;
    private static final int FRUIT_TYPES = 10;
    private static final int MAX_FRUIT_IN_CYCLE = 6;
    private static final double BOMB_PROBABILITY = 0.2;
    private static int state = WELCOME;
    public static final int DELAY_IN_MILLISEC = 20;
    public FruitNinja() {
        // Creates a new window
        this.window = new FruitNinjaView(this);
        gameOver = false;
        score = 0;
        numMistakes = 0;
        sliceActive = false;
        fruits = new ArrayList<Fruit>();
        //
        reloadFruits(false);

        // Create clock for ActionPerformed method
        Timer clock = new Timer(DELAY_IN_MILLISEC, this);
        clock.start();

        // Setup Mouse and Mouse Motion Listener
        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
    }

    // Getters and setters
    public int getState() {
        return state;
    }

    public void setState(int newState) {
        state = newState;
        window.repaint();
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public int getScore() {
        return score;
    }

    public int getNumMistakes() {
        return numMistakes;
    }
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        if (gameOver) {
            state = GAME_OVER;
        }
    }

    public boolean isSliceActive() {
        return sliceActive;
    }

    public int getSliceX() {
        return sliceX;
    }

    public int getSliceY() {
        return sliceY;
    }


    private void reloadFruits(Boolean withBombs) {
        int numFruitsInCycle = (int)((Math.random() * MAX_FRUIT_IN_CYCLE) + 1);
        for (int i = 0; i < numFruitsInCycle; i++) {
            if (withBombs) {
                addObject();
            }
            else addRandomFruit();
        }
    }

    // Check the click's location
    public void checkClick(int mouseX, int mouseY) {
      for (int i = fruits.size() - 1; i >= 0; i--) {
          Fruit currentFruit = fruits.get(i);
          // Check if the mouse click happened within the area of a fruit object
          if (mouseX >= currentFruit.getX() && mouseX <= (currentFruit.getX() + Fruit.FRUIT_WIDTH) && mouseY >= currentFruit.getY() && mouseY <= currentFruit.getY() + Fruit.FRUIT_HEIGHT) {
              // Check if the fruit object was not a bomb
              if (!(currentFruit.isBomb())) {
                  // Check to see if the fruit has already been sliced
                  if (!currentFruit.isSliced()) {
                      // Slice fruit, add score, and update the image for sliced effect
                      updateScore();
                      currentFruit.setFruitImage(new ImageIcon("Resources/fruit" + currentFruit.getFruitNum() + "Sliced.png").getImage());
                      currentFruit.setSliced(true);
                  }
              }
              // Change state when bomb is clicked
              else {
                  state = BOMB_CLICKED;
                  numMistakes = 0;
              }
          }
          window.repaint();
      }
    }

    // Create a new fruit to add to the ArrayList
    public void addRandomFruit() {
        int randomFruitNum = (int)((Math.random() * FRUIT_TYPES) + 1);
        fruits.add(new Fruit(new ImageIcon("Resources/fruit" + randomFruitNum + ".png").getImage(), randomFruitNum, false));
    }

    // Create a bomb to add to the ArrayList
    public void addBomb() {
        fruits.add(new Fruit(new ImageIcon("Resources/bomb.png").getImage(), 0, true));
    }

    // Add either a bomb or fruit to the ArrayList
    public void addObject() {
        int bombThreshold = (int)(BOMB_PROBABILITY * 100);
        int randomInt = (int)(Math.random() * 100);
        // Add a bomb 20% of the time
        if (randomInt >= bombThreshold) {
            addRandomFruit();
        }
        else {
            addBomb();
        }
    }

    // Moves each fruit by updating x and y values every 20 milliseconds
    @Override
    public void actionPerformed(ActionEvent e) {
        if (state == GAME) {
            for (int i = fruits.size() - 1; i >= 0; i--) {
                Fruit fruit = fruits.get(i);
                // Call move for each fruit in the ArrayList
                fruit.move();
                // If the fruit has fallen back down without being sliced and is not a bomb
                if ((fruit.getY() > window.WINDOW_HEIGHT) && (!fruit.getMovingUp())) {
                    if (!(fruit.isBomb() || fruit.isSliced())) {
                        // Increase num of mistakes
                        numMistakes++;
                    }
                    fruits.remove(fruit);
                    // Add more fruits to ArrayList
                    if (fruits.isEmpty()) {
                        reloadFruits(true);
                    }
                }
            }
        }
        checkGameOver();
        window.repaint();
    }

    public void updateScore() {
        score++;
        window.repaint();
    }

    // Set the state to gameOver is the user has 3 mistakes or a bomb was clicked
    public void checkGameOver() {
        if (numMistakes == 3) {
            setGameOver(true);
        }
        if (state == BOMB_CLICKED) {
            setGameOver(true);
        }
    }

    // Change screens on click based on the current state
    @Override
    public void mouseClicked(MouseEvent e) {
        if (state == WELCOME) {
            setState(INSTRUCTIONS);
        }
        else if (state == INSTRUCTIONS) {
            setState(STARTING);
        }
        window.repaint();
    }
    // Drag fruits to slice them
    @Override
    public void mouseDragged(MouseEvent e) {
        if (state == GAME) {
            int xClicked = e.getX();
            int yClicked = e.getY();
            // Check the click by taking in x and y coordinates of drag
            checkClick(xClicked, yClicked);
            sliceActive = true;
            sliceX = xClicked;
            sliceY = yClicked;
            window.repaint();
        }
    }

    // Unused mouse methods
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        sliceActive = false;
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
    public static void main(String[] args) {
        FruitNinja game = new FruitNinja();
    }
}
