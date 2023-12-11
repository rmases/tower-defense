import processing.core.PApplet;

public class Tank {
    private int x, y, xSpeed, R,G,B, size;


    public Tank(int x, int y, int size, int xSpeed, int R, int G, int B){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.R = R;
        this.G = G;
        this.B = B;
        this.size = size;
        //health = 10;
    }
    public void draw(PApplet window){
        window.fill(R,G,B);
        window.ellipse(x, y, size, size);
        move();
        atEdge();
        window.fill(255);
    }
    public void move(){
        x += xSpeed;
    }
    public void atEdge(){
        if (x > 500 + size/2) {
            x = -size/2;
            //health--;
        }
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
}
