import processing.core.PApplet;

public class Background {
    private int health;
    public void draw(PApplet window) {
        window.fill(0,210,0);
        window.rect(0,0,500,200);
        window.rect(0,300,500,200);
        window.text("Health:" + health, 200, 50);
    }
    public void decreaseHealth(int damage){
        health--;
    }
}

