package cooltaxi;


import java.io.*;
import java.util.ArrayList;

import automobili.Automobil;
import korisnici.*;
import porudzbina.Voznja;

import static cooltaxi.Preduzece.ucitaniAutomobili;
import static cooltaxi.Preduzece.ucitaniKorisnici;


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
//    public static void upisAutomobila(ArrayList<Automobil> ucitaniAutomobili) {
////        ArrayList<Automobil> ucitaniAutomobili = ucitajAutomobil(automobiliTXT);
//        String noviAutomobil = "2323"+ "|" + "opel"+ "|" + "astra" + "|" + "2010"+ "|" + "ns232ms" + "|" + "PUTNICKO_VOZILO";
//        try {
//            File autobomiliFile = new File(automobiliTXT);
//            BufferedWriter writer = new BufferedWriter(new FileWriter(autobomiliFile));
//            writer.write(ucitaniAutomobili + noviAutomobil);
//            writer.close();
//            System.out.println("Uspesno ste se dodali automobil!");
//        }catch(IOException e) {
//            System.out.println("Greska prilikom upisa u datoteku");
//        }
//    }
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