package cooltaxi;


import java.io.*;
import java.security.Permission;
import java.util.ArrayList;

import automobili.Automobil;
import korisnici.*;
import porudzbina.Voznja;

import static cooltaxi.Preduzece.*;


public class io {

    public static String korisniciTXT = "taksiSluzba/src/txt/korisnici.txt";
    public static String automobiliTXT = "taksiSluzba/src/txt/automobil.txt";
    public static String voznjaTXT = "taksiSluzba/src/txt/voznja.txt";
    public static String preduzeceTXT = "taksiSluzba/src/txt/preduzece.txt";

    public static ArrayList<Preduzece> ucitajPreduzece (String putanjaFajla) {
        ArrayList<Preduzece> preduzece = new ArrayList<Preduzece>();
        File file = new File(putanjaFajla);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");
                String pib = lineSplit[0];
                String adresa = lineSplit[1];
                String ime = lineSplit[2];
                Preduzece cooltaxi = new Preduzece(pib, adresa,ime);
                preduzece.add(cooltaxi);
            } reader.close();
        }catch(IOException e){
            System.out.println("Greska prilikom ucitavanja!");
        }
        return preduzece;
    }
    public static void sacuvajPreduzece(String putanjaFajla) {
        try {
            File file = new File(putanjaFajla);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String sadrzaj = "";
            for (Preduzece preduzece: ucitanoPreduzece){
                sadrzaj += preduzece.toString();
            }
            writer.write(sadrzaj);
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Korisnik> ucitajKorisnike(String putanjaFajla) {
        ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
        File file = new File(putanjaFajla);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");
                String obrisan = lineSplit[0];
                String uloga = lineSplit[1];
                String jmbg = lineSplit[2];
                String korisnickoIme = lineSplit[3];
                String lozinka = lineSplit[4];
                String ime = lineSplit[5];
                String prezime = lineSplit[6];
                String adresa = lineSplit[7];
                String pol = lineSplit[8];
                String brojTelefona = lineSplit[9];

                if (uloga.equals("musterija")){
                    Musterije musterija = new Musterije(obrisan, uloga, jmbg, korisnickoIme, lozinka, ime, prezime, adresa, pol, brojTelefona);
                    korisnici.add(musterija);
                } else if (uloga.equals("vozac")){
                    String clanskaKarta = lineSplit[10];
                    String plata = lineSplit[11];
                    String taksi = lineSplit[12];
                    Vozaci vozac = new Vozaci(obrisan, uloga, jmbg, korisnickoIme, lozinka, ime, prezime, adresa, pol, brojTelefona, clanskaKarta, plata, taksi);
                    korisnici.add(vozac);
                } else if (uloga.equals("dispecer")){
                    String brojTelefonskeLinije = lineSplit[10];
                    String plata = lineSplit[11];
                    String odeljenje = lineSplit[12];
                    Dispeceri dispecer = new Dispeceri(obrisan, uloga, jmbg, korisnickoIme, lozinka, ime, prezime, adresa, pol, brojTelefona, brojTelefonskeLinije, plata, odeljenje);
                    korisnici.add(dispecer);
                }
            } reader.close();
        }catch(IOException e){
            System.out.println("Greska prilikom ucitavanja!");
        }
        return korisnici;
    }

    public static void sacuvajKorisnike(String putanjaFajla) {
        try {
            File file = new File(putanjaFajla);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String sadrzaj = "";
            for (Korisnik korisnik: ucitaniKorisnici){
                sadrzaj += korisnik.toString();
            }
            writer.write(sadrzaj);
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
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
                String obrisan = lineSplit[0];
                String brojVozila = lineSplit[1];
                String model = lineSplit[2];
                String proizvodjac = lineSplit[3];
                String godinaProizvodnje = lineSplit[4];
                String registracija = lineSplit[5];
                String vrstaAutomobila = lineSplit[6];
                Automobil listaAutomobila = new Automobil(obrisan, brojVozila, model, proizvodjac, godinaProizvodnje, registracija, vrstaAutomobila);
                automobili.add(listaAutomobila);
            } reader.close();
        }catch(IOException e){
            System.out.println("Greska prilikom ucitavanja!");
        }
        return automobili;
    }

    public static void sacuvajAutomobile(String putanjaFajla) {
        try {
            File file = new File(putanjaFajla);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String sadrzaj = "";
            for (Automobil automobil: ucitaniAutomobili){
                sadrzaj += automobil.toString();
            }
            writer.write(sadrzaj);
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static ArrayList<Voznja> ucitajVoznju(String putanjaFajla) {
        ArrayList<Voznja> voznja = new ArrayList<Voznja>();
        File file = new File(putanjaFajla);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");
                String obrisan = lineSplit[0];
                String tipPorudzbine = lineSplit[1];
                String id = lineSplit[2];
                String vremePorudzbine = lineSplit[3];
                String adresaPolaska = lineSplit[4];
                String adresaDestinacije = lineSplit[5];
                String status = lineSplit[6];
                String trajanjeVoznje = lineSplit[7];
                String brojKM = lineSplit[8];
                String musterija = lineSplit[9];
                String vozac = lineSplit[10];
                Voznja porudzbina = new Voznja(obrisan, tipPorudzbine, id, vremePorudzbine, adresaPolaska, adresaDestinacije, status, trajanjeVoznje, brojKM, musterija, vozac);
                voznja.add(porudzbina);
            } reader.close();
        }catch(IOException e){
            System.out.println("Greska prilikom ucitavanja!");
        }
        return voznja;
    }


    public static void sacuvajVoznju(String putanjaFajla) {
        try {
            File file = new File(putanjaFajla);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String sadrzaj = "";
            for (Voznja porudzbina: ucitaneVoznje){
                sadrzaj += porudzbina.toString();
            }
            writer.write(sadrzaj);
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}