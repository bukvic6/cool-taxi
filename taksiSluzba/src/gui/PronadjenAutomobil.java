package gui;

import automobili.Automobil;
import cooltaxi.Preduzece;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

public class PronadjenAutomobil extends JFrame {
    private ArrayList<Automobil> pronadjeniAutomobili = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTable tabela;

    public PronadjenAutomobil(ArrayList<Automobil> pronadjeniAutomobili) {
        this.pronadjeniAutomobili = pronadjeniAutomobili;
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
    }

    private void initMenu() {
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


}
