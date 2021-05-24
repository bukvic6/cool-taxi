package gui;

import cooltaxi.Preduzece;
import korisnici.Korisnik;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class KorisniciTabela extends JFrame {
    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton("Dodaj");
    private JButton btnEdit = new JButton("Izmeni");
    private JButton btnDelete = new JButton("Obrisi");

    private DefaultTableModel tableModel;
    private JTable tabela;

    public KorisniciTabela() {
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
    }

    private void initMenu() {
        mainToolbar.add(btnAdd);
        mainToolbar.add(btnEdit);
        mainToolbar.add(btnDelete);
        add(mainToolbar, BorderLayout.NORTH);
        mainToolbar.setFloatable(false);

        String [] zaglavlje = new String[]{"Uloga", "JMBG", "Korisnicko ime", "Ime", "Prezime", "Adresa" , "Pol", "Broj telefona"};
        Object[][] sadrzaj = new Object[Preduzece.ucitaniKorisnici.size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.ucitaniKorisnici.size(); i++){
            Korisnik korisnik = Preduzece.ucitaniKorisnici.get(i);
            sadrzaj[i][0] = korisnik.getUloga();
            sadrzaj[i][1] = korisnik.getJmbg();
            sadrzaj[i][2] = korisnik.getKorisnickoIme();
            sadrzaj[i][3] = korisnik.getIme();
            sadrzaj[i][4] = korisnik.getPrezime();
            sadrzaj[i][5] = korisnik.getAdresa();
            sadrzaj[i][6] = korisnik.getPol();
            sadrzaj[i][7] = korisnik.getBrojTelefona();
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
