package porudzbina;
import korisnici.Musterije;
import korisnici.Vozaci;
import java.time.LocalDateTime;

public class Voznja {
    protected int id;
    protected LocalDateTime vremePorudzbine;
    protected String adresaPolaska;
    protected String adresaDestinacije;
    protected StatusVoznje status;
    protected String trajanjeVoznje;
    protected double brojKM;
    protected Musterije musterija;
    protected Vozaci vozac;

    public Voznja() {
    }

    public Voznja(int id, LocalDateTime vremePorudzbine, String adresaPolaska, String adresaDestinacije, StatusVoznje status, String trajanjeVoznje, double brojKM, Musterije musterija, Vozaci vozac) {
        this.id = id;
        this.vremePorudzbine = vremePorudzbine;
        this.adresaPolaska = adresaPolaska;
        this.adresaDestinacije = adresaDestinacije;
        this.status = status;
        this.trajanjeVoznje = trajanjeVoznje;
        this.brojKM = brojKM;
        this.musterija = musterija;
        this.vozac = vozac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getBrojKM() {
        return brojKM;
    }

    public void setBrojKM(double brojKM) {
        this.brojKM = brojKM;
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
                "id=" + id +
                ", vremePorudzbine=" + vremePorudzbine +
                ", adresaPolaska='" + adresaPolaska + '\'' +
                ", adresaDestinacije='" + adresaDestinacije + '\'' +
                ", status=" + status +
                ", trajanjeVoznje='" + trajanjeVoznje + '\'' +
                ", musterija=" + musterija +
                ", vozac=" + vozac +
                '}';
    }
}
