import processing.core.PApplet;

public class Exit {
    private int x, y, w, h;
    private int health;
    public Exit (int x, int y, int width, int height){
        this.x = x;
        this. y = y;
        this.w = width;
        this.h = height;
        health = 10;
    }
    public void draw(PApplet window){
        window.fill(255);
        window.text("Health:" + health, 200, 50);
    }
}
