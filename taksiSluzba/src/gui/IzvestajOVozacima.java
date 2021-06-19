package gui;

import cooltaxi.Preduzece;
import cooltaxi.io;
import korisnici.Korisnik;
import korisnici.Vozaci;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

import static cooltaxi.io.korisniciTXT;

public class IzvestajOVozacima extends JFrame {
    private DefaultTableModel tableModel;
    private JTable tabela;

    public IzvestajOVozacima() {
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
    }

    private void initMenu() {
        String[] zaglavlje = new String[]{"vozac", "Broj voznji","Ukupna zarada","Prosecna zarada","ukupno Km","Prosecno Km","Ukupno trajanje voznje","Prosecno trajanej voznje"};
        Object[][] sadrzaj = new Object[Preduzece.getVozaci().size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.getVozaci().size(); i++) {
            Korisnik korisnik = Preduzece.getVozaci().get(i);
            String ukupanBrVoznji = String.valueOf(Preduzece.getVoznjaAplikacijaIzvestaj(korisnik.getKorisnickoIme()).size() + Preduzece.getVoznjaTelefonIzvestaj(korisnik.getKorisnickoIme()).size());

            sadrzaj[i][0] = korisnik.getKorisnickoIme();
            sadrzaj[i][1] = ukupanBrVoznji;
            sadrzaj[i][2] = Preduzece.getUkupnaZaradaPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][3] = Preduzece.getProsecnaZaradaPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][4] = Preduzece.ukupanBrojKmPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][5] = Preduzece.prosecanBrojKmPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][6] = Preduzece.ukupnoTrajanjeVoznjePoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][7] = Preduzece.prosecnoTrajanjeVoznjePoVozacima(korisnik.getKorisnickoIme());
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
        tabela = new JTable(tableModel);
        TableRowSorter<TableModel> sortiranje =new TableRowSorter<TableModel>(tabela.getModel());
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
