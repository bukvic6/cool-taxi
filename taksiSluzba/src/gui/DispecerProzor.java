package gui;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import cooltaxi.Preduzece;
import cooltaxi.io;
import korisnici.Korisnik;

import java.awt.*;

public class DispecerProzor extends JFrame {
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu dispecerMenu = new JMenu("Tabelarni prikaz");
    private JMenuItem korisnici = new JMenuItem("Korisnici");
    private JMenuItem automobili = new JMenuItem("Automobili");

    public DispecerProzor() {
        setTitle("Dispecerski meni");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu(){
        setJMenuBar(mainMenu);
        mainMenu.add(dispecerMenu);
        dispecerMenu.add(korisnici);
        dispecerMenu.add(automobili);
    }

    private void initActions(){
        korisnici.addActionListener(e -> {
            KorisniciTabela KTabela = new KorisniciTabela();
            KTabela.setVisible(true);
        });
        automobili.addActionListener(e -> {
            AutomobiliTabela ATabela = new AutomobiliTabela();
            ATabela.setVisible(true);
        });
    }
}

