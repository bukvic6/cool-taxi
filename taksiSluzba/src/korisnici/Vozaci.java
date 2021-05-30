package korisnici;
import automobili.Automobil;
import cooltaxi.Preduzece;

public class Vozaci extends Korisnik {
    private String brojClanskeKarte;
    private double plata;
    private Automobil taksi;
    private String taksiBroj;

    public Vozaci() {
    }

    public Vozaci(boolean obrisan, String uloga, String jmbg, String korisnickoIme, String lozinka, String ime, String prezime, String adresa,
                  Pol pol, String brojTelefona, String brojClanskeKarte, double plata, Automobil taksi) {
        super(obrisan, uloga, jmbg, korisnickoIme, lozinka, ime, prezime, adresa, pol, brojTelefona);
        this.brojClanskeKarte = brojClanskeKarte;
        this.plata = plata;
        this.taksi = taksi;
    }

    public Vozaci(String obrisan, String uloga, String jmbg, String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String pol, String brojTelefona, String clanskaKarta, String plata, String taksiBroj) {
        this.obrisan = Boolean.parseBoolean(obrisan);
        this.uloga = uloga;
        this.jmbg = jmbg;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
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
        this.taksiBroj = taksiBroj;
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

    public String getTaksiBroj() {
        return taksiBroj;
    }

    public void setTaksiBroj(String taksiBroj) {
        this.taksiBroj = taksiBroj;
    }

    @Override
    public String toString() {
        return obrisan + "|" + uloga + "|" + jmbg + "|" + korisnickoIme + "|" + lozinka + "|" + ime + "|"
                + prezime + "|" + adresa + "|" + pol + "|" + brojTelefona + "|" + brojClanskeKarte + "|"
                + plata + "|" + (taksiBroj==null?"":taksiBroj) +"\n";
    }
}
