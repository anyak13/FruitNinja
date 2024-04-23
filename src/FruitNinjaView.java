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
    private Image BG;

    public FruitNinjaView(FruitNinja game) {
        this.game = game;
        fruitImages = new ArrayList<Fruit>();
        fruitImages.add(new Fruit("Watermelon", 0,0, new ImageIcon("Resources/watermelon.png").getImage()));
        fruitImages.add(new Fruit("Banana", 0,0, new ImageIcon("Resources/banana.png").getImage()));
        fruitImages.add(new Fruit("Pineapple", 0,0, new ImageIcon("Resources/pineapple.png").getImage()));
        fruitImages.add(new Fruit("Coconut", 0,0, new ImageIcon("Resources/coconut.png").getImage()));
        fruitImages.add(new Fruit("Red Apple", 0,0, new ImageIcon("Resources/red apple.png").getImage()));
        fruitImages.add(new Fruit("Green Apple", 0,0, new ImageIcon("Resources/green apple.png").getImage()));
        fruitImages.add(new Fruit("Lemon", 0,0, new ImageIcon("Resources/lemon.png").getImage()));
        fruitImages.add(new Fruit("Orange", 0,0, new ImageIcon("Resources/orange.png").getImage()));
        fruitImages.add(new Fruit("Lime", 0,0, new ImageIcon("Resources/lime.png").getImage()));
        fruitImages.add(new Fruit("Passion Fruit", 0,0, new ImageIcon("Resources/passion fruit.png").getImage()));
        fruitImages.add(new Fruit("Pear", 0,0, new ImageIcon("Resources/pear.png").getImage()));
        fruitImages.add(new Fruit("Strawberry", 0,0, new ImageIcon("Resources/strawberry.png").getImage()));
        fruitImages.add(new Fruit("Mango", 0,0, new ImageIcon("Resources/mango.png").getImage()));

        //bombImage = new ImageIcon("").getImage();

        // Initialze background images
        BG = new ImageIcon("Images/BG.png").getImage();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        // Set up the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("FruitNinja");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
//        g.setColor(Color.white);
//        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.drawImage(BG, 50, 50, WINDOW_WIDTH, WINDOW_HEIGHT, this);
        int x = 0;
        for (int i = 0; i < fruitImages.size(); i++)
        {
            g.drawImage(fruitImages.get(i).getFruitImage(), x, 0,this);
            x+=10;
        }
        //g.drawImage(fruitImages.get(0).getFruitImage(), 0, 0,this);
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
