package gui;

import cooltaxi.Preduzece;
import porudzbina.Voznja;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class IstorijaVoznjeVozac extends JFrame {
    private DefaultTableModel tableModel;
    private JTable tabela;

    public IstorijaVoznjeVozac() {
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
    }

    private void initMenu() {

        String[] zaglavlje = new String[]{"Tip porudzbine", "Broj porudzbine", "Vreme porudzbine", "Adresa polaska", "Adresa destinacije", "Status", "Trajanje voznje", "KM", "Musterija", "Vozac"};
        Object[][] sadrzaj = new Object[Preduzece.istorijaVoznjeVozac().size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.istorijaVoznjeVozac().size(); i++) {
            Voznja porudzbina = Preduzece.istorijaVoznjeVozac().get(i);
            if (!porudzbina.isObrisan() && porudzbina.getVozac().equals(Preduzece.ulogovaniKorisnik.getKorisnickoIme())) {
                sadrzaj[i][0] = porudzbina.getTipPorudzbine();
                sadrzaj[i][1] = porudzbina.getId();
                sadrzaj[i][2] = porudzbina.getVremePorudzbine();
                sadrzaj[i][3] = porudzbina.getAdresaPolaska();
                sadrzaj[i][4] = porudzbina.getAdresaDestinacije();
                sadrzaj[i][5] = porudzbina.getStatus();
                sadrzaj[i][6] = porudzbina.getTrajanjeVoznje();
                sadrzaj[i][7] = porudzbina.getBrojKM();
                sadrzaj[i][8] = porudzbina.getMusterija();
                sadrzaj[i][9] = porudzbina.getVozac();
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
