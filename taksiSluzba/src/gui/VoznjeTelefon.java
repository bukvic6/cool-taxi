package gui;

import cooltaxi.Preduzece;
import porudzbina.TipPorudzbine;
import porudzbina.Voznja;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VoznjeTelefon extends JFrame {
    private JToolBar mainToolbar = new JToolBar();
    private JButton btnEdit = new JButton("Izmeni");

    private DefaultTableModel tableModel;
    private JTable tabela;

    public VoznjeTelefon() {
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        mainToolbar.add(btnEdit);
        add(mainToolbar, BorderLayout.NORTH);
        mainToolbar.setFloatable(false);

        String[] zaglavlje = new String[]{"Tip porudzbine", "Broj porudzbine", "Vreme porudzbine", "Adresa polaska", "Adresa destinacije", "Status", "Trajanje voznje", "KM", "Musterija", "Vozac"};
        Object[][] sadrzaj = new Object[Preduzece.getVoznjaTelefon().size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.getVoznjaTelefon().size(); i++) {
            Voznja porudzbina = Preduzece.getVoznjaTelefon().get(i);
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
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnEdit.addActionListener(e -> {
            int selektovanRed = tabela.getSelectedRow();
            if(selektovanRed == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
            }else {
                String adresa = tableModel.getValueAt(selektovanRed, 3).toString();
                Voznja porudzbina = Preduzece.pronadjiPorudzbinu(adresa);
                if(porudzbina == null) {
                    JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja voznje", "Greska", JOptionPane.WARNING_MESSAGE);
                }else {
                    IzmenaVoznjeVozac izmeniVoznju = new IzmenaVoznjeVozac(porudzbina);
                    izmeniVoznju.setVisible(true);
                }
            }
        });
    }
}