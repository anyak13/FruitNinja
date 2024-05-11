import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

// Anya Kothari
// 4/20/24
public class FruitNinjaView extends JFrame {
    private FruitNinja game;
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 800;
    private Image startBG;
    private Image instructions;
    private Image gameOverBG;
    private Image readyBG;
    private Image goBG;
    private Image playBG;
    private Image x;
    private Image redX;
    private Image bombBG;
    private static final int DISTANCE_BETWEEN_X = 60;
    private static final int X_START_X_VALUE = 400;
    private static final int X_Y_Value = 50;
    private static final int X_WIDTH = 60;
    private static final int X_HEIGHT = 65;


    public FruitNinjaView(FruitNinja game) {
        this.game = game;

        // Initialize images
        startBG = new ImageIcon("Resources/startBG.png").getImage();
        instructions = new ImageIcon("Resources/instructionBG.png").getImage();
        gameOverBG = new ImageIcon("Resources/gameOverBG.png").getImage();
        readyBG = new ImageIcon("Resources/readyBG.png").getImage();
        goBG = new ImageIcon("Resources/goBG.png").getImage();
        playBG = new ImageIcon("Resources/playBG.png").getImage();
        x = new ImageIcon("Resources/X.png").getImage();
        redX = new ImageIcon("Resources/redX.png").getImage();
        bombBG = new ImageIcon("Resources/bombBG.jpg").getImage();

        // Set up the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("FruitNinja");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    // Method to control the screen based off of current state of game
    public void paint(Graphics g) {
        if (game.getState() == game.WELCOME) {
            drawWelcomeScreen(g);
        }
        else if (game.getState() == game.INSTRUCTIONS) {
            drawInstructionScreen(g);
        }
        else if (game.getState() == game.STARTING) {
            // Allow for pause
            try {
                drawStartGameScreen(g);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else if (game.getState() == game.GAME) {
            drawGameScreen(g);
        }
        else if (game.getState() == game.GAME_OVER) {
            drawGameOverScreen(g);
        }
        else if (game.getState() == game.BOMB_CLICKED) {
            // Allow for pause
            try {
                drawBombScreen(g);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Draw the welcome screen
    public void drawWelcomeScreen(Graphics g) {
        g.drawImage(startBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }

    // Draw the instructions
    public void drawInstructionScreen(Graphics g) {
        g.drawImage(instructions, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }
    public void drawGameScreen(Graphics g) {
        g.drawImage(playBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        showMistake(g);
        g.setFont(new Font("Serif", Font.BOLD, 40));
        g.setColor(Color.white);
        g.drawString("" + game.getScore(), 160, 95);
        // Draw the fruits
        drawFruits(g);
        // Draw rectangle to show the location of slice
        if (game.isSliceActive()) {
            g.fillRect(game.getSliceX() - 3, game.getSliceY() - 3, 6, 6);
        }
    }

    // Draw fruits in the fruit ArrayList
    public void drawFruits(Graphics g) {
        for (int i = 0; i < game.getFruits().size();i++) {
            game.getFruits().get(i).draw(g);
        }
    }

    // Draw the screen to show that the game is over
    public void drawGameOverScreen(Graphics g) {
        g.drawImage(gameOverBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.setFont(new Font("Serif", Font.BOLD, 50));
        g.setColor(Color.white);
        g.drawString("" + game.getScore(), 310, 460);
        showMistake(g);
    }

    // Draw ready and go images and put a pause in between
    public void drawStartGameScreen(Graphics g) throws InterruptedException {
        int pauseTime = 2;
        g.drawImage(readyBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        TimeUnit.SECONDS.sleep(pauseTime);
        g.drawImage(goBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        TimeUnit.SECONDS.sleep(pauseTime);
        game.setState(game.GAME);
    }

    // Draw the X's based on the number of mistakes
    public void showMistake(Graphics g) {
        int numX = 3;
        for (int i = 0; i < numX; i ++) {
            if (game.getNumMistakes() - 1 >= i) {
                g.drawImage(redX, X_START_X_VALUE + (DISTANCE_BETWEEN_X * i), X_Y_Value, X_WIDTH, X_HEIGHT, this);
            }
            else g.drawImage(x, X_START_X_VALUE + (DISTANCE_BETWEEN_X * i), X_Y_Value, X_WIDTH, X_HEIGHT, this);
        }
    }

    public void drawBombScreen(Graphics g) throws InterruptedException {
        // Create flash when bomb is clicked
        int flashTime = 400;
        g.drawImage(bombBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);;
        TimeUnit.MILLISECONDS.sleep(flashTime);
        drawGameScreen(g);
        TimeUnit.MILLISECONDS.sleep(flashTime / 2);
        g.drawImage(bombBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        TimeUnit.MILLISECONDS.sleep(flashTime);
        drawGameOverScreen(g);
    }
}
