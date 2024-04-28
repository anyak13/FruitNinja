import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Anya Kothari
// 4/20/24
public class FruitNinjaView extends JFrame implements MouseListener, MouseMotionListener {
    private FruitNinja game;
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 800;
    private Image bombImage;
    private Image startBG;
    private Image instructions;
    private Image gameBG;
    private Image gameOverBG;
    private Image readyBG;
    private Image goBG;
    private Image playBG;
    private Image gameName;
    private Image x;
    private Image redX;
    private static final int DISTANCE_BETWEEN_X = 60;
    private static final int X_START_X_VALUE = 350;
    private static final int X_Y_Value = 50;

    public FruitNinjaView(FruitNinja game) {
        this.game = game;

        //bombImage = new ImageIcon("").getImage();

        // Initialze background images
        startBG = new ImageIcon("Resources/startBG.jpg").getImage();
        instructions = new ImageIcon("Resources/instructions.jpg").getImage();
        gameOverBG = new ImageIcon("Resources/gameOverBG.png").getImage();
        readyBG = new ImageIcon("Resources/ready.png").getImage();
        goBG = new ImageIcon("Resources/go.jpg").getImage();
        playBG = new ImageIcon("Resources/playBG.png").getImage();
        x = new ImageIcon("Resources/X.png").getImage();
        redX = new ImageIcon("Resources/redX.png").getImage();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        // Set up the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("FruitNinja");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        System.out.println("in paint with game state of: " + game.getState());
        if (game.getState() == game.WELCOME) {
            drawWelcomeScreen(g);
        }
        if (game.getState() == game.INSTRUCTIONS) {
            System.out.println("in paint for instrutions state");
            //drawInstructionScreen(g);
            g.drawImage(instructions, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        }
        if (game.getState() == game.STARTING) {
            drawStartGameScreen(g);
        }
        if (game.getState() == game.GAME) {
            drawGameScreen(g);
        }
        if (game.getState() == game.FRUIT_CLICKED) {
            removeFruit(g);
        }
        if (game.getState() == game.GAME_OVER) {
            drawGameOverScreen(g);
        }
        if (game.getState() == game.MADE_MISTAKE) {
            showMistake(g);
        }
    }

    public void drawWelcomeScreen(Graphics g) {
        g.drawImage(startBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }
    public void drawInstructionScreen(Graphics g) {
        g.drawImage(instructions, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }
    public void drawGameScreen(Graphics g) {
        g.drawImage(playBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        for (int i = 0; i < game.getFruits().size(); i++) {
            game.getFruits().get(i).draw(g);
        }
        int numX = 3;
        for (int i = 0; i < numX; i ++) {
            g.drawImage(x, X_START_X_VALUE + (DISTANCE_BETWEEN_X * (i + 1)), X_Y_Value, 60, 90,this);
        }
        g.setFont(new Font("Serif", Font.BOLD, 25));
        g.setColor(Color.white);
        //g.drawString(game.getScore(), 50, 50);
    }
    public void removeFruit(Graphics g) {
        g.drawImage(startBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }

    public void drawGameOverScreen(Graphics g) {
        g.drawImage(gameOverBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
//        g.setFont(new Font("Serif", Font.BOLD, 25));
//        g.setColor(Color.white);
        g.drawString(game.getScore(), 50, 50);
    }
    public void drawStartGameScreen(Graphics g) {
        g.drawImage(readyBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        //wait(100);
        g.drawImage(goBG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        //wait(100);
        drawGameScreen(g);
    }

    public void showMistake(Graphics g) {
        if (game.getNumMistakes() == 1) {
            g.drawImage(redX, X_START_X_VALUE, X_Y_Value, 60, 90,this);
        }
        if (game.getNumMistakes() == 2) {
            g.drawImage(redX, X_START_X_VALUE + DISTANCE_BETWEEN_X, X_Y_Value, 60, 90,this);
        }
        g.drawImage(redX, X_START_X_VALUE + (DISTANCE_BETWEEN_X * 2), X_Y_Value, 60, 90,this);
        drawGameOverScreen(g);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (game.getState() == game.WELCOME) {
            System.out.println("in welcome state");
            game.setState(game.INSTRUCTIONS);
            System.out.println(game.getState());
            repaint();
            //System.out.println("hi");
        }
        if (game.getState() == game.INSTRUCTIONS) {
            System.out.println("in instructions state");
            game.setState(game.STARTING);
            repaint();
        }
        if (game.getState() == game.STARTING) {
            System.out.println("in starting state");
            game.setState(game.GAME);
            //repaint();
        }
        if (game.getState() == game.GAME) {
            //if(fruitImages.get(0).getX()) {
            game.setState(game.FRUIT_CLICKED);
            //repaint();
        }
        this.repaint();
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
}
