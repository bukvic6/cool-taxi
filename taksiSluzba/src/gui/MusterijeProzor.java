package gui;

import korisnici.Korisnik;

import javax.swing.*;


public class MusterijeProzor extends JFrame {
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu korisniciMenu =new JMenu("Istorija voznje");


    public MusterijeProzor() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initMenu();
        initActions();
    }
    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(korisniciMenu);


    }

    private void initActions(){
        korisniciMenu.addActionListener(e -> {


        });

    }


}
