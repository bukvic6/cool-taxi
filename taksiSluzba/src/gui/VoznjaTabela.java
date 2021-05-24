package gui;

import cooltaxi.Preduzece;
import porudzbina.Voznja;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VoznjaTabela extends JFrame {

    private DefaultTableModel tableModel;
    private JTable tabela;

    public VoznjaTabela() {
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
    }

    private void initMenu() {

        String[] zaglavlje = new String[]{"Broj porudzbine", "Vreme porudzbine", "Adresa polaska", "Adresa destinacije", "Status", "Trajanje voznje", "KM", "Musterija", "Vozac"};
        Object[][] sadrzaj = new Object[Preduzece.ucitaneVoznje.size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.ucitaneVoznje.size(); i++) {
            Voznja porudzbina = Preduzece.ucitaneVoznje.get(i);
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
