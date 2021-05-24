package gui;

import automobili.Automobil;
import cooltaxi.Preduzece;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
            sadrzaj[i][0] = automobil.getBrojTaksiVozila();
            sadrzaj[i][1] = automobil.getModel();
            sadrzaj[i][2] = automobil.getProizvodjac();
            sadrzaj[i][3] = automobil.getGodinaProizvodnje();
            sadrzaj[i][4] = automobil.getRegistracija();
            sadrzaj[i][5] = automobil.getTipAutomobila();
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
