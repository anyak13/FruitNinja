import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
    private Image splat;
    private static final int DISTANCE_BETWEEN_X = 60;
    private static final int X_START_X_VALUE = 400;
    private static final int X_Y_Value = 50;
    private static final int X_WIDTH = 60;
    private static final int X_HEIGHT = 65;


    public FruitNinjaView(FruitNinja game) {
        this.game = game;

        // Initialize background images
        startBG = new ImageIcon("Resources/startBG.png").getImage();
        instructions = new ImageIcon("Resources/instructionBG.png").getImage();
        gameOverBG = new ImageIcon("Resources/gameOverBG.png").getImage();
        readyBG = new ImageIcon("Resources/readyBG.png").getImage();
        goBG = new ImageIcon("Resources/goBG.png").getImage();
        playBG = new ImageIcon("Resources/playBG.png").getImage();
        x = new ImageIcon("Resources/X.png").getImage();
        redX = new ImageIcon("Resources/redX.png").getImage();
        bombBG = new ImageIcon("Resources/bombBG.jpg").getImage();
        splat = new ImageIcon("Resources/splat1.png").getImage();

        // Set up the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("FruitNinja");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        if (game.getState() == game.WELCOME) {
            drawWelcomeScreen(g);
        }
        else if (game.getState() == game.INSTRUCTIONS) {
            drawInstructionScreen(g);
        }
        else if (game.getState() == game.STARTING) {
            drawStartGameScreen(g);
        }
        else if (game.getState() == game.GAME) {
            drawGameScreen(g);
        }
        else if (game.getState() == game.GAME_OVER) {
            drawGameOverScreen(g);
        }
        else if (game.getState() == game.BOMB_CLICKED) {
            drawBombScreen(g);
        }
        showMistake(g);
    }

    public void drawWelcomeScreen(Graphics g) {
        g.drawImage(startBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }
    public void drawInstructionScreen(Graphics g) {
        g.drawImage(instructions, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }
    public void drawGameScreen(Graphics g) {
        g.drawImage(playBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        int numX = 3;
        for (int i = 0; i < numX; i ++) {
            g.drawImage(x, X_START_X_VALUE + (DISTANCE_BETWEEN_X * i), X_Y_Value, X_WIDTH, X_HEIGHT, this);
        }
        g.setFont(new Font("Serif", Font.BOLD, 40));
        g.setColor(Color.white);
        g.drawString("" + game.getScore(), 160, 95);
        drawFruits(g);
    }

    public void drawFruits(Graphics g) {
        game.getFruits().getFirst().draw(g);
    }

    public void drawGameOverScreen(Graphics g) {
        g.drawImage(gameOverBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.setFont(new Font("Serif", Font.BOLD, 50));
        g.setColor(Color.white);
        g.drawString("" + game.getScore(), 310, 460);
    }
    public void drawStartGameScreen(Graphics g) {
        g.drawImage(readyBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        ///wait(00);
        //Thread.sleep(100);
        g.drawImage(goBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        //wait(500);
        //drawGameScreen(g);
    }

    public void showMistake(Graphics g) {
        if (game.getNumMistakes() >= 1) {
            g.drawImage(redX, X_START_X_VALUE - 2, X_Y_Value + 1, X_WIDTH, X_HEIGHT,this);
        }
        if (game.getNumMistakes() >= 2) {
            g.drawImage(redX, X_START_X_VALUE + DISTANCE_BETWEEN_X, X_Y_Value, X_WIDTH, X_HEIGHT,this);
        }
        if (game.getNumMistakes() >= 3) {
            g.drawImage(redX, X_START_X_VALUE + (DISTANCE_BETWEEN_X * 2), X_Y_Value, X_WIDTH, X_HEIGHT,this);
        }
    }

    public void drawBombScreen(Graphics g) {
        g.drawImage(bombBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }

    public void drawSplat(Graphics g) {
        g.drawImage(splat, 50, 50, 50, 50, this);
    }
}
