package cooltaxi;

import automobili.Automobil;
import gui.Loginprozor;
import korisnici.Korisnik;
import porudzbina.Voznja;

import java.util.Scanner;

import static cooltaxi.io.*;

public class Main {

    public static void main(String[] args) {

        Loginprozor lp = new Loginprozor();
        lp.setVisible(true);

        for (Automobil automobil: Preduzece.ucitaniAutomobili){
            if (!automobil.isObrisan())
                System.out.print(automobil);
        }

        for (Korisnik korisnici: Preduzece.ucitaniKorisnici){
            if (!korisnici.isObrisan())
            System.out.print(korisnici);
        }

        for (Voznja porudzbina: Preduzece.ucitaneVoznje){
            if (!porudzbina.isObrisan())
                System.out.print(porudzbina);
        }

        Preduzece CoolTaxi = new Preduzece();
        CoolTaxi.setPIB("3846296229");
        CoolTaxi.setAdresa("Todora Toze Jovanovica 13");
        CoolTaxi.setNaziv("Cool Taxi");
        System.out.println(CoolTaxi);
        Scanner skener = new Scanner(System.in);
        System.out.print("Unesite korisnicko ime osobe koju zelite da obrisete (jovanaj): ");
        String korisnik = skener.nextLine();

        System.out.println(Preduzece.obrisiKorisnika(korisnik));
        io.sacuvajKorisnike(korisniciTXT);

//        System.out.print("Unesite broj vozila koji zelite da obrisete: ");
//        String automobil = skener.nextLine();
//        System.out.println(obrisiAutomobil(automobil));
        io.sacuvajAutomobile(automobiliTXT);
        io.sacuvajVoznju(voznjaTXT);

    }
}
