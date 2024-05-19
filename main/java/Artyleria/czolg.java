
package Artyleria;

public class czolg {
    private boolean working;
    private int hp = 5;
    private double angle = 0; // K¹t obracania dzia³a

    public czolg() {
        this.working = true;
        this.hp = 5;
    }

    public void setAngle(double angle) {
        this.angle = angle;
        // Dodatkowa logika zwi¹zana z ustawianiem k¹ta, jeœli jest potrzebna
    }

    public int getHP() {
        return hp;
    }

    public void reduceHP() {
        if (working) {
            hp--;
            if (hp <= 0) {
                working = false;
            }
        }
    }

    public boolean isWorking() {
        return working;
    }

    public double getAngle() {
        return angle;
    }
}