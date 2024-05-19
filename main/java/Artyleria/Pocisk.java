
package Artyleria;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pocisk {
    public static final double GRAVITY = -9.8;
    public static final double RADIUS = 5;
    private double centerX;
    private double centerY;
    private double dx;
    private double dy;
    private double maxX;
    private double maxY;

    /**
     * Creates a cannonball object.
     * @param centerX Initial X position of the cannonball
     * @param centerY Initial Y position of the cannonball
     * @param initialSpeed Initial speed of the cannonball
     * @param initialAngle Initial angle in degrees of the cannonball's trajectory
     * @param maxX Maximum X boundary for the cannonball's movement
     * @param maxY Maximum Y boundary for the cannonball's movement
     */
    public Pocisk(double centerX, double centerY, double initialSpeed, double initialAngle, double maxX, double maxY) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.maxX = maxX;
        this.maxY = maxY;

        double angleInRadians = Math.toRadians(initialAngle);
        this.dx = initialSpeed * Math.cos(angleInRadians);
        this.dy = initialSpeed * Math.sin(angleInRadians);
    }

    /**
     * Updates the position of the cannonball based on the elapsed time (delta time).
     * @param dt Delta time in seconds
     */
    public void updatePosition(double dt) {
        centerX += dx * dt;
        centerY += dy * dt;
        dy += GRAVITY * dt;

        // Check for boundary collision and stop the movement if it goes outside
        if (centerX < 0 || centerX > maxX || centerY < 0 || centerY > maxY) {
            dx = 0;
            dy = 0;
        }
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return RADIUS;
    }
}