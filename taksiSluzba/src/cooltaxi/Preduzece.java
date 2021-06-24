package cooltaxi;

import automobili.Automobil;
import korisnici.Korisnik;
import korisnici.Vozaci;
import porudzbina.StatusVoznje;
import porudzbina.TipPorudzbine;
import porudzbina.Voznja;

import java.time.LocalDateTime;
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

    public static ArrayList<Vozaci> pronadjiVozaca(String korisnickoIme, String prezime, double plata, String auto){
        ArrayList<Vozaci> pronadjeniVozaci = new ArrayList<>();
        for (Vozaci vozac: getVozaci()) {
            if ((korisnickoIme.equals("") || vozac.getKorisnickoIme().contains(korisnickoIme)) &&
                    (prezime.equals("") || vozac.getPrezime().contains(prezime)) &&
                        vozac.getPlata() >= plata &&
                            (auto.equals("") || vozac.getTaksiBroj().contains(auto))) {
                pronadjeniVozaci.add(vozac);
            }
        }return pronadjeniVozaci;
    }

    public static ArrayList<Voznja> pronadjiVoznju(LocalDateTime prvi, LocalDateTime drugi, String korisnickoIme){
        ArrayList<Voznja> pronadjeneVoznje = new ArrayList<>();
        for (Voznja voznja: zavrseneVoznje()) {
            if (voznja.getVremePorudzbine().isAfter(prvi) && voznja.getVremePorudzbine().isBefore(drugi)
                    && voznja.getVozac().equals(korisnickoIme)){
                pronadjeneVoznje.add(voznja);
            }
        }return pronadjeneVoznje;
    }

    public static ArrayList<Voznja> pronadjiVoznju(LocalDateTime prvi, LocalDateTime drugi){
        ArrayList<Voznja> pronadjeneVoznje = new ArrayList<>();
        for (Voznja voznja: zavrseneVoznje()) {
            if (voznja.getVremePorudzbine().isAfter(prvi) && voznja.getVremePorudzbine().isBefore(drugi)){
                pronadjeneVoznje.add(voznja);
            }
        }return pronadjeneVoznje;
    }

    public static Vozaci pronadjiVozacaPoKorisnickomImenu(String korisnickoIme){
        for (Vozaci vozac: getVozaci()) {
            if (vozac.getKorisnickoIme().equals(korisnickoIme)) {
                return vozac;
            }
        }return null;
    }

    public static Vozaci pronadjiVozacaPoPrezimenu(String prezime){
        for (Vozaci vozac: getVozaci()) {
            if (vozac.getPrezime().equals(prezime)) {
                return vozac;
            }
        }return null;
    }

    public static Vozaci pronadjiVozacaPoPlati(double plata){
        for (Vozaci vozac: getVozaci()) {
            if (vozac.getPlata() == plata) {
                return vozac;
            }
        }return null;
    }

    public static Vozaci pronadjiVozacaPoAutomobilu(String auto){
        for (Vozaci vozac: getVozaci()) {
            if (vozac.getTaksiBroj().equals(auto)) {
                return vozac;
            }
        }return null;
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

    public static ArrayList<Automobil> pronadjiAutomobil(String model,String proizvodjac, String godinaProizvodnje,
                                                         String registracija, String taxiBroj){
        ArrayList<Automobil> pronadjeniAutomobili = new ArrayList<>();
        for (Automobil automobil: ucitaniAutomobili) {
            if ((model.equals("") || automobil.getModel().contains(model)) &&
                    (proizvodjac.equals("") || automobil.getProizvodjac().contains(proizvodjac)) &&
                    (godinaProizvodnje.equals("") || automobil.getGodinaProizvodnje().contains(godinaProizvodnje)) &&
                    (registracija.equals("") || automobil.getRegistracija().contains(registracija)) &&
                            (taxiBroj.equals("") || automobil.getBrojTaksiVozila().contains(taxiBroj)))  {
                pronadjeniAutomobili.add(automobil);
            }
        }return pronadjeniAutomobili;
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

    public static ArrayList<Voznja> istorijaVoznjeVozac(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: ucitaneVoznje){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> istorijaVoznjiMusterija(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: ucitaneVoznje){
            if (porudzbina.getMusterija().equals(ulogovaniKorisnik.getKorisnickoIme())){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> zavrseneVoznje() {
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: ucitaneVoznje) {
            if (porudzbina.getStatus().equals(StatusVoznje.ZAVRSENA)){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> getVoznjaTelefon(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.TELEFON) &&
                    porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> getVoznjaTelefonIzvestaj(String korisnickoIme){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.TELEFON) &&
                    porudzbina.getVozac().equals(korisnickoIme)){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> getVoznjaAplikacija(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.APLIKACIJA) &&
                    porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> getVoznjaAplikacijaIzvestaj(String korisnickoIme){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.APLIKACIJA) && porudzbina.getVozac().equals(korisnickoIme)){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> VoznjeTelefonom(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.TELEFON)){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> VoznjeAplikacijom(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.APLIKACIJA)){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    public static float prosecnoTrajanjeVoznji(){
        float ukupnoTrajanjeVoznji = 0;
        for (Voznja porudzbina: zavrseneVoznje()){
            ukupnoTrajanjeVoznji += porudzbina.getTrajanjeVoznje();
        }return ukupnoTrajanjeVoznji / zavrseneVoznje().size();
    }

    public static float prosecanBrojKM(){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: zavrseneVoznje()){
            ukupanBrojPredjenihKM += porudzbina.getBrojKM();
        }return ukupanBrojPredjenihKM / zavrseneVoznje().size();
    }

    public static float prosecanBrojKMpoVoznji(){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())) {
            ukupanBrojPredjenihKM += porudzbina.getBrojKM();
            }
        }return ukupanBrojPredjenihKM / (getVoznjaTelefon().size() + getVoznjaAplikacija().size());
    }

    public static float ukupanBrojKm(){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())) {
                ukupanBrojPredjenihKM += porudzbina.getBrojKM();
            }
        }return ukupanBrojPredjenihKM;
    }

    public static float ukupnoTrajanjeVoznje(){
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())) {
                ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
            }
        }return ukupnoTrajanjeVoznje;
    }

    public static float prosecnoTrajanjeVoznje(){
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())) {
                ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
            }
        }return ukupnoTrajanjeVoznje / (getVoznjaTelefon().size() + getVoznjaAplikacija().size());
    }

    public static double ukupnaZarada(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: zavrseneVoznje()){
            for (Preduzece cooltaxi: ucitanoPreduzece){
                double cenaPoKm = cooltaxi.getCenaPoKilometru();
                double cenaStarta = cooltaxi.getCenaStartaVoznje();
                ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
            }
        }return ukupnaZarada;
    }

    public static double prosecnaZarada(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: zavrseneVoznje()){
            for (Preduzece cooltaxi: ucitanoPreduzece){
                double cenaPoKm = cooltaxi.getCenaPoKilometru();
                double cenaStarta = cooltaxi.getCenaStartaVoznje();
                ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
            }
        }return ukupnaZarada / zavrseneVoznje().size();
    }

    public static double ukupnaZaradaVozaca(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: zavrseneVoznje()){
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
        for (Voznja porudzbina: zavrseneVoznje()){
            if(porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
                for (Preduzece cooltaxi: ucitanoPreduzece){
                double cenaPoKm = cooltaxi.getCenaPoKilometru();
                double cenaStarta = cooltaxi.getCenaStartaVoznje();
                ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
            }}
        }return ukupnaZarada  / (getVoznjaTelefon().size() + getVoznjaAplikacija().size());
    }

    public static double getProsecnaZaradaPoVozacima(String korisnickoIme){
        double prosecnaZarada = 0;
        for(Voznja porudzbina: zavrseneVoznje()){
            if(porudzbina.getVozac().equals(korisnickoIme)){
                for (Preduzece cooltaxi: ucitanoPreduzece){
                    double cenaPoKm = cooltaxi.getCenaPoKilometru();
                    double cenaStarta = cooltaxi.getCenaStartaVoznje();
                    prosecnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
                }}
        }
        return prosecnaZarada / (getVoznjaTelefonIzvestaj(korisnickoIme).size() + getVoznjaAplikacijaIzvestaj(korisnickoIme).size());
    }

    public static double getUkupnaZaradaPoVozacima(String korisnickoIme){
        double prosecnaZarada = 0;
        for(Voznja porudzbina: zavrseneVoznje()){
            if(porudzbina.getVozac().equals(korisnickoIme)){
                for (Preduzece cooltaxi: ucitanoPreduzece){
                    double cenaPoKm = cooltaxi.getCenaPoKilometru();
                    double cenaStarta = cooltaxi.getCenaStartaVoznje();
                    prosecnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
                }}
        }
        return prosecnaZarada;
    }

    public static float ukupanBrojKmPoVozacima(String korisnickoIme){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getVozac().equals(korisnickoIme)) {
                ukupanBrojPredjenihKM += porudzbina.getBrojKM();
            }
        }return ukupanBrojPredjenihKM;
    }

    public static float prosecanBrojKmPoVozacima(String korisnickoIme){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: zavrseneVoznje()){
            if (porudzbina.getVozac().equals(korisnickoIme)) {
                ukupanBrojPredjenihKM += porudzbina.getBrojKM();
            }
        }return ukupanBrojPredjenihKM  / (getVoznjaTelefonIzvestaj(korisnickoIme).size() + getVoznjaAplikacijaIzvestaj(korisnickoIme).size());
    }

    public static float ukupnoTrajanjeVoznjePoVozacima(String korisnickoIme) {
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina : zavrseneVoznje()) {
            if (porudzbina.getVozac().equals(korisnickoIme)) {
                ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
            }
        }
        return ukupnoTrajanjeVoznje;
    }

    public static float prosecnoTrajanjeVoznjePoVozacima(String korisnickoIme) {
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina : zavrseneVoznje()) {
            if (porudzbina.getVozac().equals(korisnickoIme)) {
                ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
            }
        }
        return ukupnoTrajanjeVoznje / (getVoznjaTelefonIzvestaj(korisnickoIme).size() + getVoznjaAplikacijaIzvestaj(korisnickoIme).size());
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