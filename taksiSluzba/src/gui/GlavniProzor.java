package gui;

import korisnici.Korisnik;

import javax.swing.*;


public class GlavniProzor extends JFrame {

    public GlavniProzor(Korisnik ulogovani) {
        if (ulogovani.getUloga().equals("musterija")) {
            MusterijeProzor musterijeprozor = new MusterijeProzor();
            musterijeprozor.setVisible(true);
        } else if (ulogovani.getUloga().equals("dispecer")) {
            DispecerProzor dispecerprozor = new DispecerProzor();
            dispecerprozor.setVisible(true);
        } else if (ulogovani.getUloga().equals("vozac")) {

        }else{

        }
    }
}
