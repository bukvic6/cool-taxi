package gui;


import javax.swing.*;
import cooltaxi.Preduzece;

public class KorisniciProzor extends JFrame {
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu artikliMenu = new JMenu("lista");
    private JMenu korisniciMenu = new JMenu("Korisnici");

    private JMenuItem prodavciItem = new JMenuItem("Korisnici");

    public KorisniciProzor() {

        setTitle("Prodavac");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(artikliMenu);
        mainMenu.add(korisniciMenu);
        korisniciMenu.add(prodavciItem);
    }

    private void initActions() {
    }
}

