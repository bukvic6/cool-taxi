package automobili;
import korisnici.Vozaci;

public class Automobil extends Vozaci {
    private String brojTaksiVozila;
    private String model;
    private String proizvodjac;
    private String godinaProizvodnje;
    private String registracija;
    private VrstaAutomobila tipAutomobila;


    public Automobil() {
    }

    public Automobil(String brojTaksiVozila, String model, String proizvodjac, String godinaProizvodnje, String registracija, VrstaAutomobila tipAutomobila) {
        this.brojTaksiVozila = brojTaksiVozila;
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.godinaProizvodnje = godinaProizvodnje;
        this.registracija = registracija;
        this.tipAutomobila = tipAutomobila;
    }

    public String getBrojTaksiVozila() {
        return brojTaksiVozila;
    }

    public void setBrojTaksiVozila(String brojTaksiVozila) {
        this.brojTaksiVozila = brojTaksiVozila;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(String godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public String getRegistracija() {
        return registracija;
    }

    public void setRegistracija(String registracija) {
        this.registracija = registracija;
    }

    public VrstaAutomobila getTipAutomobila() {
        return tipAutomobila;
    }

    public void setTipAutomobila(VrstaAutomobila tipAutomobila) {
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
