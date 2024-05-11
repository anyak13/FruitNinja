import java.awt.*;

// Anya Kothari
// 4/20/24
public class Fruit {
    private FruitNinjaView window;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int flyHeight;
    private int fruitNum;
    public static final int FRUIT_WIDTH = 200;
    public static final int FRUIT_HEIGHT = 190;
    private Image fruitImage;
    private boolean isSliced;
    private boolean movingUp;
    private boolean movingRight;
    private static final int STARTING_Y = 800;
    private static final int DY = 6;
    private static final int DX = 1;
    private boolean isBomb;

    // Constructor that takes in the fruits image, it's number, and whether it's a bomb
    public Fruit(Image fruitImage, int fruitNum, boolean isBomb) {
        // Give the new fruit a random x value
        x = (int)(Math.random() * FruitNinjaView.WINDOW_WIDTH);
        // Give each fruit a different starting y value so they appear on the screen at different times
        y = STARTING_Y + (int)(Math.random() * 100);
        // Create a random max fly height for each fruit
        flyHeight = (int)((Math.random() * 200) + 100);
        this.fruitImage = fruitImage;
        this.dx = DX;
        this.dy = DY;
        movingUp = true;
        // Move right if the starting x coordinate is on the left half of the window
        if (x < (FruitNinjaView.WINDOW_WIDTH / 2)) {
            movingRight = true;
        }
        else {
            movingRight = false;
        }
        this.isBomb = isBomb;
        this.fruitNum = fruitNum;
    }

    // Getter and setter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public boolean getMovingUp() {
        return movingUp;
    }

    public int getFruitNum() {
        return fruitNum;
    }

    public void setFruitImage(Image fruitImage) {
        this.fruitImage = fruitImage;
    }

    public boolean isSliced() {
        return isSliced;
    }

    public void setSliced(boolean sliced) {
        isSliced = sliced;
        // once a fruit is sliced, it should go down and faster
        movingUp=false;
        dy *= 2;
    }
    public boolean isBomb() {
        return isBomb;
    }

    // Draw the fruit at its x and y location
    public void draw(Graphics g) {
        g.drawImage(fruitImage, x, y, FRUIT_WIDTH, FRUIT_HEIGHT, window);
    }

    // Method to get each fruit to move vertically and horizontally
    public void move() {
        // Decrease the y value of the fruit if it is moving up
        if (movingUp)
        {
            y -= dy;
            if (y <= flyHeight) {
                movingUp = false;
            }
        }
        // Increase y value when moving down
        else {
            y += dy;
        }
        // Increase x when going right and decrease x when going left
        if (movingRight) {
            x += dx;
        }
        else {
            x -= dx;
        }
    }
}
