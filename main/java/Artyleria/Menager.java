
package Artyleria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Menager {
    private JFrame canvas;
    private List<JPanel> tanks; // Swing components to represent tanks
    private List<JPanel> cannons; // Swing components to represent cannons
    private JPanel redTank;
    private JPanel blueTank;
    private JPanel redCannon;
    private JPanel blueCannon;
    private JLabel redHPBar, blueHPBar;
    private int force;
    
    public Menager(JFrame canvas) {
        this.canvas = canvas;
        tanks = new ArrayList<>();
        cannons = new ArrayList<>();
        
        initializeComponents();
        setupUI();
        setupListeners();
    }

    private void initializeComponents() {
        redTank = new JPanel();
        redTank.setBackground(Color.RED);
        redTank.setBounds(100, 100, 50, 50); // Example dimensions and position

        blueTank = new JPanel();
        blueTank.setBackground(Color.BLUE);
        blueTank.setBounds(300, 100, 50, 50); // Example dimensions and position

        redCannon = new JPanel();
        redCannon.setBackground(Color.DARK_GRAY);
        redCannon.setBounds(110, 90, 30, 10); // Example dimensions and position

        blueCannon = new JPanel();
        blueCannon.setBackground(Color.DARK_GRAY);
        blueCannon.setBounds(310, 90, 30, 10); // Example dimensions and position

        redHPBar = new JLabel("HP: 5", JLabel.CENTER);
        blueHPBar = new JLabel("HP: 5", JLabel.CENTER);

        tanks.add(redTank);
        tanks.add(blueTank);
        cannons.add(redCannon);
        cannons.add(blueCannon);
    }

    private void setupUI() {
        canvas.setLayout(null);
        canvas.add(redTank);
        canvas.add(blueTank);
        canvas.add(redCannon);
        canvas.add(blueCannon);
        canvas.add(redHPBar);
        canvas.add(blueHPBar);
        canvas.setSize(600, 400);
        canvas.setVisible(true);
    }

    private void setupListeners() {
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    // Move red tank left
                    Point location = redTank.getLocation();
                    redTank.setLocation(location.x - 5, location.y);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    // Move blue tank right
                    Point location = blueTank.getLocation();
                    blueTank.setLocation(location.x + 5, location.y);
                }
            }
        });
    }
}
