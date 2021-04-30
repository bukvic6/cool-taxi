package cooltaxi;


import java.io.*;
import java.util.Scanner;

import korisnici.Pol;


public class io {

    static String korisniciTXT = "taksiSluzba/src/txt/korisnici.txt";
    static String automobiliTXT = "taksiSluzba/src/txt/automobil.txt";
    static String voznjaTXT = "taksiSluzba/src/txt/voznja.txt";

    public static String ucitajKorisnike(String putanjaFajla) {
        File file = new File(putanjaFajla);
        String sadrzaj = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {
                sadrzaj += line+ "\n";

                String[] lineSplit = line.split("\\|");

                String uloga = lineSplit[0];
                String jmgb = lineSplit[1];
                String korisnickoIme = lineSplit[2];
                String sifra = lineSplit[3];
                String ime = lineSplit[4];
                String prezime = lineSplit[5];
                String adresa = lineSplit[6];
                String brojTelefona = lineSplit[7];

                System.out.println("Uspesno je ucitan korisnik: " + ime + " " + prezime);
            } reader.close();
        }catch(IOException e){
            System.out.println("Greska prilikom ucitavanja!");
        }
        return sadrzaj;
    }
    public static void registracija(String jmbg, String korisnickoIme, String sifra, String ime, String prezime, String adresa, Pol pol, String brojTelefona) {
        String ucitaniKorisnici = ucitajKorisnike(korisniciTXT);
        String noviKorisnik = "musterija" + "|" + jmbg + "|" + korisnickoIme + "|" + sifra + "|" + ime + "|" + prezime + "|" + adresa + "|" + pol + "|" + brojTelefona;
        try {
            File korisniciFile = new File(korisniciTXT);
            BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
            writer.write(ucitaniKorisnici + noviKorisnik);
            writer.close();
            System.out.println("Uspesno ste se registrovali!");
        }catch(IOException e) {
            System.out.println("Greska prilikom upisa u datoteku");
        }
    }
    public static void upisAutomobila() {
        String ucitaniAutomobili = ucitajAutomobil(automobiliTXT);
        String noviAutomobil = "2323"+ "|" + "opel"+ "|" + "astra"+ "|" + "2010"+ "|" +"ns232ms"+ "|" +"PUTNICKO_VOZILO";
        try {
            File autobomiliFile = new File(automobiliTXT);
            BufferedWriter writer = new BufferedWriter(new FileWriter(autobomiliFile));
            writer.write(ucitaniAutomobili + noviAutomobil);
            writer.close();
            System.out.println("Uspesno ste se dodali automobil!");
        }catch(IOException e) {
            System.out.println("Greska prilikom upisa u datoteku");
        }
    }
    public static void upisVoznje() {
        String ucitaneVoznje = ucitajVoznju(voznjaTXT);
        String novaVoznja = "100004"+ "|" + "2023-05-21T23:47:08.432"+ "|" + "Ulica br1 14"+ "|" + "Ulica broj 2"+ "|" +"KREIRANA"+ "|" +"15" + "|"+"2" + "|"+ "marko" + "|" +"milan";
        try {
            File voznjaFile = new File(voznjaTXT);
            BufferedWriter writer = new BufferedWriter(new FileWriter(voznjaFile));
            writer.write(ucitaneVoznje + novaVoznja);
            writer.close();
            System.out.println("Uspesno ste se dodali voznju!");
        }catch(IOException e) {
            System.out.println("Greska prilikom upisa u datoteku");
        }
    }



    public static String ucitajAutomobil(String putanjaFajla) {
        File file = new File(putanjaFajla);
        String sadrzaj = "";


        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                sadrzaj += line+ "\n";

                String[] lineSplit = line.split("\\|");

                String brojVozila = lineSplit[0];
                String model = lineSplit[1];
                String proizvodjac = lineSplit[2];
                String godinaProizvodnje = lineSplit[3];
                String registracija = lineSplit[4];
                String vrstaAutomobila = lineSplit[5];

                System.out.println("Uspesno su ucitani automobili: " + proizvodjac + " " + model + " " + registracija);
            } reader.close();
        }catch(IOException e){
            System.out.println("Greska prilikom ucitavanja!");

        }
        return sadrzaj;
    }
    public static String ucitajVoznju(String putanjaFajla) {
        File file = new File(putanjaFajla);
        String sadrzaj = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                sadrzaj += line+ "\n";

                String[] lineSplit = line.split("\\|");

                String id = lineSplit[0];
                String vremePorudzbine = lineSplit[1];
                String adresaPolaska = lineSplit[2];
                String adresaDestinacije = lineSplit[3];
                String status = lineSplit[4];
                String trajanjeVoznje = lineSplit[5];
                String brojKM = lineSplit[6];
                String musterija = lineSplit[7];
                String vozac = lineSplit[8];

                System.out.println("Uspesno su ucitani podaci o voznji: " + musterija + " je narucila voznju u ulici: " +  adresaPolaska );
            } reader.close();
        }catch(IOException e){
            System.out.println("Greska prilikom ucitavanja!");

        }
        return sadrzaj;
    }
}