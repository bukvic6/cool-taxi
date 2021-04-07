package korisnici;

import porudzbina.Voznja;

public class Musterije extends Korisnik{
    protected Voznja poruzbina;

    public Musterije() {
    }

    public Musterije(String jmbg, String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String pol, String brojTelefona, Voznja poruzbina) {
        super(jmbg, korisnickoIme, lozinka, ime, prezime, adresa, pol, brojTelefona);
        this.poruzbina = poruzbina;
    }

    public Voznja getPoruzbina() {
        return poruzbina;
    }

    public void setPoruzbina(Voznja poruzbina) {
        this.poruzbina = poruzbina;
    }

    @Override
    public String toString() {
        return "Musterije{" +
                "jmbg='" + jmbg + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", pol='" + pol + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                ", poruzbina=" + poruzbina +
                '}';
    }
}
