package cooltaxi;

import automobili.Automobil;
import korisnici.Korisnik;
import porudzbina.Voznja;

import java.util.ArrayList;

import static cooltaxi.io.*;

public class Preduzece {
    private String PIB;
    private String naziv;
    private String adresa;
    public double cenaStartaVoznje(){return 0;}
    public double cenaPoKilometru(){return 0;}

    public static ArrayList<Korisnik> ucitaniKorisnici = io.ucitajKorisnike(korisniciTXT);
    public static ArrayList<Automobil> ucitaniAutomobili = io.ucitajAutomobil(automobiliTXT);
    public static ArrayList<Voznja> ucitaneVoznje = io.ucitajVoznju(voznjaTXT);

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

    public static Automobil pronadjiAutomobil(String registracija){
        for (Automobil automobil: ucitajAutomobil(automobiliTXT)){
            if (automobil.getRegistracija().equals(registracija)){
                return automobil;
            }
        } return null;
    }

    public Preduzece (){

    }

    public Preduzece(String PIB, String naziv, String adresa) {
        this.PIB = PIB;
        this.naziv = naziv;
        this.adresa = adresa;
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


    @Override
    public String toString() {
        return "Preduzece " + naziv + " se nalazi na adresi: " + adresa + " sa pib-om " + PIB;
    }
}
