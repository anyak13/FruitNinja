import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Anya Kothari
// 4/20/24
public class FruitNinjaView extends JFrame implements MouseListener, MouseMotionListener, ActionListener {
    private FruitNinja game;
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 800;
    private ArrayList<Fruit> fruitImages;
    private Image bombImage;
    private Image BG;
    public static final int WELCOME = 0;
    public static final int GAME = 1;
    public static final int FRUIT_CLICKED = 2;
    private static int state = WELCOME;
    private Image gameName;

    public FruitNinjaView(FruitNinja game) {
        this.game = game;
        fruitImages = new ArrayList<Fruit>();
        fruitImages.add(new Fruit("Watermelon", new ImageIcon("Resources/watermelon.png").getImage()));
        fruitImages.add(new Fruit("Banana", new ImageIcon("Resources/banana.png").getImage()));
        fruitImages.add(new Fruit("Pineapple", new ImageIcon("Resources/pineapple.png").getImage()));
        fruitImages.add(new Fruit("Coconut", new ImageIcon("Resources/coconut.png").getImage()));
        fruitImages.add(new Fruit("Red Apple", new ImageIcon("Resources/red apple.png").getImage()));
        fruitImages.add(new Fruit("Green Apple", new ImageIcon("Resources/green apple.png").getImage()));
        fruitImages.add(new Fruit("Lemon", new ImageIcon("Resources/lemon.png").getImage()));
        fruitImages.add(new Fruit("Orange", new ImageIcon("Resources/orange.png").getImage()));
        fruitImages.add(new Fruit("Lime", new ImageIcon("Resources/lime.png").getImage()));
        fruitImages.add(new Fruit("Passion Fruit", new ImageIcon("Resources/passion fruit.png").getImage()));
        fruitImages.add(new Fruit("Pear", new ImageIcon("Resources/pear.png").getImage()));
        fruitImages.add(new Fruit("Strawberry", new ImageIcon("Resources/strawberry.png").getImage()));
        fruitImages.add(new Fruit("Mango", new ImageIcon("Resources/mango.png").getImage()));

        //bombImage = new ImageIcon("").getImage();

        // Initialze background images
        BG = new ImageIcon("Resources/BG.jpg").getImage();
        gameName = new ImageIcon("Resources/name.png").getImage();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        // Set up the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("FruitNinja");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        if (state == WELCOME) {
            drawWelcomeScreen(g);
        }
        if (state == GAME) {
            drawGameScreen(g);
        }
        if (state == FRUIT_CLICKED) {
            removeFruit(g);
        }
    }

    public void drawWelcomeScreen(Graphics g) {
        g.drawImage(BG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.drawImage(gameName, 125, 75, 350, 215,this);
        g.setFont(new Font("Serif", Font.BOLD, 25));
        g.setColor(Color.black);
        g.drawString("Instructions", 50, 325);
    }

    public void drawGameScreen(Graphics g) {
        g.drawImage(BG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        g.setFont(new Font("Serif", Font.BOLD, 50));
        g.setColor(Color.white);
        g.drawString("Score", 50, 100);
        fruitImages.get(0).draw(g);

    }
    public void removeFruit(Graphics g) {
        g.drawImage(BG, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
    }
//    //@Override
//    public void mouseClicked(MouseEvent mouseEvent, Graphics g) {
//        state = FRUIT_CLICKED;
//        removeFruit(Graphics g);
//        repaint();
//    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (state == GAME) {
            state = FRUIT_CLICKED;
        }
        repaint();
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
