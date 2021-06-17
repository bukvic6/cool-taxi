package cooltaxi;

import automobili.Automobil;
import korisnici.Korisnik;
import korisnici.Vozaci;
import porudzbina.TipPorudzbine;
import porudzbina.Voznja;

import java.util.ArrayList;

import static cooltaxi.io.*;

public class Preduzece {
    private String PIB;
    private String naziv;
    private String adresa;
    private double CenaStartaVoznje;
    private double CenaPoKilometru;

    public static ArrayList<Automobil> ucitaniAutomobili = io.ucitajAutomobil(automobiliTXT);
    public static ArrayList<Korisnik> ucitaniKorisnici = io.ucitajKorisnike(korisniciTXT);
    public static ArrayList<Voznja> ucitaneVoznje = io.ucitajVoznju(voznjaTXT);
    public static ArrayList<Preduzece> ucitanoPreduzece = io.ucitajPreduzece(preduzeceTXT);

    public static Korisnik ulogovaniKorisnik;

    public static Preduzece pronadjiPreduzece(String naziv){
        for (Preduzece preduzece: ucitanoPreduzece){
            if (preduzece.getNaziv().equals(naziv)){
                return preduzece;
            }
        } return null;
    }

    public static Korisnik obrisiKorisnika(String korisnickoIme){
        for (Korisnik korisnik: ucitaniKorisnici) {
            if (korisnik.getKorisnickoIme().equals(korisnickoIme) && !korisnik.isObrisan()) {
                korisnik.setObrisan(true);
                return korisnik;
            }
        } return null;
    }

    public static Korisnik pronadjiKorisnika(String korisnickoIme){
        for (Korisnik korisnik: ucitaniKorisnici){
            if (korisnik.getKorisnickoIme().equals(korisnickoIme)){
                return korisnik;
            }
        } return null;
    }

    public static Korisnik login(String korisnickoIme, String lozinka) {
        ucitaniKorisnici = io.ucitajKorisnike(korisniciTXT);
        for(Korisnik korisnik : ucitaniKorisnici) {
            if(korisnik.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
                    korisnik.getLozinka().equals(lozinka) && !korisnik.isObrisan()){
                return korisnik;
            }
        }
        return null;
    }

    public static Automobil obrisiAutomobil(String brojTaksiVozila){
        for (Automobil automobil: ucitaniAutomobili) {
            if (automobil.getBrojTaksiVozila().equals(brojTaksiVozila) && !automobil.isObrisan()) {
                automobil.setObrisan(true);
                return automobil;
            }
        } return null;
    }

    public static Automobil pronadjiAutomobil(String brojTaksiVozila){
        for (Automobil automobil: ucitaniAutomobili){
            if (automobil.getBrojTaksiVozila().equals(brojTaksiVozila)){
                return automobil;
            }
        } return null;
    }

    public static Voznja pronadjiPorudzbinu(String adresa){
        for (Voznja porudzbina: ucitaneVoznje){
            if (porudzbina.getAdresaPolaska().equals(adresa)){
                return porudzbina;
            }
        } return null;
    }

    public static ArrayList<Vozaci> getVozaci(){
        ArrayList<Vozaci> vozaci = new ArrayList<Vozaci>();
        for (Korisnik korisnik: ucitaniKorisnici){
            if (korisnik.getUloga().equals("vozac") && !korisnik.isObrisan()){
                Vozaci vozac = (Vozaci) korisnik;
                vozaci.add(vozac);
            }
        }return vozaci;
    }

