package korisnici;
import automobili.Automobil;

public class Vozaci extends Korisnik {
    private String brojClanskeKarte;
    private double plata;

    public Automobil getTaksi() {
        return taksi;
    }

    public void setTaksi(Automobil taksi) {
        this.taksi = taksi;
    }

    private Automobil taksi;

    public Vozaci() {
    }

    public Vozaci(String jmbg, String korisnickoIme, String lozinka, String ime, String prezime, String adresa,
                  String pol, String brojTelefona, String brojClanskeKarte, double plata, Automobil taksi) {
        super(jmbg, korisnickoIme, lozinka, ime, prezime, adresa, pol, brojTelefona);
        this.brojClanskeKarte = brojClanskeKarte;
        this.plata = plata;
        this.taksi = taksi;
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

    @Override
    public String toString() {
        return "vozaci{" +
                "jmbg='" + jmbg + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", pol='" + pol + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                ", brojClanskeKarte='" + brojClanskeKarte + '\'' +
                ", plata=" + plata +
                ", taksi=" + taksi +
                '}';
    }
}
