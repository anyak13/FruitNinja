// Anya Kothari
// 4/20/24
import java.awt.*;

public class Fruit {
    //private String fruitType;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int width;
    private int height;
    private int flyHeight;
    private int fruitNum;
    //private static final int startingY = -15;
    public static final int FRUIT_WIDTH = 200;
    public static final int FRUIT_HEIGHT = 190;
    private Image fruitImage;
    private boolean isSliced;
    private boolean movingUp;
    private boolean movingRight;
    private FruitNinjaView window;
    private static final int STARTING_Y = 800;
    private static final int DX_DY = 8;

    protected boolean isBomb;

//    public Fruit(Image fruitImage, int width, int height, int x, int y, int dx, int dy, int flyHeight) {
////        x = (int)(Math.random() * 600);
////        flyHeight = (int)(Math.random() * 800);
//////        this.dx = dx;
//////        this.dy = dy;
////        this.fruitType = fruitType;
////        this.fruitImage = fruitImage;
//        this.fruitType = fruitType;
//        this.fruitImage = fruitImage;
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        this.dx= dx;
//        this.dy = dy;
//        //this.width = width;
////        this.width = fruitImage.getWidth();
////        this.height = fruitImage.getHeight();
//        //this.height = height;
//        this.flyHeight = flyHeight;
//        this.movingUp = movingUp;
//    }

    public Fruit(Image fruitImage, int fruitNum) {
        x = (int)(Math.random() * 400) + 100;
        y = STARTING_Y;
        flyHeight = (int)((Math.random() * 200) + 100);
        this.fruitImage = fruitImage;
        this.width = FRUIT_WIDTH; //fruitImage.getWidth(null);
        this.height = FRUIT_HEIGHT; //fruitImage.getHeight(null);
        dx = DX_DY / 6;
        dy = DX_DY;
        movingUp = true;
        if (x < 300) movingRight = true;
        else movingRight = false;
        isBomb = false;
        this.fruitNum = fruitNum;
        //fruitNum = (int)((Math.random() * 13) + 1);
        //this(fruitType, fruitImage, (int)(Math.random() * 500), STARTING_Y, 6, 6, (int)((Math.random() * 200) + 100), true);
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
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public int getFruitNum() {
        return fruitNum;
    }

    public void setFruitNum(int fruitNum) {
        this.fruitNum = fruitNum;
    }

    private void setBombStatus(boolean isBomb)
    {
        this.isBomb = isBomb;
    }
    public FruitNinjaView getWindow() {
        return window;
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

    public void setSliced(boolean sliced)
    {
        isSliced = sliced;
        movingUp=false;
    }

    public void setWindow(FruitNinjaView window) {
        this.window = window;
    }

    public void draw(Graphics g) {
        g.drawImage(fruitImage, x, y, getWidth(), getHeight(), window);
    }

    public void move() {
        //x += dx;
        /*while (y != flyHeight) {
            y -= dy;
        }
        y += dy;*/
        //y -= dy;
        //System.out.println("flyHeight position is: " + flyHeight);
        //System.out.println("current y  position is: " + y);
        //System.out.println("current x position is: " + x);
        if (movingUp)
        {
            y -= dy;
            if (y <= flyHeight) {
                movingUp = false;
            }
        }
        else {
            y += dy;
        }
        if (movingRight)
        {
            x += dx;
            //if (y <= flyHeight) movingUp = false;
        }
        else {
            x -= dx;
        }
        //x-=dx;
        /*
        if (y >= flyHeight) {
            y -= dy;
        }
        else if (y < flyHeight) {
            y += dy;
        }
        */

        //else y += dy;
    }

    public Image getFruitImage() {
        return fruitImage;
    }

}
