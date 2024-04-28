// Anya Kothari
// 4/20/24
import java.awt.*;

public class Fruit {
    private String fruitType;
    private int x, y, dx, dy, flyHeight;
    //private static final int startingY = -15;
    private static final int FRUIT_WIDTH = 175;
    private static final int FRUIT_LENGTH = 175;
    private Image fruitImage;
    private boolean isSliced;
    private boolean movingUp;
    private FruitNinjaView window;
    private static final int STARTING_Y = 800;
    public Fruit(String fruitType, Image fruitImage, int x, int y, int dx, int dy, int flyHeight, boolean movingUp) {
//        x = (int)(Math.random() * 600);
//        flyHeight = (int)(Math.random() * 800);
////        this.dx = dx;
////        this.dy = dy;
//        this.fruitType = fruitType;
//        this.fruitImage = fruitImage;
        this.fruitType = fruitType;
        this.fruitImage = fruitImage;
        this.x = x;
        this.y = y;
        this.dx= dx;
        this.dy = dy;
        this.flyHeight = flyHeight;
        this.movingUp = movingUp;
    }

    public Fruit(String fruitType, Image fruitImage) {
        this(fruitType, fruitImage, (int)(Math.random() * 500), STARTING_Y, 6, 6, (int)((Math.random() * 200) + 100), true);
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFlyHeight() {
        return flyHeight;
    }

    public boolean isSliced() {
        return isSliced;
    }

    public FruitNinjaView getWindow() {
        return window;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setFlyHeight(int flyHeight) {
        this.flyHeight = flyHeight;
    }

    public void setFruitImage(Image fruitImage) {
        this.fruitImage = fruitImage;
    }

    public void setSliced(boolean sliced) {
        isSliced = sliced;
    }

    public void setWindow(FruitNinjaView window) {
        this.window = window;
    }

    public void draw(Graphics g) {
        g.drawImage(fruitImage, x, y, FRUIT_WIDTH, FRUIT_LENGTH, window);
    }

    public void move() {
        //x += dx;
        /*while (y != flyHeight) {
            y -= dy;
        }
        y += dy;*/
        if (y >= flyHeight) {
            y -= dy;
        }
        else y += dy;
    }

    public Image getFruitImage() {
        return fruitImage;
    }
}
