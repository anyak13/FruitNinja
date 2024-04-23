import java.awt.*;

// Anya Kothari
// 4/20/24
public class Bomb extends Fruit {
    private boolean isClicked;
    public Bomb(String fruitType, int x, int flyHeight, Image fruitImage, boolean isClicked) {
        super(fruitType, x, flyHeight, fruitImage);
        this.isClicked = isClicked;
    }



}
