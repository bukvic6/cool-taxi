package cooltaxi;

import automobili.Automobil;
import korisnici.Korisnik;
import porudzbina.Voznja;
import gui.Loginprozor;
import java.util.ArrayList;
import java.util.Scanner;

import static cooltaxi.Preduzece.obrisiAutomobil;
import static cooltaxi.Preduzece.obrisiKorisnika;
import static cooltaxi.io.*;

public class Main {

    public static void main(String[] args) {
//        Korisnik ulogovani = new Korisnik();


        Loginprozor lp = new Loginprozor();
        lp.setVisible(true);

        for (Korisnik korisnici: Preduzece.ucitaniKorisnici){
            if (!korisnici.isObrisan())
            System.out.print(korisnici);
        }

        for (Automobil automobil: Preduzece.ucitaniAutomobili){
            System.out.print(automobil);
        }

        for (Voznja porudzbina: Preduzece.ucitaneVoznje){
            System.out.print(porudzbina);
        }

        Preduzece CoolTaxi = new Preduzece();
        CoolTaxi.setPIB("3846296229");
        CoolTaxi.setAdresa("Todora Toze Jovanovica 13");
        CoolTaxi.setNaziv("Cool Taxi");
        System.out.println(CoolTaxi);
        Scanner skener = new Scanner(System.in);


        System.out.print("Unesite korisnicko ime osobe koju zelite da obrisete: ");
        String korisnik = skener.nextLine();

        System.out.println(obrisiKorisnika(korisnik));
        io.sacuvajKorisnike(korisniciTXT);

        System.out.print("Unesite broj vozila koji zelite da obrisete: ");
        String automobil = skener.nextLine();
        System.out.println(obrisiAutomobil(automobil));
        io.sacuvajAutomobile(automobiliTXT);

//        System.out.println("Login");
//        System.out.print("Unesite korisnicko ime: ");
//        String username = skener.nextLine();
//
//        System.out.print("Unesite sifru: ");
//        String password = skener.nextLine();
//
//        skener.close();
//        Korisnik ulogovaniKorisnik = (Korisnik) Preduzece.login(username, password);
//
//        if (ulogovaniKorisnik != null) {
//            System.out.println("Dobrodosli " + username);
//
//        } else {
//            System.out.println("Pogresni login podaci, pokusajte ponovo.");
//        }
//
    }
}
