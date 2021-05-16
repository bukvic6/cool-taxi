package gui;

import javax.swing.*;

public class GlavniProzor extends JFrame {
    public GlavniProzor() {
        setTitle("glavni prozor");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initMenu();
    }

    private void initMenu() {
        JMenuBar mainMenu = new JMenuBar();
        setJMenuBar(mainMenu);

        JMenu fileMenu = new JMenu("File");
        mainMenu.add(fileMenu);

    }
}
