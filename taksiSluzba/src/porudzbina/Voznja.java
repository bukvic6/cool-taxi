package porudzbina;
import korisnici.Musterije;
import korisnici.Vozaci;
import java.time.LocalDateTime;

public class Voznja {
    protected LocalDateTime vremePorudzbine;
    protected String adresaPolaska;
    protected String adresaDestinacije;
    protected StatusVoznje status;
    protected String trajanjeVoznje;
    protected Musterije musterija;
    protected Vozaci vozac;

    public Voznja() {
//        this.vremePorudzbine = "";
        this.adresaPolaska = "";
        this.adresaDestinacije = "";
//        this.status = "";
        this.trajanjeVoznje = "";
        this.musterija = new Musterije();
        this.vozac = new Vozaci();
    }

    public Voznja(LocalDateTime vremePorudzbine, String adresaPolaska, String adresaDestinacije, StatusVoznje status, String trajanjeVoznje, Musterije musterija, Vozaci vozac) {
        this.vremePorudzbine = vremePorudzbine;
        this.adresaPolaska = adresaPolaska;
        this.adresaDestinacije = adresaDestinacije;
        this.status = status;
        this.trajanjeVoznje = trajanjeVoznje;
        this.musterija = musterija;
        this.vozac = vozac;
    }

    public LocalDateTime getVremePorudzbine() {
        return vremePorudzbine;
    }

    public void setVremePorudzbine(LocalDateTime vremePorudzbine) {
        this.vremePorudzbine = vremePorudzbine;
    }

    public String getAdresaPolaska() {
        return adresaPolaska;
    }

    public void setAdresaPolaska(String adresaPolaska) {
        this.adresaPolaska = adresaPolaska;
    }

    public String getAdresaDestinacije() {
        return adresaDestinacije;
    }

    public void setAdresaDestinacije(String adresaDestinacije) {
        this.adresaDestinacije = adresaDestinacije;
    }

    public StatusVoznje getStatus() {
        return status;
    }

    public void setStatus(StatusVoznje status) {
        this.status = status;
    }

    public String getTrajanjeVoznje() {
        return trajanjeVoznje;
    }

    public void setTrajanjeVoznje(String trajanjeVoznje) {
        this.trajanjeVoznje = trajanjeVoznje;
    }

    public Musterije getMusterija() {
        return musterija;
    }

    public void setMusterija(Musterije musterija) {
        this.musterija = musterija;
    }

    public Vozaci getVozac() {
        return vozac;
    }

    public void setVozac(Vozaci vozac) {
        this.vozac = vozac;
    }

    @Override
    public String toString() {
        return "Voznja{" +
                "vremePorudzbine=" + vremePorudzbine +
                ", adresaPolaska='" + adresaPolaska + '\'' +
                ", adresaDestinacije='" + adresaDestinacije + '\'' +
                ", status=" + status +
                ", trajanjeVoznje='" + trajanjeVoznje + '\'' +
                ", musterija=" + musterija +
                ", vozac=" + vozac +
                '}';
    }
}
