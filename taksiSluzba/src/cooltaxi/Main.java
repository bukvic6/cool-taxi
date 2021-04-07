package cooltaxi;
import automobili.Automobil;
import automobili.VrstaAutomobila;
import korisnici.Dispeceri;
import korisnici.Vozaci;

public class Main {
    public static void main(String[] args) {
        Dispeceri dispeceri1 = new Dispeceri("232323","milica123", "bukvic123", "milica",
                "bukivc","nizijska","zenski","32324",233,"23233");

        System.out.println(dispeceri1);

        Vozaci vozac1 = new Vozaci("23242","todor123","todor123","todor","popovic",
                "seljackihbuna","muski","235352","324",32,
                new Automobil("1","2","3","34","ns", VrstaAutomobila.PUTNICKO_VOZILO));
        System.out.println(vozac1);

    }


}
