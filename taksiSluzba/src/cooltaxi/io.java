package cooltaxi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.IOException;


public class io {

    public void ucitajKorisnike(String nazivFajla) {
        File file =  new File(nazivFajla);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {

                String[] lineSplit = line.split("\\|");

                String uloga = lineSplit[0];
                String jmgb = lineSplit[1];
                String korisnickoIme = lineSplit[2];
                String sifra = lineSplit[3];
                String ime = lineSplit[4];
                String prezime= lineSplit[5];
                String adresa = lineSplit[6];
                String brojTelefona = lineSplit[7];
                Pol pol = Pol.valueOf(polString);
}}