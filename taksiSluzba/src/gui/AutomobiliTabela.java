package gui;

import automobili.Automobil;
import cooltaxi.Preduzece;
import cooltaxi.io;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cooltaxi.io.automobiliTXT;

public class AutomobiliTabela extends JFrame {
    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton("Dodaj");
    private JButton btnEdit = new JButton("Izmeni");
    private JButton btnDelete = new JButton("Obrisi");

    private DefaultTableModel tableModel;
    private JTable tabela;

    public AutomobiliTabela() {
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

        String [] zaglavlje = new String[]{"Broj vozila", "Model", "Proizvodjac", "Godina proizvodnje", "Registracija", "Vrsta automobila"};
        Object[][] sadrzaj = new Object[Preduzece.ucitaniAutomobili.size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.ucitaniAutomobili.size(); i++){
            Automobil automobil = Preduzece.ucitaniAutomobili.get(i);
            if(!automobil.isObrisan()) {
                sadrzaj[i][0] = automobil.getBrojTaksiVozila();
                sadrzaj[i][1] = automobil.getModel();
                sadrzaj[i][2] = automobil.getProizvodjac();
                sadrzaj[i][3] = automobil.getGodinaProizvodnje();
                sadrzaj[i][4] = automobil.getRegistracija();
                sadrzaj[i][5] = automobil.getTipAutomobila();
            }
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
    private void initActions() {
        btnDelete.addActionListener(e -> {
            int selektovanRed = tabela.getSelectedRow();
            if (selektovanRed == -1) {
                JOptionPane.showMessageDialog(null, "Odaberite red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
            } else {
                String registracija = tableModel.getValueAt(selektovanRed, 4).toString();
                Automobil automobil = Preduzece.pronadjiAutomobil(registracija);

                int izbor = JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da zelite da obrisete automobil?",
                        registracija + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
                if (izbor == JOptionPane.YES_OPTION) {
                    automobil.setObrisan(true);
                    tableModel.removeRow(selektovanRed);
                    io.sacuvajAutomobile(automobiliTXT);
                }
            }
        });

        btnAdd.addActionListener(e -> {
            DodajIzmeniAuto DodajA = new DodajIzmeniAuto(null);
            DodajA.setVisible(true);
        });

        btnEdit.addActionListener(e -> {
            int selektovanRed = tabela.getSelectedRow();
            if(selektovanRed == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
            }else {
                String brojTaksiVozila = tableModel.getValueAt(selektovanRed, 0).toString();
                Automobil automobil = Preduzece.pronadjiAutomobil(brojTaksiVozila);
                if(automobil == null) {
                    JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja automobila", "Greska", JOptionPane.WARNING_MESSAGE);
                }else {
                    DodajIzmeniAuto IzmeniA = new DodajIzmeniAuto(automobil);
                    IzmeniA.setVisible(true);
                }
            }
        });

    }
}
