package cooltaxi;

import automobili.Automobil;
import automobili.VrstaAutomobila;
import korisnici.Korisnik;
import korisnici.Musterije;
import korisnici.Pol;
import korisnici.Vozaci;
import porudzbina.Voznja;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static cooltaxi.io.*;

public class Main {
    public static void main(String[] args) {

//        Dispeceri dispeceri1 = new Dispeceri("232323","milica123", "bukvic123", "milica",
//                "bukivc","nizijska","zenski","32324",233,"23233");
//
//        System.out.println(dispeceri1);
//
//        Vozaci vozac1 = new Vozaci("23242","todor123","todor123","todor","popovic",
//                "seljackihbuna","muski","235352","324",32,
//                new Automobil("1","Opel","a","2010","ns", VrstaAutomobila.PUTNICKO_VOZILO));
//
//        System.out.println(vozac1);

        ArrayList<Korisnik> ucitaniKorisnici = io.ucitajKorisnike(korisniciTXT);
        for (Korisnik musterije: ucitaniKorisnici){
            System.out.print(musterije);
        }


        ArrayList<Automobil> ucitaniAutomobili = io.ucitajAutomobil(automobiliTXT);
        for (Automobil automobil: ucitaniAutomobili){
            System.out.print(automobil);
        }


        ArrayList<Voznja> ucitaneVoznje = io.ucitajVoznju(voznjaTXT);
        for (Voznja porudzbina: ucitaneVoznje){
            System.out.print(porudzbina);
        }

//        io.upisAutomobila(ucitaniAutomobili);
//        io.upisVoznje();

        Preduzece CoolTaxi = new Preduzece();
        CoolTaxi.setPIB("3846296229");
        CoolTaxi.setAdresa("Todora Toze Jovanovica 13");
        CoolTaxi.setNaziv("Cool Taxi");
        System.out.println(CoolTaxi);
        Scanner skener = new Scanner(System.in);

        System.out.print("Unesite korisnicko ime: ");
        String username = skener.nextLine();

        System.out.print("Unesite sifru: ");
        String password = skener.nextLine();

        skener.close();

        if(login(username, password)) {
            System.out.println("Dobrodosli " + username);
        }else {
            System.out.println("Pogresni login podaci, pokusajte ponovo.");
        }

    }


    public static boolean login(String username, String password) {
        try {
            File file = new File("taksiSluzba/src/txt/korisnici.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                String user = lineSplit[2];
                String pass = lineSplit[3];

                if(user.equalsIgnoreCase(username) && pass.equalsIgnoreCase(password)) {
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
