package korisnici;
import automobili.Automobil;

public class Vozaci extends Korisnik {
    private String brojClanskeKarte;
    private double plata;
    private Automobil taksi;

    public Vozaci() {
    }

    public Vozaci(String jmbg, String korisnickoIme, String lozinka, String ime, String prezime, String adresa,
                  Pol pol, String brojTelefona, String brojClanskeKarte, double plata, Automobil taksi) {
        super(jmbg, korisnickoIme, lozinka, ime, prezime, adresa, pol, brojTelefona);
        this.brojClanskeKarte = brojClanskeKarte;
        this.plata = plata;
        this.taksi = taksi;
    }

    public Vozaci(String jmbg, String korisnickoIme, String sifra, String ime, String prezime, String adresa, String pol, String brojTelefona, String clanskaKarta, String plata) {
        this.jmbg = jmbg;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        if (pol.equals("MUSKI")){
            this.pol = Pol.MUSKI;
        } else if (pol.equals("ZENSKI")) {
            this.pol = Pol.ZENSKI;
        } else {
            throw new IllegalArgumentException("Pol " + pol + " ne postoji");
        }
        this.brojTelefona = brojTelefona;
        this.brojClanskeKarte = clanskaKarta;
        this.plata = Double.parseDouble(plata);
    }

    public String getBrojClanskeKarte() {
        return brojClanskeKarte;
    }

    public void setBrojClanskeKarte(String brojClanskeKarte) {
        this.brojClanskeKarte = brojClanskeKarte;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public Automobil getTaksi() {
        return taksi;
    }

    public void setTaksi(Automobil taksi) {
        this.taksi = taksi;
    }

    @Override
    public String toString() {
        return jmbg + "|" + korisnickoIme + "|" + lozinka + "|" + ime + "|" + prezime + "|" + adresa + "|" + pol + "|" + brojTelefona + "|" + brojClanskeKarte + "|" + plata + "\n";
    }
}
