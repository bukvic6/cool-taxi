package gui;

import cooltaxi.Preduzece;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class StatistikaVoznje extends JFrame {
    int broj = 15;
    String ukupanBrVoznji = String.valueOf(Preduzece.ucitaneVoznje.size());
    String brVoznjiApp = String.valueOf(Preduzece.VoznjeAplikacijom().size());
    String brVoznjiTel = String.valueOf(Preduzece.VoznjeTelefonom().size());
    String trajanjeVoznje = String.valueOf(Preduzece.prosecnoTrajanjeVoznji());
    String brojKM = String.valueOf(Preduzece.prosecanBrojKM());
    String ukupnaZarada = String.valueOf(Preduzece.ukupnaZarada());
    String prosecnaZarada = String.valueOf(Preduzece.prosecnaZarada());
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
        pack();
    }

    public void initGUI(){
        MigLayout mig = new MigLayout("wrap 2", "[][]","[]10[][]10[]");
        setLayout(mig);
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
}
