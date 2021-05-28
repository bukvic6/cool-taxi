package korisnici;

public class Dispeceri extends Korisnik {
    private double plata;
    private String brojTelefonskeLinije;
    private Odeljenje odeljenje;

    public Dispeceri(){
    }

    public Dispeceri(String uloga, boolean obrisan, String jmbg, String korisnickoIme, String lozinka, String ime, String prezime, String adresa, Pol pol, String brojTelefona, double plata, String brojTelefonskeLinije) {
        super(obrisan, uloga, jmbg, korisnickoIme, lozinka, ime, prezime, adresa, pol, brojTelefona);
        this.plata = plata;
        this.brojTelefonskeLinije = brojTelefonskeLinije;
    }

    public Dispeceri(String obrisan, String uloga, String jmbg, String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String pol, String brojTelefona, String brojTelefonskeLinije, String plata, String odeljenje) {
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
        this.brojTelefonskeLinije = brojTelefonskeLinije;
        this.plata = Double.parseDouble(plata);
        if (odeljenje.equals("ODELJENJE_ZA_PRIJEM_VOZNJE")){
            this.odeljenje = Odeljenje.ODELJENJE_ZA_PRIJEM_VOZNJE;
        } else if (odeljenje.equals("ODELJENJE_ZA_REKLAMACIJE")){
            this.odeljenje = Odeljenje.ODELJENJE_ZA_REKLAMACIJE;
        }
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public String getBrojTelefonskeLinije() {
        return brojTelefonskeLinije;
    }

    public void setBrojTelefonskeLinije(String brojTelefonskeLinije) {
        this.brojTelefonskeLinije = brojTelefonskeLinije;
    }

    @Override
    public String toString() {
        return obrisan + "|" + uloga + "|" + jmbg + "|" + korisnickoIme + "|" + lozinka + "|" + ime + "|" + prezime + "|" + adresa + "|" + pol + "|" + brojTelefona + "|" + brojTelefonskeLinije + "|" + plata + "|" + odeljenje + "\n";
    }
}
