package cooltaxi;

import automobili.Automobil;
import gui.Loginprozor;
import korisnici.Korisnik;
import korisnici.Musterije;
import porudzbina.Voznja;

import java.sql.SQLOutput;
import java.util.Scanner;

import static cooltaxi.io.*;

public class Main {

    public static void main(String[] args) {
        Preduzece CoolTaxi = new Preduzece();
        CoolTaxi.setPIB("3846296229");
        CoolTaxi.setAdresa("Todora Toze Jovanovica 13");
        CoolTaxi.setNaziv("Cool Taxi");
        System.out.println(CoolTaxi);

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

        Scanner skener = new Scanner(System.in);
        System.out.println("dodavanje korisnika:");
        System.out.print("Unesite jmbg: ");
        String jmbg = skener.nextLine();
        System.out.print("Unesite korisnicko ime: ");
        String korisnickoIme = skener.nextLine();
        System.out.print("Unesite lozinku: ");
        String lozinka = skener.nextLine();
        System.out.print("Unesite  ime: ");
        String ime = skener.nextLine();
        System.out.print("Unesite prezime: ");
        String prezime = skener.nextLine();
        System.out.print("Unesite adresu: ");
        String adresa = skener.nextLine();
        System.out.print("Unesite pol(MUSKI ili ZENSKI): ");
        String pol = skener.nextLine();
        System.out.print("Unesite broj telefona: ");
        String telefon = skener.nextLine();
        System.out.println(".......................................");

        Musterije noviKorisnik = new Musterije("false", "musterija", jmbg,korisnickoIme,lozinka,ime,prezime,adresa,pol,telefon);
        Preduzece.ucitaniKorisnici.add(noviKorisnik);

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