    public static ArrayList<Voznja> getVoznjaTelefon(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: ucitaneVoznje){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.TELEFON) && porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> getVoznjaAplikacija(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: ucitaneVoznje){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.APLIKACIJA) && porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> VoznjeTelefonom(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: ucitaneVoznje){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.TELEFON)){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> VoznjeAplikacijom(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: ucitaneVoznje){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.APLIKACIJA)){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static float prosecnoTrajanjeVoznji(){
        float ukupnoTrajanjeVoznji = 0;
        for (Voznja porudzbina: ucitaneVoznje){
            ukupnoTrajanjeVoznji += porudzbina.getTrajanjeVoznje();
        }return ukupnoTrajanjeVoznji / ucitaneVoznje.size();
    }

    public static float prosecanBrojKM(){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: ucitaneVoznje){
            ukupanBrojPredjenihKM += porudzbina.getBrojKM();
        }return ukupanBrojPredjenihKM / ucitaneVoznje.size();
    }

    public static float prosecanBrojKMpoVoznji(){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: ucitaneVoznje){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())) {
            ukupanBrojPredjenihKM += porudzbina.getBrojKM();
            }
        }return ukupanBrojPredjenihKM / (getVoznjaTelefon().size() + getVoznjaAplikacija().size());
    }
    public static float ukupanBrojKm(){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: ucitaneVoznje){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())) {
                ukupanBrojPredjenihKM += porudzbina.getBrojKM();
            }
        }return ukupanBrojPredjenihKM;
    }

    public static float ukupnoTrajanjeVoznje(){
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina: ucitaneVoznje){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())) {
                ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
            }
        }return ukupnoTrajanjeVoznje;
    }
    public static float prosecnoTrajanjeVoznje(){
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina: ucitaneVoznje){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())) {
                ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
            }
        }return ukupnoTrajanjeVoznje / (getVoznjaTelefon().size() + getVoznjaAplikacija().size());
    }

    public static double ukupnaZarada(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: ucitaneVoznje){
            for (Preduzece cooltaxi: ucitanoPreduzece){
                double cenaPoKm = cooltaxi.getCenaPoKilometru();
                double cenaStarta = cooltaxi.getCenaStartaVoznje();
                ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
            }
        }return ukupnaZarada;
    }

    public static double prosecnaZarada(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: ucitaneVoznje){
            for (Preduzece cooltaxi: ucitanoPreduzece){
                double cenaPoKm = cooltaxi.getCenaPoKilometru();
                double cenaStarta = cooltaxi.getCenaStartaVoznje();
                ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
            }
        }return ukupnaZarada / ucitaneVoznje.size();
    }

    public static double ukupnaZaradaVozaca(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: ucitaneVoznje){
            if(porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
            for (Preduzece cooltaxi: ucitanoPreduzece){
                double cenaPoKm = cooltaxi.getCenaPoKilometru();
                double cenaStarta = cooltaxi.getCenaStartaVoznje();
                ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
            }}
        }return ukupnaZarada;
    }

    public static double prosecnaZaradaVozaca(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: ucitaneVoznje){
            if(porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
                for (Preduzece cooltaxi: ucitanoPreduzece){
                double cenaPoKm = cooltaxi.getCenaPoKilometru();
                double cenaStarta = cooltaxi.getCenaStartaVoznje();
                ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
            }}
        }return ukupnaZarada  / (getVoznjaTelefon().size() + getVoznjaAplikacija().size());
    }

    public Preduzece (){
    }

    public Preduzece(String PIB, String naziv, String adresa, String cenaStarta, String cenaPoKM) {
        this.PIB = PIB;
        this.naziv = naziv;
        this.adresa = adresa;
        this.CenaStartaVoznje = Double.parseDouble(cenaStarta);
        this.CenaPoKilometru = Double.parseDouble(cenaPoKM);
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public double getCenaStartaVoznje() {
        return CenaStartaVoznje;
    }

    public void setCenaStartaVoznje(double CenaStartaVoznje) {
        this.CenaStartaVoznje = CenaStartaVoznje;
    }

    public double getCenaPoKilometru() {
        return CenaPoKilometru;
    }

    public void setCenaPoKilometru(double CenaPoKilometru) {
        this.CenaPoKilometru = CenaPoKilometru;
    }

    @Override
    public String toString() {
        return PIB + "|" + naziv + "|" + adresa + "|" + CenaStartaVoznje + "|" + CenaPoKilometru;
    }
}
