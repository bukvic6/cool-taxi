package cooltaxi;
import automobili.Automobil;
import automobili.VrstaAutomobila;
import korisnici.Dispeceri;
import korisnici.Musterije;
import korisnici.Pol;
import korisnici.Vozaci;
import porudzbina.StatusVoznje;
import porudzbina.Voznja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import static cooltaxi.io.*;

public class Main {
    public static void main(String[] args) {
//        String korisniciTXT = "taksiSluzba/src/txt/korisnici.txt";
//        String automobiliTXT = "taksiSluzba/src/txt/automobil.txt";
//        String voznjaTXT = "taksiSluzba/src/txt/voznja.txt";

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
        io.ucitajKorisnike(korisniciTXT);
        io.ucitajAutomobil(automobiliTXT);
        io.ucitajVoznju(voznjaTXT);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite jmbg: ");
        String jmbg = scanner.nextLine();

        System.out.print("Unesite korisnicko ime: ");
        String korisnickoIme = scanner.nextLine();

        System.out.print("Unesite sifru: ");
        String sifra = scanner.nextLine();

        System.out.print("Unesite ime: ");
        String ime = scanner.nextLine();

        System.out.print("Unesite prezime: ");
        String prezime = scanner.nextLine();

        System.out.print("Unesite adresa: ");
        String adresa = scanner.nextLine();

        System.out.print("Unesite pol: ");
        Pol pol = Pol.valueOf(scanner.nextLine());

        System.out.print("Unesite broj telefona: ");
        String brojTelefona = scanner.nextLine();

        io.registracija(jmbg, korisnickoIme, sifra, ime, prezime, adresa, pol, brojTelefona);

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

        scanner.close();

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
