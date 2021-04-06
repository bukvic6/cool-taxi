package korisnici;

public class Dispeceri extends Korisnik {
    private double plata;
    private String brojTelefonskeLinije;
//    protected Odeljenje odeljenje;

    public Dispeceri(){
        super();
        this.plata = 0;
        this.brojTelefonskeLinije = "";
//        this.odeljenje = new Odeljenje();
    }

    public Dispeceri(String jmbg, String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String pol, String brojTelefona, double plata, String brojTelefonskeLinije) {
        super(jmbg, korisnickoIme, lozinka, ime, prezime, adresa, pol, brojTelefona);
        this.plata = plata;
        this.brojTelefonskeLinije = brojTelefonskeLinije;
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
        return "dispeceri{" +
                "plata=" + plata +
                ", brojTelefonskeLinije='" + brojTelefonskeLinije + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", pol='" + pol + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                '}';
    }
}
