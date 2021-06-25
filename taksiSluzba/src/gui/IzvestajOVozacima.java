package gui;

import cooltaxi.Preduzece;
import korisnici.Korisnik;
import net.miginfocom.swing.MigLayout;
import porudzbina.Voznja;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class IzvestajOVozacima extends JFrame {
    int broj = 20;
    private JLabel lblPrviDatum = new JLabel("Unesite datum (yyyy-mm-ddThh:mm:ss) od: ");
    private JTextField txtPrviDatum = new JTextField(broj);
    private JLabel lblDrugiDatum = new JLabel("Unesite datum (yyyy-mm-ddThh:mm:ss) do: ");
    private JTextField txtDrugiDatum = new JTextField(broj);
    private JButton pretrazi = new JButton("pretrazi");
    private DefaultTableModel tableModel;
    private JTable tabela;

    public IzvestajOVozacima() {
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initMenu();
        initActions();
    }

    public void initGUI(){
        MigLayout mig = new MigLayout("wrap 2", "[][]","[]10[][]10[]");
        setLayout(mig);
        add(lblPrviDatum);
        add(txtPrviDatum);
        add(lblDrugiDatum);
        add(txtDrugiDatum);
        add(pretrazi, "span 2");
    }

    private void initMenu() {
        String[] zaglavlje = new String[]{"Vozac", "Broj voznji", "Ukupna zarada", "Prosecna zarada", "Ukupno km", "Prosecno km", "Ukupno trajanje voznje", "Prosecno trajanje voznje"};
        Object[][] sadrzaj = new Object[Preduzece.getVozaci().size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.getVozaci().size(); i++) {
            Korisnik korisnik = Preduzece.getVozaci().get(i);
            String ukupanBrVoznji = String.valueOf(Preduzece.getBrojVoznji(korisnik.getKorisnickoIme()).size());

            sadrzaj[i][0] = korisnik.getKorisnickoIme();
            sadrzaj[i][1] = ukupanBrVoznji;
            sadrzaj[i][2] = Preduzece.getUkupnaZaradaPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][3] = Preduzece.getProsecnaZaradaPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][4] = Preduzece.ukupanBrojKmPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][5] = Preduzece.prosecanBrojKmPoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][6] = Preduzece.ukupnoTrajanjeVoznjePoVozacima(korisnik.getKorisnickoIme());
            sadrzaj[i][7] = Preduzece.prosecnoTrajanjeVoznjePoVozacima(korisnik.getKorisnickoIme());
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
        tabela = new JTable(tableModel);
        TableRowSorter<TableModel> sortiranje = new TableRowSorter<TableModel>(tabela.getModel());
        tabela.setRowSorter(sortiranje);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSize(500,300);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions(){
        pretrazi.addActionListener(e -> {
            try{
                LocalDateTime prvi1 = LocalDateTime.parse(txtPrviDatum.getText());
                LocalDateTime drugi1 = LocalDateTime.parse(txtDrugiDatum.getText());
                ArrayList<Voznja> pronadjiVoznju = Preduzece.pronadjiVoznju(prvi1, drugi1);
                PretragaIzvestajaOVozacima pronadjeneVoznje = new PretragaIzvestajaOVozacima(pronadjiVoznju);
                pronadjeneVoznje.setVisible(true);
            }
            catch(DateTimeParseException ex) {
                System.out.println(ex.getMessage());
            };
        });
    }

}