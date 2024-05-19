
package Artyleria;

public class czolg {
    private boolean working;
    private int hp = 5;
    private double angle = 0; // K�t obracania dzia�a

    public czolg() {
        this.working = true;
        this.hp = 5;
    }

    public void setAngle(double angle) {
        this.angle = angle;
        // Dodatkowa logika zwi�zana z ustawianiem k�ta, je�li jest potrzebna
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