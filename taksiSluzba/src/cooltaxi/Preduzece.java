package cooltaxi;

public class Preduzece {
    private String PIB;
    private String naziv;
    private String adresa;
    public double cenaStartaVoznje(){return 0;}
    public double cenaPoKilometru(){return 0;}

    public Preduzece (){

    }

    public Preduzece(String PIB, String naziv, String adresa) {
        this.PIB = PIB;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Preduzece{" +
                "PIB='" + PIB + '\'' +
                ", naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
