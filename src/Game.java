import processing.core.PApplet;

import java.util.ArrayList;


public class Game extends PApplet {
// TODO: declare game variables
    ArrayList<Tank> tankList = new ArrayList<>();
    ArrayList<Tower> towerList = new ArrayList<>();
    Background background;
    int timer;
    //Exit exit;

    public void settings() {
        size(500, 500); // set the window size


    }


    public void setup() {
        timer = 0;
        background = new Background();
        //exit = new Exit(500,250,50, 50);
        tankList.add(new Tank(250,250, 50,2, 255, 0, 0));
        tankList.add(new Tank(250,250,20, 5, 100, 255, 0));
        tankList.add(new Tank(250,250, 100,1, 100, 255, 0));
    }
    public void draw() {
        background(255); // paint screen white
        background.draw(this);

        //exit.draw(this);
        for (int i = 0; i < tankList.size(); i++) {
            Tank currentTank = tankList.get(i);
            currentTank.draw(this);
        }
        for (int i = 0; i < towerList.size(); i++) {
            Tower currentTower = towerList.get(i);
            currentTower.draw(this);
        }
        if (mousePressed) {
            fill(255);
            rect(mouseX - 25, mouseY - 25, 50, 50);

        }
        timer++;
        if (timer>60){timer = 0;}
    }


    public void mouseReleased() {
        towerList.add(new Tower(mouseX-25,mouseY-25,50,10,0));
    }

    public static void main (String[]args){
            PApplet.main("Game");
        }


        }


