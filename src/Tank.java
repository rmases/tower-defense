import processing.core.PApplet;

public class Tank {
    private int R,G,B;
    private double health, baseHealth, xSpeed;
    private float x,y,  size;
    private Background background;
    private boolean dead = false;
    private boolean passed = false;


    public Tank(float x, float y, float size, double xSpeed, int R, int G, int B, Background background, double health){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.R = R;
        this.G = G;
        this.B = B;
        this.size = size;
        this.background = background;
        this.health = health;
        this.baseHealth = health;
        //health = 10;
    }
    public void draw(PApplet window){
        window.fill(R,G,B);
        window.ellipse(x, y, size, size);
        move();
        atEdge();
        checkHealth();
        window.fill(255);
    }
    public void checkHealth(){
        if (health <= 0){
            dead = true;
        }
    }
    public void move(){
        x += xSpeed;
    }
    public void atEdge(){
        if (x > 500 + size/2.0) {
            passed = true;
        }
    }
    public void decreaseHealth(double damage){
        health -= damage;
        System.out.println(health);
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public double getHealth(){
        return health;
    }
    public double getBaseHealth(){
        return baseHealth;
    }
    public boolean getPassed(){
        return passed;
    }
}
