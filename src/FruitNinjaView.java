import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

// Anya Kothari
// 4/20/24
public class FruitNinjaView extends JFrame implements MouseListener, MouseMotionListener {
    private FruitNinja game;
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 800;
    private ArrayList<Fruit> fruitImages;
    private Image bombImage;

    public FruitNinjaView(FruitNinja game) {
        this.game = game;
        ArrayList<Fruit> fruitImages = new ArrayList<Fruit>();
        fruitImages.add(new Fruit("Watermleon", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Banana", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Pineapple", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Coconut", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Red Apple", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Green Apple", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Lemon", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Orange", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Lime", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Passion Fruit", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Pear", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Strawberry", 0,0, new ImageIcon("").getImage()));
        fruitImages.add(new Fruit("Peach", 0,0, new ImageIcon("").getImage()));

        bombImage = new ImageIcon("").getImage();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        // Set up the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("BubblePop");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {

    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

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
