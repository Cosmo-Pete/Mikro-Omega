package Windows;

import javax.swing.*;

public class MainFrame extends JFrame {
private MainPanel gamePanel;

public MainFrame(){
    Window();
    Game();
    }
    private void Window(){
    setTitle("Hlavní menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setSize(1280,720);

    setResizable(true);

    setLocationRelativeTo(null);
    }
    private void Game(){
    gamePanel = new MainPanel();
    add(gamePanel);

    pack();
    setVisible(true);
    }
}
