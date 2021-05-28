package gui;

import cooltaxi.Main;
import cooltaxi.Preduzece;

import javax.swing.*;


public class MusterijeProzor extends JFrame {
    Preduzece CoolTaxi = new Preduzece();
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu korisniciMenu = new JMenu("Istorija voznje");
    private JLabel nazivSLuzbe = new JLabel(CoolTaxi.getNaziv());
    private JLabel PIB = new JLabel(CoolTaxi.getPIB());
    private JLabel adresaSluzbe = new JLabel(CoolTaxi.getAdresa());



    public MusterijeProzor() {
        setTitle("Dobrodosli u Cool Taxi");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initMenu();
        initActions();
    }
    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(korisniciMenu);
        add(nazivSLuzbe);
        add(PIB);
        add(adresaSluzbe);
    }

    private void initActions(){
        korisniciMenu.addActionListener(e -> {
        });
    }
}
