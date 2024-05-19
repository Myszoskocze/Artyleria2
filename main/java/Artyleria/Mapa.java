
package Artyleria;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mapa{
    private List<Double> pointsX;
    private List<Double> pointsY;
    private int width; // Szerokoœæ terenu, na której ma byæ generowany
    private int maxHeight; // Maksymalna dopuszczalna wysokoœæ
    private int minHeight; // Minimalna dopuszczalna wysokoœæ
    private Random random;

    public Mapa(int width, int minHeight, int maxHeight) {
        this.width = width;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.pointsX = new ArrayList<>();
        this.pointsY = new ArrayList<>();
        this.random = new Random();
        generateTerrain();
    }

    private void generateTerrain() {
        double y = (maxHeight - minHeight) / 2.0 + minHeight;
        for (double x = 0; x <= width; x += 5) {
            double shift = random.nextDouble() * 20 - 10; // Random shift between -10 and +10
            y += shift;
            y = Math.max(y, minHeight);
            y = Math.min(y, maxHeight);
            pointsX.add(x);
            pointsY.add(y);
        }
    }

    public List<Double> getPointsX() {
        return pointsX;
    }

    public List<Double> getPointsY() {
        return pointsY;
    }

    public static void main(String[] args) {
        Mapa terrain = new Mapa(800, 100, 500);
        System.out.println("X coordinates: " + terrain.getPointsX());
        System.out.println("Y coordinates: " + terrain.getPointsY());
    }
}