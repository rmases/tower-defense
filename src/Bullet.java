public class Bullet {
    private int x, y, damage, xdest, ydest, size;
    int xspeed, yspeed;


    public Bullet(int x, int y, int xdest, int ydest) {
        this.x = x;
        this.y = y;
        this.xdest = xdest;
        this.ydest = ydest;


    }


    public void move() {
        x += xspeed;
        y += yspeed;
    }


//    public void collide(Tank tanklist) {
//        if (x < tank.x2 && x + tank.size/2 > tank.x1){
//            tank.takeDamage(damage);
//        }
//    }
}

