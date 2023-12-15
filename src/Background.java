import processing.core.PApplet;

import java.util.ArrayList;

public class Background {
    private int health = 20;
    private int cash = 1000;
    private int firerateMult = 1;
    private int firerateUpgradeCost = 150;

    private int wave = 0;
    public void draw(PApplet window) {
        window.fill(0,210,0);
        window.rect(0,0,500,200);
        window.rect(0,300,500,200);
        window.fill(255);
        window.text("Health:" + health, 10, 20);
        window.text("Cash:" + cash, 85, 20);
        window.text("Wave:" + wave, 450, 20);
        window.fill(255);
        window.rect(20,420,155,60);
        window.rect(390,420,90,60);
        window.fill(0);
        window.text("Double Firerate: $" + firerateUpgradeCost, 25, 455);
        window.text(firerateMult + "x Firerate", 400, 455);

        if (health <= 0){
            window.background(0);
            window.fill(255);
            window.text("YOU LOSE", 100, 50);
        }
    }
    public void decreaseHealth(int damage){
        health -= damage;
    }
    public void decreaseCash(int cost){
        cash -= cost;
    }
    public void increaseCash(int profit){
        cash += profit;
    }
    public void increaseWave(){
        wave++;
    }
    public void increaseFirerate(ArrayList<Tower> towerList){
        if (cash >= firerateUpgradeCost) {
            decreaseCash(firerateUpgradeCost);
            firerateMult = firerateMult * 2;
            firerateUpgradeCost = firerateUpgradeCost * 3;
        }
        for (int i = 0; i < towerList.size(); i++){
            Tower currTower = towerList.get(i);
            currTower.upgradeFirerate();
        }
    }
    public int getCash(){return cash;}

    public int getHealth(){return health;}
    public int getUpgradeCost(){return firerateUpgradeCost;}
    public int getWave(){return wave;}
}

