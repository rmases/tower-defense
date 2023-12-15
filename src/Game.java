import processing.core.PApplet;

import java.util.ArrayList;


public class Game extends PApplet {
// TODO: declare game variables
    ArrayList<Tank> tankList = new ArrayList<>();
    ArrayList<Tower> towerList = new ArrayList<>();
    Background background;
    int timer, tankCount, tankAdjuster, spawnTime, firerate, timerTick;
    float tankSize = 20;
    double tankHealth = 5;
    float xSpeed = 1;
    int red = 0;
    int green = 255;
    //Exit exit;

    public void settings() {
        size(500, 500); // set the window size


    }


    public void setup() {
        tankAdjuster = 0;
        timer = 0;
        tankCount = -1;
        spawnTime = 300;
        firerate = 60;
        timerTick = 1;
        background = new Background();
        //exit = new Exit(500,250,50, 50);
        //tankList.add(new Tank(250,250, 100,1, 100, 255, 0));
    }
    public void draw() {
        background(255); // paint screen white
        background.draw(this);
        if (background.getHealth() > 0) {
            if (timer == 0) {
                tankCount++;
                //tankSize = tankAdjuster * 5 + 20;
                //tankHealth = 5 + tankAdjuster * 5;
                red = tankAdjuster * 20;
                green = 255 - (tankAdjuster * 20);
                if (background.getWave() == 5){
                    tankList.add(new Tank(-10, 250, tankSize, xSpeed*2, 0, 255, 255, background, tankHealth));
                } else if (background.getWave() == 10){
                    tankList.add(new Tank(-10, 250, (float) (tankSize * 1.5), xSpeed, 0, 0, 0, background, tankHealth * 2));
                } else {
                    //System.out.println(tankCount);
                    if (tankCount == 5) {
                        if (Math.random() > 0.5) {
                            tankList.add(new Tank(-10, 250, (float) (tankSize * 1.5), xSpeed, 0, 0, 0, background, tankHealth * 2));
                        } else {
                            tankList.add(new Tank(-10, 250, tankSize, xSpeed * 2, 0, 255, 255, background, tankHealth));
                        }
                    } else {
                        tankList.add(new Tank(-10, 250, tankSize, xSpeed, red, green, 0, background, tankHealth));
                    }
                }
            }
            //exit.draw(this);
            for (int i = 0; i < tankList.size(); i++) {
                Tank currentTank = tankList.get(i);
                currentTank.draw(this);
                if (currentTank.getPassed()) {
                    background.decreaseHealth((int) currentTank.getHealth());
                    tankList.remove(i);
                }
                if (currentTank.getHealth() <= 0) {
                    tankList.remove(i);
                }
            }
            for (int i = 0; i < towerList.size(); i++) {
                Tower currentTower = towerList.get(i);
                currentTower.draw(this, tankList);
                currentTower.drawBullets(this, tankList);
            }
            if (mousePressed) {
                if(!(mouseX < 175 && mouseX > 20 && mouseY > 420 && mouseY < 480)) {
                    if (checkPlacement()) {
                        fill(255, 255, 0);
                    } else {
                        fill(255, 0, 0);
                    }
                    rect(mouseX - 25, mouseY - 25, 50, 50);
                }

            }
            timer++;
            if (timer > spawnTime) {
                background.increaseWave();
                timer = 0;
            }
            if (tankCount >= 5) {
                if (Math.random() > 0.5 || spawnTime <= 10) {
                    tankAdjuster++;
                    if (Math.random() > 0.75){
                        xSpeed = (float) (xSpeed * 1.5);
                    } else {
                        if (tankSize < 60) {
                            tankSize += 10;
                        }
                        tankHealth = tankHealth * 1.5;
                    }
                } else {
                    spawnTime -= 10;
                }
                tankCount = 0;
            }

        }
    }
    public boolean checkPlacement(){
        if (mouseY < 325 && mouseY > 175) {return false;}
        if (mouseX < 0 || mouseX > 500) {return false;}
        if (mouseY < 0 || mouseY > 500) {return false;}
        if (mouseX < 200 && mouseY > 395) {return false;}

        if (!(background.getCash() >= 50)) {return false;}
        for (int i = 0; i < towerList.size(); i++) {
            Tower currentTower = towerList.get(i);
            if (mouseX > currentTower.getX()-currentTower.getSize()/2 && mouseX < currentTower.getX()+currentTower.getSize()*1.5){
                if (mouseY > currentTower.getY()-currentTower.getSize()/2 && mouseY < currentTower.getY()+currentTower.getSize()*1.5){
                    return false;
                }
            }
        }
        return true;
    }


    public void mouseReleased() {
            if (checkPlacement()) {
                background.decreaseCash(50);
                towerList.add(new Tower(mouseX - 25, mouseY - 25, 50, 2, 150, firerate, 50, timerTick,background));
            } else {
                if((mouseX < 175 && mouseX > 20 && mouseY > 420 && mouseY < 480)){
                    background.increaseFirerate(towerList);
                    timerTick = timerTick * 2;
                }
            }
    }

    public static void main (String[]args){
            PApplet.main("Game");
        }

}


