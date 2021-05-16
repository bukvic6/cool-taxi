package cooltaxi;


import java.io.*;
import java.util.ArrayList;

import automobili.Automobil;
import korisnici.*;
import porudzbina.Voznja;


public class io {

    static String korisniciTXT = "taksiSluzba/src/txt/korisnici.txt";
    static String automobiliTXT = "taksiSluzba/src/txt/automobil.txt";
    static String voznjaTXT = "taksiSluzba/src/txt/voznja.txt";

    public static ArrayList<Korisnik> ucitajKorisnike(String putanjaFajla) {
        ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
        File file = new File(putanjaFajla);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");

                String uloga = lineSplit[0];
                String jmbg = lineSplit[1];
                String korisnickoIme = lineSplit[2];
                String sifra = lineSplit[3];
                String ime = lineSplit[4];
                String prezime = lineSplit[5];
                String adresa = lineSplit[6];
                String pol = lineSplit[7];
                String brojTelefona = lineSplit[8];

                if (uloga.equals("musterija")){
                    Musterije korisnik = new Musterije(jmbg, korisnickoIme, sifra, ime, prezime, adresa, pol, brojTelefona);
                    korisnici.add(korisnik);
                } else if (uloga.equals("vozac")){
                    String clanskaKarta = lineSplit[9];
                    String plata = lineSplit[10];
                    Vozaci vozac = new Vozaci(jmbg, korisnickoIme, sifra, ime, prezime, adresa, pol, brojTelefona, clanskaKarta, plata);
                    korisnici.add(vozac);
                } else if (uloga.equals("dispecer")){
                    String brojTelefonskeLinije = lineSplit[9];
                    String plata = lineSplit[10];
                    String odeljenje = lineSplit[11];
                    Dispeceri dispecer = new Dispeceri(jmbg, korisnickoIme, sifra, ime, prezime, adresa, pol, brojTelefona, brojTelefonskeLinije, plata, odeljenje);
                    korisnici.add(dispecer);
                }
            } reader.close();
        }catch(IOException e){
            System.out.println("Greska prilikom ucitavanja!");
        }
        return korisnici;
    }

    public static void upisAutomobila(ArrayList<Automobil> ucitaniAutomobili) {
//        ArrayList<Automobil> ucitaniAutomobili = ucitajAutomobil(automobiliTXT);
        String noviAutomobil = "2323"+ "|" + "opel"+ "|" + "astra" + "|" + "2010"+ "|" + "ns232ms" + "|" + "PUTNICKO_VOZILO";
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
        ArrayList<Voznja> ucitaneVoznje = ucitajVoznju(voznjaTXT);
        String novaVoznja = "100004" + "|" + "2023-05-21T23:47:08.432" + "|" + "Ulica br1 14" + "|" + "Ulica broj 2" + "|" + "KREIRANA" + "|" + "15" + "|" + "2" + "|"+ "marko" + "|" + "milan";
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

    public static ArrayList<Automobil> ucitajAutomobil(String putanjaFajla) {
        ArrayList<Automobil> automobili = new ArrayList<Automobil>();
        File file = new File(putanjaFajla);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");

                String brojVozila = lineSplit[0];
                String model = lineSplit[1];
                String proizvodjac = lineSplit[2];
                String godinaProizvodnje = lineSplit[3];
                String registracija = lineSplit[4];
                String vrstaAutomobila = lineSplit[5];
                Automobil listaAutomobila = new Automobil(brojVozila, model, proizvodjac, godinaProizvodnje, registracija, vrstaAutomobila);
                automobili.add(listaAutomobila);
            } reader.close();
        }catch(IOException e){
            System.out.println("Greska prilikom ucitavanja!");
        }
        return automobili;
    }
    public static ArrayList<Voznja> ucitajVoznju(String putanjaFajla) {
        ArrayList<Voznja> voznja = new ArrayList<Voznja>();
        File file = new File(putanjaFajla);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {

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
                Voznja porudzbina = new Voznja(id, vremePorudzbine, adresaPolaska, adresaDestinacije, status, trajanjeVoznje, brojKM, musterija, vozac);
                voznja.add(porudzbina);
            } reader.close();
        }catch(IOException e){
            System.out.println("Greska prilikom ucitavanja!");

        }
        return voznja;
    }
}