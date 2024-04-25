// Anya Kothari
// 4/20/24
import java.awt.*;

public class Fruit {
    private String fruitType;
    private int x, flyHeight;
    private static final int y = -15;
    private static final int FRUIT_WIDTH = 175;
    private static final int FRUIT_LENGTH = 175;
    private Image fruitImage;
    private boolean isSliced;
    private FruitNinjaView window;
    public Fruit(String fruitType, Image fruitImage) {
        x = (int)(Math.random() * 600);
        flyHeight = (int)(Math.random() * 800);
        this.fruitType = fruitType;
        this.fruitImage = fruitImage;
    }
    public void draw(Graphics g) {
        g.drawImage(fruitImage, x, y, FRUIT_WIDTH, FRUIT_LENGTH, window);
    }

    public void move() {

    }

    public Image getFruitImage() {
        return fruitImage;
    }
}
