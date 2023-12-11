import processing.core.PApplet;

public class Bullet {
    private double damage, xdest, ydest;
    private float x,y, size;
    private int targetTank;
    private double xspeed, yspeed;
    private int timer;


    public Bullet(float x, float y, double xdest, double ydest, float size, double xspeed, double yspeed, int targetTank) {
        this.x = x;
        this.y = y;
        this.xdest = xdest;
        this.ydest = ydest;
        this.size = size;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
        this.targetTank = targetTank;
        timer = 0;
    }
    public void draw(PApplet window){
        window.fill(255,255,255);
        window.rect(x, y, size, size);
        timer++;
        //xspeed = calcXSpeed();
        //yspeed = calcYSpeed();
        move();
    }

    public double calcXSpeed(){
        double xDistance = x - xdest;
        return xDistance / 60;
    }

    public double calcYSpeed(){
        double yDistance = y - ydest;
        return yDistance / 60;
    }



    public void move() {
        x -= xspeed;
        y -= yspeed;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public double getXDest(){
        return xdest;
    }
    public double getYDest(){
        return ydest;
    }
    public double getTime(){
        return timer;
    }
    public int getTargetTank(){
        return targetTank;
    }


//    public void collide(Tank tanklist) {
//        if (x < tank.x2 && x + tank.size/2 > tank.x1){
//            tank.takeDamage(damage);
//        }
//    }
}

