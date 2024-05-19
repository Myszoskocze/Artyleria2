/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Artyleria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grawitacja extends JPanel {
    private double force;
    private final double SCALE = 3;
    private final int BAR_WIDTH = 400;
    private final int BAR_HEIGHT = 20;
    private int currentWidth = 0; // Current width of the force bar

    public Grawitacja() {
        this.setPreferredSize(new Dimension(BAR_WIDTH, BAR_HEIGHT + 20)); // +20 for some padding
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, BAR_WIDTH, BAR_HEIGHT); // Draw the background bar

        g.setColor(force > BAR_WIDTH / SCALE ? Color.RED : Color.BLUE); // Red if maxed out, blue otherwise
        g.fillRect(0, 0, currentWidth, BAR_HEIGHT); // Draw the current force level
    }

    public void setForce(double force) {
        this.force = force;
        currentWidth = (int) (SCALE * this.force);
        currentWidth = Math.min(currentWidth, BAR_WIDTH); // Ensure the bar does not exceed its boundary
        repaint();
    }

    public double getForce() {
        return force;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Force Meter Example");
        Grawitacja forceMeter = new Grawitacja();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(forceMeter);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Test updating the force meter
        Timer timer = new Timer(100, new ActionListener() {
            private double force = 0;
            private boolean increasing = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (increasing) {
                    force += 5;
                    if (force >= 100) increasing = false;
                } else {
                    force -= 5;
                    if (force <= 0) increasing = true;
                }
                forceMeter.setForce(force);
            }
        });
        timer.start();
    }
}