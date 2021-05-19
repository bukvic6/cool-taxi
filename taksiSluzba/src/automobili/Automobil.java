package automobili;
import korisnici.Vozaci;

public class Automobil extends Vozaci {
    private boolean obrisan;
    private String brojTaksiVozila;
    private String model;
    private String proizvodjac;
    private String godinaProizvodnje;
    private String registracija;
    private VrstaAutomobila tipAutomobila;

    public Automobil() {
    }

    public Automobil(boolean obrisan, String brojTaksiVozila, String model, String proizvodjac, String godinaProizvodnje, String registracija, VrstaAutomobila tipAutomobila) {
        this.obrisan = obrisan;
        this.brojTaksiVozila = brojTaksiVozila;
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.godinaProizvodnje = godinaProizvodnje;
        this.registracija = registracija;
        this.tipAutomobila = tipAutomobila;
    }

    public Automobil(String obrisan, String brojTaksiVozila, String model, String proizvodjac, String godinaProizvodnje, String registracija, String vrstaAutomobila) {
        this.obrisan = Boolean.parseBoolean(obrisan);
        this.brojTaksiVozila = brojTaksiVozila;
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.godinaProizvodnje = godinaProizvodnje;
        this.registracija = registracija;
        if (vrstaAutomobila.equals("PUTNICKO_VOZILO")){
            this.tipAutomobila = VrstaAutomobila.PUTNICKO_VOZILO;
        }else if (vrstaAutomobila.equals("KOMBI_VOZILO")) {
            this.tipAutomobila = VrstaAutomobila.KOMBI_VOZILO;
        } else {
            throw new IllegalArgumentException("Ne postoji tip vozila " + vrstaAutomobila);
        }
    }

    @Override
    public boolean isObrisan() {
        return obrisan;
    }

    @Override
    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
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
        return obrisan + "|" + brojTaksiVozila + "|" + model + "|" + proizvodjac + "|" + godinaProizvodnje + "|" + registracija + "|" + tipAutomobila + "\n";
    }
}
