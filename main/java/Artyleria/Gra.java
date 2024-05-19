package Artyleria;

import javax.swing.*;
import java.awt.*;

public class Gra {
    private final int CANVAS_HEIGHT = 600;
    private final int CANVAS_WIDTH = 1200;
    private Menager gameManager;
    private JFrame canvas;
    private Mapa terrain; // U¿ywamy Mapa jako terrain

    public Gra() {
        canvas = new JFrame("Tanks!");
        canvas.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setLayout(null); // Ustawienie layout na null pozwala na rêczne pozycjonowanie komponentów

        terrain = new Mapa(CANVAS_WIDTH, 100, 300); // Przyk³adowe wartoœci
        gameManager = new Menager(canvas); // gameManager zarz¹dza teraz wszystkim

        openingScreen();
        canvas.setVisible(true);
    }

    private void openingScreen() {
        canvas.getContentPane().removeAll();
        canvas.repaint();

        // Tutaj mo¿na dodaæ przyciski i inne elementy UI
        JButton startButton = new JButton("Start Game!");
        startButton.setBounds(CANVAS_WIDTH / 2 - 100, CANVAS_HEIGHT / 2 - 25, 200, 50);
        startButton.addActionListener(e -> startGame());
        canvas.add(startButton);
        canvas.revalidate();
    }

    private void startGame() {
        canvas.getContentPane().removeAll();
        canvas.repaint();
        terrain.generateTerrain(); // Wywo³uje generowanie terenu
        setupGameControls();
        canvas.revalidate();
    }

    private void setupGameControls() {
        
        gameManager.setupListeners(); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Gra());
    }
}