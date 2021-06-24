package gui;

import cooltaxi.Preduzece;
import korisnici.Korisnik;
import porudzbina.Voznja;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

import static cooltaxi.Preduzece.ucitanoPreduzece;

public class PretragaIzvestajaOVozacima extends JFrame {
    private static ArrayList<Voznja> pronadjeneVoznje = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTable tabela;

    public PretragaIzvestajaOVozacima(ArrayList<Voznja> pronadjenaVoznja) {
        this.pronadjeneVoznje = pronadjenaVoznja;
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
    }

    public static double getUkupnaZaradaPoVozacima(String korisnickoIme){
        double prosecnaZarada = 0;
        for(Voznja porudzbina: pronadjeneVoznje){
            if(porudzbina.getVozac().equals(korisnickoIme)){
                for (Preduzece cooltaxi: ucitanoPreduzece){
                    double cenaPoKm = cooltaxi.getCenaPoKilometru();
                    double cenaStarta = cooltaxi.getCenaStartaVoznje();
                    prosecnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
                }}
        }
        return prosecnaZarada;
    }

    public static double getProsecnaZaradaPoVozacima(String korisnickoIme){
        double prosecnaZarada = 0;
        for(Voznja porudzbina: pronadjeneVoznje){
            if(porudzbina.getVozac().equals(korisnickoIme)){
                for (Preduzece cooltaxi: ucitanoPreduzece){
                    double cenaPoKm = cooltaxi.getCenaPoKilometru();
                    double cenaStarta = cooltaxi.getCenaStartaVoznje();
                    prosecnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
                }}
        }
        return prosecnaZarada / pronadjeneVoznje.size();
    }

    public static float ukupanBrojKmPoVozacima(String korisnickoIme){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            if (porudzbina.getVozac().equals(korisnickoIme)) {
                ukupanBrojPredjenihKM += porudzbina.getBrojKM();
            }
        }return ukupanBrojPredjenihKM;
    }

    public static float prosecanBrojKmPoVozacima(String korisnickoIme){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            if (porudzbina.getVozac().equals(korisnickoIme)) {
                ukupanBrojPredjenihKM += porudzbina.getBrojKM();
            }
        }return ukupanBrojPredjenihKM  / pronadjeneVoznje.size();
    }

    public static float ukupnoTrajanjeVoznjePoVozacima(String korisnickoIme) {
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina : pronadjeneVoznje) {
            if (porudzbina.getVozac().equals(korisnickoIme)) {
                ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
            }
        }
        return ukupnoTrajanjeVoznje;
    }

    public static float prosecnoTrajanjeVoznjePoVozacima(String korisnickoIme) {
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina : pronadjeneVoznje) {
            if (porudzbina.getVozac().equals(korisnickoIme)) {
                ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
            }
        }
        return ukupnoTrajanjeVoznje / pronadjeneVoznje.size();
    }

    public static ArrayList<Voznja> getBrojVoznji(String korisnickoIme){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: pronadjeneVoznje){
            if (porudzbina.getVozac().equals(korisnickoIme)){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }

    private void initMenu() {
        String[] zaglavlje = new String[]{"Vozac", "Broj voznji", "Ukupna zarada", "Prosecna zarada", "Ukupno km", "Prosecno km", "Ukupno trajanje voznje", "Prosecno trajanje voznje"};
        Object[][] sadrzaj = new Object[Preduzece.getVozaci().size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.getVozaci().size(); i++) {
            Korisnik korisnik = Preduzece.getVozaci().get(i);
            String ukupanBrVoznji = String.valueOf(getBrojVoznji(korisnik.getKorisnickoIme()).size());

            sadrzaj[i][0] = korisnik.getKorisnickoIme();
            sadrzaj[i][1] = ukupanBrVoznji;
            sadrzaj[i][2] = getUkupnaZaradaPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][3] = getProsecnaZaradaPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][4] = ukupanBrojKmPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][5] = prosecanBrojKmPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][6] = ukupnoTrajanjeVoznjePoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][7] = prosecnoTrajanjeVoznjePoVozacima(korisnik.getKorisnickoIme());
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
        tabela = new JTable(tableModel);
        TableRowSorter<TableModel> sortiranje = new TableRowSorter<TableModel>(tabela.getModel());
        tabela.setRowSorter(sortiranje);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);
    }
}
