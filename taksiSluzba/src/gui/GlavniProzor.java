package gui;

import cooltaxi.Preduzece;
import korisnici.Korisnik;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GlavniProzor extends JFrame {
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu korisniciMenu =new JMenu("Korisnici");
    private JMenuItem korisniciItem = new JMenuItem("korisnici");


    private Preduzece preduzece;

    public GlavniProzor(Preduzece preduzece) {
        this.preduzece = preduzece;
        setTitle("Meni");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initMenu();
        initActions();
    }

    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(korisniciMenu);
        korisniciMenu.add(korisniciItem);

    }

    private void initActions(){
        korisniciItem.addActionListener(e -> {
            KorisniciProzor pp = new KorisniciProzor();
            pp.setVisible(true);

        });

    }
}
