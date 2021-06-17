package gui;

import cooltaxi.Preduzece;
import cooltaxi.io;
import korisnici.Korisnik;
import korisnici.Vozaci;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        String[] zaglavlje = new String[]{"vozac", "", "Ime", "Prezime", "Adresa", "Pol", "Broj telefona", "Broj clanske karte", "Plata", "Vozilo"};
        Object[][] sadrzaj = new Object[Preduzece.getVozaci().size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.getVozaci().size(); i++) {
            Korisnik korisnik = Preduzece.getVozaci().get(i);
            sadrzaj[i][0] = korisnik.getJmbg();
            sadrzaj[i][1] = korisnik.getKorisnickoIme();
            sadrzaj[i][2] = korisnik.getIme();
            sadrzaj[i][3] = korisnik.getPrezime();
            sadrzaj[i][4] = korisnik.getAdresa();
            sadrzaj[i][5] = korisnik.getPol();
            sadrzaj[i][6] = korisnik.getBrojTelefona();
            sadrzaj[i][7] = ((Vozaci) korisnik).getBrojClanskeKarte();
            sadrzaj[i][8] = ((Vozaci) korisnik).getPlata();
            sadrzaj[i][9] = ((Vozaci) korisnik).getTaksiBroj();
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
        tabela = new JTable(tableModel);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);
    }
}
