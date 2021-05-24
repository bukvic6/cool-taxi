package gui;

import cooltaxi.Preduzece;
import cooltaxi.io;
import korisnici.Korisnik;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cooltaxi.io.korisniciTXT;


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
        initActions();
    }

    private void initMenu() {
        mainToolbar.add(btnAdd);
        mainToolbar.add(btnEdit);
        mainToolbar.add(btnDelete);
        add(mainToolbar, BorderLayout.NORTH);
        mainToolbar.setFloatable(false);

        String[] zaglavlje = new String[]{"Uloga", "JMBG", "Korisnicko ime", "Ime", "Prezime", "Adresa", "Pol", "Broj telefona"};
        Object[][] sadrzaj = new Object[Preduzece.ucitaniKorisnici.size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.ucitaniKorisnici.size(); i++) {
            Korisnik korisnik = Preduzece.ucitaniKorisnici.get(i);
            if (!korisnik.isObrisan()) {
                sadrzaj[i][0] = korisnik.getUloga();
                sadrzaj[i][1] = korisnik.getJmbg();
                sadrzaj[i][2] = korisnik.getKorisnickoIme();
                sadrzaj[i][3] = korisnik.getIme();
                sadrzaj[i][4] = korisnik.getPrezime();
                sadrzaj[i][5] = korisnik.getAdresa();
                sadrzaj[i][6] = korisnik.getPol();
                sadrzaj[i][7] = korisnik.getBrojTelefona();
            }
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

    private void initActions() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selektovanRed = tabela.getSelectedRow();
                if (selektovanRed == -1) {
                    JOptionPane.showMessageDialog(null, "Odaberite red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
                } else {
                    String korisnickoIme = tableModel.getValueAt(selektovanRed, 2).toString();
                    Korisnik korisnik = Preduzece.pronadjiKorisnika(korisnickoIme);

                    int izbor = JOptionPane.showConfirmDialog(null,
                            "Da li ste sigurni da zelite da obrisete korisnika?",
                            korisnickoIme + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
                    if (izbor == JOptionPane.YES_OPTION) {
                        korisnik.setObrisan(true);
                        tableModel.removeRow(selektovanRed);
                        io.sacuvajKorisnike(korisniciTXT);
                    }
                }
            }
        });
    }
}
