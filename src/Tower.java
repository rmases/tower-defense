import processing.core.PApplet;

import java.util.ArrayList;

public class Tower {
    private int x, y, size, damage, range, firerate, level, timer, targetTank;
    private boolean placed;
    private Background background;
    private ArrayList<Bullet>bulletList;
    public Tower(int x, int y, int size, int damage, int range, int firerate,  int level, Background background){
        this.x = x;
        this.y = y;
        this.size = size;
        this.damage = damage;
        this.range = range;
        this.firerate = firerate;
        this.level = level;
        this.background = background;
        timer = 0;
        targetTank = -1;
        bulletList = new ArrayList<>();
        placed = false;
    }

    public void draw(PApplet window, ArrayList<Tank> tankList){
        window.fill(255,255,0);
        window.rect(x, y, size, size);
        checkForTank(tankList);
        firerate(tankList);
        //drawBullets(PApplet window);

    }
    public void setX(int x){
        this.x = x;

    }
    public void setY(int x){
        this.y = y;

    }
    public void firerate(ArrayList<Tank> tankList){
        timer++;
        if (timer >= firerate){
            timer = 0;
            shoot(tankList);

        }
    }
    public void drawBullets(PApplet window, ArrayList<Tank> tankList){
        for (int i = 0; i < bulletList.size();i++){
            Bullet curBullet = bulletList.get(i);
            curBullet.draw( window);
            if (curBullet.getTime() >= 10){
                try {
                    tankList.get(curBullet.getTargetTank()).decreaseHealth(damage);
                    if (tankList.get(curBullet.getTargetTank()).getHealth() >= damage) {
                        background.increaseCash(damage);
                    } else {
                        background.increaseCash((int) tankList.get(curBullet.getTargetTank()).getHealth()+1);
                    }
                    bulletList.remove(i);
                    targetTank = -1;
                }
                catch(Exception e) {
                    //  Block of code to handle errors
                }
            }
            }
        }

    public void shoot(ArrayList<Tank> tankList){
        if (targetTank != -1){
            try {
                System.out.println("shoot");
                double xDest = tankList.get(targetTank).getX();
                double yDest = tankList.get(targetTank).getY();
                double yDistance = y - yDest;
                double ySpeed =  yDistance / 10;
                double xDistance = x - xDest;
                double xSpeed =  xDistance / 10;

                bulletList.add(new Bullet(x,y,xDest,yDest,10, xSpeed, ySpeed, targetTank));
            }
            catch(Exception e) {
                //  Block of code to handle errors
            }

        }
    }

    public void checkForTank(ArrayList<Tank> tankList){
        double closestDistance = -1;
        int farthestTank = -1;
        float farthestTankX = -1;
        for (int i = 0; i < tankList.size(); i++){
            double xDistance = Math.abs(x - tankList.get(i).getX());
            double yDistance = Math.abs(y - tankList.get(i).getY());
            double hypotenuse = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
            if (hypotenuse < range) {
                if (farthestTankX < tankList.get(i).getX()) ;
                farthestTank = i;
                farthestTankX = tankList.get(i).getX();
                targetTank = farthestTank;
            }

        }
        //System.out.println(farthestTank);
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public float getSize(){
        return size;
    }

}
