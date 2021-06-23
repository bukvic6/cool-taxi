package gui;

import cooltaxi.Preduzece;
import net.miginfocom.swing.MigLayout;
import porudzbina.Voznja;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

import static cooltaxi.Preduzece.ulogovaniKorisnik;


public class StatistikaVozaca extends JFrame {

    int broj = 15;
    String ukupanBrVoznji = String.valueOf(Preduzece.getVoznjaAplikacija().size() + Preduzece.getVoznjaTelefon().size());
    String prosekKmpoVoznji = String.valueOf(Preduzece.prosecanBrojKMpoVoznji());
    String brPredjenihKm = String.valueOf(Preduzece.ukupanBrojKm());
    String trajanjeVoznje = String.valueOf(Preduzece.ukupnoTrajanjeVoznje());
    String prosecnoTrajanjeVoznje = String.valueOf(Preduzece.prosecnoTrajanjeVoznje());
    String ukupnaZarada = String.valueOf(Preduzece.ukupnaZaradaVozaca());
    String prosecnaZarada = String.valueOf(Preduzece.prosecnaZaradaVozaca());
    private JLabel lblPrviDatum = new JLabel("Statistika od: ");
    private JTextField txtPrviDatum = new JTextField(broj);
    private JLabel lblDrugiDatum = new JLabel("do: ");
    private JTextField txtDrugiDatum = new JTextField(broj);
    private JButton pretrazi = new JButton("pretrazi");
    private JLabel lblSveVoznje = new JLabel("Ukupan broj voznji: ");
    private JTextField txtUkupanBrojVoznji = new JTextField(ukupanBrVoznji, broj);
    private JLabel lblProsekKmpoVoznji = new JLabel("Prosecan broj km po voznji: ");
    private JTextField txtprosekKmpoVoznji = new JTextField(prosekKmpoVoznji, broj);
    private JLabel lblUkupanBrojKm = new JLabel("Broj voznji putem telefona: ");
    private JTextField txtUkupanBrojKm = new JTextField(brPredjenihKm, broj);
    private JLabel lblTrajanjeVoznje = new JLabel("Ukupno trajanje voznje: ");
    private JTextField txtTrajanjeVoznji = new JTextField(trajanjeVoznje, broj);
    private JLabel lblProsecnoTrajanjeVoznje = new JLabel("Prosecno trajanje voznje: ");
    private JTextField txtProsecnoTrajanjeVoznje = new JTextField(prosecnoTrajanjeVoznje, broj);
    private JLabel lblUkupnaZarada = new JLabel("Ukupna zarada: ");
    private JTextField txtUkupnaZarada = new JTextField(ukupnaZarada, broj);
    private JLabel lblProsecnaZarada = new JLabel("Prosecna zarada po voznji: ");
    private JTextField txtProsecnaZarada = new JTextField(prosecnaZarada, broj);



    public StatistikaVozaca() {
        setTitle("Sumirana statistika voznji");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        pack();
        initActions();
    }

    public void initGUI(){
        MigLayout mig = new MigLayout("wrap 2", "[][]","[]10[][]10[]");
        setLayout(mig);
        add(lblPrviDatum);
        add(txtPrviDatum);
        add(lblDrugiDatum);
        add(txtDrugiDatum);
        add(pretrazi);
        add(lblSveVoznje);
        add(txtUkupanBrojVoznji);
        txtUkupanBrojVoznji.setEditable(false);
        add(lblProsekKmpoVoznji);
        add(txtprosekKmpoVoznji);
        txtprosekKmpoVoznji.setEditable(false);
        add(lblUkupanBrojKm);
        add(txtUkupanBrojKm);
        txtUkupanBrojKm.setEditable(false);
        add(lblTrajanjeVoznje);
        add(txtTrajanjeVoznji);
        txtTrajanjeVoznji.setEditable(false);
        add(lblProsecnoTrajanjeVoznje);
        add(txtProsecnoTrajanjeVoznje);
        txtProsecnoTrajanjeVoznje.setEditable(false);
        add(lblUkupnaZarada);
        add(txtUkupnaZarada);
        txtUkupnaZarada.setEditable(false);
        add(lblProsecnaZarada);
        add(txtProsecnaZarada);
        txtProsecnaZarada.setEditable(false);
    }
    private void initActions(){
        pretrazi.addActionListener(e -> {
            try{
                LocalDateTime prvi1 = LocalDateTime.parse(txtPrviDatum.getText());
                LocalDateTime drugi1 = LocalDateTime.parse(txtDrugiDatum.getText());
                ArrayList<Voznja> pronadjiVoznju = Preduzece.pronadjiVoznju(prvi1,drugi1, ulogovaniKorisnik.getKorisnickoIme());
                System.out.println(pronadjiVoznju);
                PronadjeneVoznje pronadjeneVoznje = new PronadjeneVoznje(pronadjiVoznju);
                pronadjeneVoznje.setVisible(true);
            }
            catch(DateTimeParseException ex) {
                System.out.println(ex.getMessage());
            };


        });
    }
}