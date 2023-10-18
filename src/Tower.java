import processing.core.PApplet;

public class Tower {
    private int x, y, size, damage, level;
    private boolean placed;
    public Tower(int x, int y, int size, int damage, int level){
        this.x = x;
        this.y = y;
        this.size = size;
        this.damage = damage;
        this.level = level;
        placed = false;
    }

    public void draw(PApplet window){
        window.fill(255,0,255);
        window.rect(x, y, size, size);

    }
    public void setX(int x){
        this.x = x;

    }
    public void setY(int x){
        this.y = y;

    }

}
