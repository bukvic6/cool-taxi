package porudzbina;

import cooltaxi.Preduzece;
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

    public Voznja(String id, String vremePorudzbine, String adresaPolaska, String adresaDestinacije, String status, String trajanjeVoznje, String brojKM, String musterija, String vozac) {
        this.id = Integer.parseInt(id);
        this.vremePorudzbine = LocalDateTime.parse(vremePorudzbine);
        this.adresaPolaska = adresaPolaska;
        this.adresaDestinacije = adresaDestinacije;
        if (status.equals("KREIRANA")){
            this.status = StatusVoznje.KREIRANA;
        } else if (status.equals("KREIRANA_NA_CEKANJU")){
            this.status = StatusVoznje.KREIRANA_NA_CEKANJU;
        } else if (status.equals("DODELJENA")){
            this.status = StatusVoznje.DODELJENA;
        } else if (status.equals("PRIHVACENA")){
        this.status = StatusVoznje.PRIHVACENA;
        } else if (status.equals("ZAVRSENA")){
            this.status = StatusVoznje.ZAVRSENA;
        }else if (status.equals("ODBIJENA")){
            this.status = StatusVoznje.ODBIJENA;
        } else {
            throw new IllegalArgumentException("Status " + status + " ne postoji");
        }
        this.trajanjeVoznje = trajanjeVoznje;
        this.brojKM = Double.parseDouble(brojKM);
        this.musterija = (Musterije) Preduzece.pronadjiKorisnika(musterija);
        this.vozac = (Vozaci) Preduzece.pronadjiKorisnika(vozac);
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
        return id + "|" + vremePorudzbine + "|" + adresaPolaska + "|" + adresaDestinacije + "|" + status + "|" + brojKM + "|" + trajanjeVoznje + "|" + musterija.getKorisnickoIme() + "|" + vozac.getKorisnickoIme() + "\n";
    }
}
