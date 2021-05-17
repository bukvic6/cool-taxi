package cooltaxi;

import automobili.Automobil;
import korisnici.Korisnik;
import porudzbina.Voznja;

import gui.GlavniProzor;
import gui.Loginprozor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static cooltaxi.io.*;

public class Main {
    public static ArrayList<Korisnik> ucitaniKorisnici;
    public static ArrayList<Automobil> ucitaniAutomobili;
    public static ArrayList<Voznja> ucitaneVoznje;

    public static void main(String[] args) {
        Loginprozor lp = new Loginprozor();
        lp.setVisible(true);

        ucitaniKorisnici = io.ucitajKorisnike(korisniciTXT);
        for (Korisnik korisnici: ucitaniKorisnici){
            System.out.print(korisnici);
        }


        ucitaniAutomobili = io.ucitajAutomobil(automobiliTXT);
        for (Automobil automobil: ucitaniAutomobili){
            System.out.print(automobil);
        }


        ucitaneVoznje = io.ucitajVoznju(voznjaTXT);
        for (Voznja porudzbina: ucitaneVoznje){
            System.out.print(porudzbina);
        }

//        io.upisAutomobila(ucitaniAutomobili);
//        io.upisVoznje();

        Preduzece CoolTaxi = new Preduzece();
        CoolTaxi.setPIB("3846296229");
        CoolTaxi.setAdresa("Todora Toze Jovanovica 13");
        CoolTaxi.setNaziv("Cool Taxi");
        System.out.println(CoolTaxi);
        Scanner skener = new Scanner(System.in);

        System.out.print("Unesite korisnicko ime: ");
        String username = skener.nextLine();

        System.out.print("Unesite sifru: ");
        String password = skener.nextLine();

        skener.close();
        Korisnik ulogovaniKorisnik = (Korisnik) login(username, password);

        if (ulogovaniKorisnik != null) {
            System.out.println("Dobrodosli " + username);

        } else {
            System.out.println("Pogresni login podaci, pokusajte ponovo.");
        }

    }

    public static Korisnik pronadjiKorisnika(String korisnickoIme){
        for (Korisnik korisnik: ucitaniKorisnici){
            if (korisnik.getKorisnickoIme().equals(korisnickoIme)){
                return korisnik;
            }
        } return null;
    }

    public static ArrayList<Korisnik> login(String korisnickoIme, String lozinka) {
        ucitaniKorisnici = io.ucitajKorisnike(korisniciTXT);
        for(Korisnik korisnik : ucitaniKorisnici) {
            if(korisnik.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
                    korisnik.getLozinka().equals(lozinka)){
                return korisnik;
            }
        }
        return null;
    }
}
