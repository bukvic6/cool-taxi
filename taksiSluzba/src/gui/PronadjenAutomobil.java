package gui;

import automobili.Automobil;
import cooltaxi.Preduzece;
import cooltaxi.io;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

import static cooltaxi.io.automobiliTXT;

public class PronadjenAutomobil extends JFrame {
    private ArrayList<Automobil> pronadjeniAutomobili = new ArrayList<>();
    private JToolBar mainToolbar = new JToolBar();
    private JButton btnEdit = new JButton("Izmeni");
    private JButton btnDelete = new JButton("Obrisi");
    private DefaultTableModel tableModel;
    private JTable tabela;

    public PronadjenAutomobil(ArrayList<Automobil> pronadjeniAutomobili) {
        this.pronadjeniAutomobili = pronadjeniAutomobili;
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        mainToolbar.add(btnEdit);
        mainToolbar.add(btnDelete);
        add(mainToolbar, BorderLayout.NORTH);
        mainToolbar.setFloatable(false);

        String [] zaglavlje = new String[]{"Broj vozila", "Model", "Proizvodjac", "Godina proizvodnje", "Registracija", "Vrsta automobila"};
        Object[][] sadrzaj = new Object[this.pronadjeniAutomobili.size()][zaglavlje.length];

        for (int i = 0; i < this.pronadjeniAutomobili.size(); i++){
            Automobil automobil = this.pronadjeniAutomobili.get(i);
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

    private void initActions(){
        btnEdit.addActionListener(e -> {
            int selektovanRed = tabela.getSelectedRow();
            if(selektovanRed == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.",
                        "Greska", JOptionPane.WARNING_MESSAGE);
            }else {
                String brojTaksiVozila = tableModel.getValueAt(selektovanRed, 0).toString();
                Automobil automobil = Preduzece.pronadjiAutomobil(brojTaksiVozila);
                if(automobil == null) {
                    JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja automobila",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                }else {
                    DodajIzmeniAuto IzmeniA = new DodajIzmeniAuto(automobil);
                    IzmeniA.setVisible(true);
                }
            }
        });

        btnDelete.addActionListener(e -> {
            int selektovanRed = tabela.getSelectedRow();
            if (selektovanRed == -1) {
                JOptionPane.showMessageDialog(null, "Odaberite red u tabeli",
                        "Greska", JOptionPane.WARNING_MESSAGE);
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
    }
}