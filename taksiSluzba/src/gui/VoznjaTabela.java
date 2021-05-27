package gui;

import cooltaxi.Preduzece;
import cooltaxi.io;
import korisnici.Korisnik;
import porudzbina.Voznja;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cooltaxi.io.korisniciTXT;
import static cooltaxi.io.voznjaTXT;

public class VoznjaTabela extends JFrame {
    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton("Dodaj");
    private JButton btnEdit = new JButton("Izmeni");
    private JButton btnDelete = new JButton("Obrisi");

    private DefaultTableModel tableModel;
    private JTable tabela;

    public VoznjaTabela() {
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

        String[] zaglavlje = new String[]{"Broj porudzbine", "Vreme porudzbine", "Adresa polaska", "Adresa destinacije", "Status", "Trajanje voznje", "KM", "Musterija", "Vozac"};
        Object[][] sadrzaj = new Object[Preduzece.ucitaneVoznje.size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.ucitaneVoznje.size(); i++) {
            Voznja porudzbina = Preduzece.ucitaneVoznje.get(i);
            if (!porudzbina.isObrisan()) {
                sadrzaj[i][0] = porudzbina.getId();
                sadrzaj[i][1] = porudzbina.getVremePorudzbine();
                sadrzaj[i][2] = porudzbina.getAdresaPolaska();
                sadrzaj[i][3] = porudzbina.getAdresaDestinacije();
                sadrzaj[i][4] = porudzbina.getStatus();
                sadrzaj[i][5] = porudzbina.getTrajanjeVoznje();
                sadrzaj[i][6] = porudzbina.getBrojKM();
                sadrzaj[i][7] = porudzbina.getMusterija().getKorisnickoIme();
                sadrzaj[i][8] = porudzbina.getVozac().getKorisnickoIme();
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
        btnDelete.addActionListener(e -> {
            int selektovanRed = tabela.getSelectedRow();
            if (selektovanRed == -1) {
                JOptionPane.showMessageDialog(null, "Odaberite red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
            } else {
                String adresa = tableModel.getValueAt(selektovanRed, 2).toString();
                Voznja porudzbina = Preduzece.pronadjiPorudzbinu(adresa);

                int izbor = JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da zelite da obrisete voznju?",
                        adresa + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
                if (izbor == JOptionPane.YES_OPTION) {
                    porudzbina.setObrisan(true);
                    tableModel.removeRow(selektovanRed);
                    io.sacuvajVoznju(voznjaTXT);
                }
            }
        });
    }
}
