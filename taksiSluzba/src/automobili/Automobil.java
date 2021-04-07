package automobili;
import korisnici.Vozaci;

public class Automobil extends Vozaci {
    protected String brojTaksiVozila;
    protected String model;
    protected String proizvodjac;
    protected String godinaProizvodnje;
    protected String registracija;
    protected VrstaAutomobila tipAutomobila;


    public Automobil() {
        this.brojTaksiVozila = "";
        this.model = "";
        this.proizvodjac = "";
        this.godinaProizvodnje = "";
        this.registracija = "";
//        this.tipAutomobila = "";
    }

    public Automobil(String brojTaksiVozila, String model, String proizvodjac, String godinaProizvodnje, String registracija, VrstaAutomobila tipAutomobila) {
        this.brojTaksiVozila = brojTaksiVozila;
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.godinaProizvodnje = godinaProizvodnje;
        this.registracija = registracija;
        this.tipAutomobila = tipAutomobila;
    }

    @Override
    public String toString() {
        return "Automobil{" +
                "brojTaksiVozila='" + brojTaksiVozila + '\'' +
                ", model='" + model + '\'' +
                ", proizvodjac='" + proizvodjac + '\'' +
                ", godinaProizvodnje='" + godinaProizvodnje + '\'' +
                ", registracija='" + registracija + '\'' +
                '}';
    }
}
