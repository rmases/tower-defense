import processing.core.PApplet;

public class Background {
    private int health = 20;
    private int cash = 50;

    private int wave = 0;
    public void draw(PApplet window) {
        window.fill(0,210,0);
        window.rect(0,0,500,200);
        window.rect(0,300,500,200);
        window.fill(255);
        window.text("Health:" + health, 10, 20);
        window.text("Cash:" + cash, 85, 20);
        window.text("Wave:" + wave, 450, 20);
        if (health <= 0){
            window.background(0);
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

    public int getCash(){return cash;}

    public int getHealth(){return health;}
    public int getWave(){return wave;}



}

