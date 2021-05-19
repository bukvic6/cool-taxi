package korisnici;

import porudzbina.Voznja;

public class Musterije extends Korisnik{
    protected Voznja poruzbina;

    public Musterije() {
    }

    public Musterije(String uloga, boolean obrisan, String jmbg, String korisnickoIme, String lozinka, String ime, String prezime, String adresa, Pol pol, String brojTelefona, Voznja poruzbina) {
        super(uloga, obrisan, jmbg, korisnickoIme, lozinka, ime, prezime, adresa, pol, brojTelefona);
        this.poruzbina = poruzbina;
    }

    public Musterije(String obrisan, String uloga, String jmbg, String korisnickoIme, String lozinka, String ime, String prezime, String adresa,String pol, String brojTelefona) {
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
    }

    public Voznja getPoruzbina() {
        return poruzbina;
    }

    public void setPoruzbina(Voznja poruzbina) {
        this.poruzbina = poruzbina;
    }

    @Override
    public String toString() {
        return obrisan + "|" + uloga + "|" + jmbg + "|" + korisnickoIme + "|" + lozinka + "|" + ime + "|" + prezime + "|" + adresa + "|" + pol + "|" + brojTelefona + "\n";
    }
}
