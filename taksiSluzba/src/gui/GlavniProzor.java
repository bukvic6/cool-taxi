package gui;

import cooltaxi.Preduzece;
import korisnici.Korisnik;

import javax.swing.*;


public class GlavniProzor extends JFrame {
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu korisniciMenu = new JMenu("Korisnici");
    private JMenuItem korisniciItem = new JMenuItem("korisnici");


    private Preduzece preduzece;

    public GlavniProzor(Korisnik ulogovani) {
        if (ulogovani.getUloga().equals("musterija")){
            setTitle("Dobrodosli " + ulogovani.getKorisnickoIme());
            MusterijeProzor musterijeprozor = new MusterijeProzor();
            musterijeprozor.setVisible(true);
        } else if(ulogovani.getUloga().equals("dispecer")){
            DispecerProzor dispecerprozor = new DispecerProzor();
            dispecerprozor.setVisible(true);
        }
    }
}
