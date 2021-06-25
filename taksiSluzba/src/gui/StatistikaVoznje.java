package gui;

import cooltaxi.Preduzece;
import net.miginfocom.swing.MigLayout;
import porudzbina.Voznja;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class StatistikaVoznje extends JFrame {
    int broj = 15;
    String ukupanBrVoznji = String.valueOf(Preduzece.zavrseneVoznje().size());
    String brVoznjiApp = String.valueOf(Preduzece.VoznjeAplikacijom().size());
    String brVoznjiTel = String.valueOf(Preduzece.VoznjeTelefonom().size());
    String trajanjeVoznje = String.valueOf(Preduzece.prosecnoTrajanjeVoznji());
    String brojKM = String.valueOf(Preduzece.prosecanBrojKM());
    String ukupnaZarada = String.valueOf(Preduzece.ukupnaZarada());
    String prosecnaZarada = String.valueOf(Preduzece.prosecnaZarada());
    private JLabel lblPrviDatum = new JLabel("Unesite datum (yyyy-mm-ddThh:mm:ss) od: ");
    private JTextField txtPrviDatum = new JTextField(broj);
    private JLabel lblDrugiDatum = new JLabel("Unesite datum (yyyy-mm-ddThh:mm:ss) do: ");
    private JTextField txtDrugiDatum = new JTextField(broj);
    private JButton btnPretraga = new JButton("pretrazi");
    private JLabel lblSveVoznje = new JLabel("Ukupan broj voznji: ");
    private JTextField txtUkupanBrojVoznji = new JTextField(ukupanBrVoznji, broj);
    private JLabel lblVoznjeApp = new JLabel("Broj voznji putem aplikacije: ");
    private JTextField txtUkupanBrojVoznjiApp = new JTextField(brVoznjiApp, broj);
    private JLabel lblVoznjeTel = new JLabel("Broj voznji putem telefona: ");
    private JTextField txtUkupanBrojVoznjiTel = new JTextField(brVoznjiTel, broj);
    private JLabel lblTrajanjeVoznje = new JLabel("Prosecno trajanje voznje (min): ");
    private JTextField txtProsecnoTrajanjeVoznji = new JTextField(trajanjeVoznje, broj);
    private JLabel lblPredjeniKM = new JLabel("Prosecan broj predjenih km: ");
    private JTextField txtProsecanBrojKM = new JTextField(brojKM, broj);
    private JLabel lblUkupnaZarada = new JLabel("Ukupna zarada: ");
    private JTextField txtUkupnaZarada = new JTextField(ukupnaZarada, broj);
    private JLabel lblProsecnaZarada = new JLabel("Prosecna zarada po voznji: ");
    private JTextField txtProsecnaZarada = new JTextField(prosecnaZarada, broj);

    public StatistikaVoznje() {
        setTitle("Sumirane statistike za voznje");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    public void initGUI(){
        MigLayout mig = new MigLayout("wrap 2", "[][]","[]10[][]10[]");
        setLayout(mig);
        add(lblPrviDatum);
        add(txtPrviDatum);
        add(lblDrugiDatum);
        add(txtDrugiDatum);
        add(btnPretraga, "span 2");
        add(lblSveVoznje);
        add(txtUkupanBrojVoznji);
        txtUkupanBrojVoznji.setEditable(false);
        add(lblVoznjeApp);
        add(txtUkupanBrojVoznjiApp);
        txtUkupanBrojVoznjiApp.setEditable(false);
        add(lblVoznjeTel);
        add(txtUkupanBrojVoznjiTel);
        txtUkupanBrojVoznjiTel.setEditable(false);
        add(lblTrajanjeVoznje);
        add(txtProsecnoTrajanjeVoznji);
        txtProsecnoTrajanjeVoznji.setEditable(false);
        add(lblPredjeniKM);
        add(txtProsecanBrojKM);
        txtProsecanBrojKM.setEditable(false);
        add(lblUkupnaZarada);
        add(txtUkupnaZarada);
        txtUkupnaZarada.setEditable(false);
        add(lblProsecnaZarada);
        add(txtProsecnaZarada);
        txtProsecnaZarada.setEditable(false);
    }

    private void initActions(){
        btnPretraga.addActionListener(e -> {
            try{
                LocalDateTime prvi1 = LocalDateTime.parse(txtPrviDatum.getText());
                LocalDateTime drugi1 = LocalDateTime.parse(txtDrugiDatum.getText());
                ArrayList<Voznja> pronadjiVoznju = Preduzece.pronadjiVoznju(prvi1, drugi1);
                PronadjeneVoznjeDispecer pronadjeneVoznje = new PronadjeneVoznjeDispecer(pronadjiVoznju);
                pronadjeneVoznje.setVisible(true);
            }
            catch(DateTimeParseException ex) {
                System.out.println(ex.getMessage());
            };
        });
    }
}
