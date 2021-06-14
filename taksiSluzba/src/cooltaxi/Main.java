package cooltaxi;

import automobili.Automobil;
import gui.Loginprozor;
import korisnici.Korisnik;
import porudzbina.Voznja;

import static cooltaxi.io.*;

public class Main {

    public static void main(String[] args) {
        Loginprozor lp = new Loginprozor();
        lp.setVisible(true);

        for (Automobil automobil: Preduzece.ucitaniAutomobili){
            if (!automobil.isObrisan())
                System.out.print(automobil);
        }

        for (Korisnik korisnik: Preduzece.ucitaniKorisnici){
            if (!korisnik.isObrisan())
                System.out.print(korisnik);
        }

        for (Voznja porudzbina: Preduzece.ucitaneVoznje){
            if (!porudzbina.isObrisan())
                System.out.print(porudzbina);
        }
        io.sacuvajKorisnike(korisniciTXT);
        io.sacuvajAutomobile(automobiliTXT);
        io.sacuvajVoznju(voznjaTXT);
        io.sacuvajPreduzece(preduzeceTXT);
    }
}
