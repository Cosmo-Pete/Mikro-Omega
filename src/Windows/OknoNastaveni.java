package Windows;

import javax.swing.*;
import java.awt.*;

public class OknoNastaveni extends JFrame {

    public OknoNastaveni() {
        setTitle("Nastavení");
        setSize(400, 300);
        setLocationRelativeTo(null); // vycentruje okno
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Nastavení hry"));

        JCheckBox hudba = new JCheckBox("Hudba");
        panel.add(hudba);

        JCheckBox zvuky = new JCheckBox("Zvuky");
        panel.add(zvuky);

        add(panel);
    }
}