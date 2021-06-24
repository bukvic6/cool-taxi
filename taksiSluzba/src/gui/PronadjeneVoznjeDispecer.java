package gui;

import cooltaxi.Preduzece;
import net.miginfocom.swing.MigLayout;
import porudzbina.TipPorudzbine;
import porudzbina.Voznja;

import javax.swing.*;
import java.util.ArrayList;

import static cooltaxi.Preduzece.ucitanoPreduzece;

public class PronadjeneVoznjeDispecer extends JFrame {
    private static ArrayList<Voznja> pronadjeneVoznje = new ArrayList<>();
    int broj = 15;

    private JLabel lblSveVoznje = new JLabel("Ukupan broj voznji: ");
    private JTextField txtUkupanBrojVoznji = new JTextField(broj);
    private JLabel lblVoznjeApp = new JLabel("Broj voznji putem aplikacije: ");
    private JTextField txtUkupanBrojVoznjiApp = new JTextField(broj);
    private JLabel lblVoznjeTel = new JLabel("Broj voznji putem telefona: ");
    private JTextField txtUkupanBrojVoznjiTel = new JTextField(broj);
    private JLabel lblTrajanjeVoznje = new JLabel("Prosecno trajanje voznje (min): ");
    private JTextField txtProsecnoTrajanjeVoznji = new JTextField(broj);
    private JLabel lblPredjeniKM = new JLabel("Prosecan broj predjenih km: ");
    private JTextField txtProsecanBrojKM = new JTextField(broj);
    private JLabel lblUkupnaZarada = new JLabel("Ukupna zarada: ");
    private JTextField txtUkupnaZarada = new JTextField(broj);
    private JLabel lblProsecnaZarada = new JLabel("Prosecna zarada po voznji: ");
    private JTextField txtProsecnaZarada = new JTextField(broj);
    private String ukupanBrVoznji;
    private String brVoznjiApp;
    private String brVoznjiTel;
    private String trajanjeVoznje;
    private String brojKM;
    private String ukupnaZarada;
    private String prosecnaZarada;

    public PronadjeneVoznjeDispecer(ArrayList<Voznja> pronadjenaVoznja) {
        this.pronadjeneVoznje = pronadjenaVoznja;
        ukupanBrVoznji = String.valueOf(pronadjeneVoznje.size());
        brVoznjiApp = String.valueOf(VoznjeAplikacijom().size());
        brVoznjiTel = String.valueOf(VoznjeTelefonom().size());
        trajanjeVoznje = String.valueOf(prosecnoTrajanjeVoznji());
        brojKM = String.valueOf(prosecanBrojKM());
        ukupnaZarada = String.valueOf(ukupnaZarada());
        prosecnaZarada = String.valueOf(prosecnaZarada());
        setTitle("Sumirane statistike za voznje");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initText();
        pack();
    }

    public static ArrayList<Voznja> VoznjeAplikacijom(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: pronadjeneVoznje){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.APLIKACIJA)){
                voznje.add(porudzbina);
            }
        }return voznje;
    }

    public static ArrayList<Voznja> VoznjeTelefonom(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: pronadjeneVoznje){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.TELEFON)){
                voznje.add(porudzbina);
            }
        }return voznje;
    }

    public static float prosecnoTrajanjeVoznji(){
        float ukupnoTrajanjeVoznji = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            ukupnoTrajanjeVoznji += porudzbina.getTrajanjeVoznje();
        }return ukupnoTrajanjeVoznji / pronadjeneVoznje.size();
    }

    public static float prosecanBrojKM(){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            ukupanBrojPredjenihKM += porudzbina.getBrojKM();
        }return ukupanBrojPredjenihKM / pronadjeneVoznje.size();
    }

    public static double ukupnaZarada(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            for (Preduzece cooltaxi: ucitanoPreduzece){
                double cenaPoKm = cooltaxi.getCenaPoKilometru();
                double cenaStarta = cooltaxi.getCenaStartaVoznje();
                ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
            }
        }return ukupnaZarada;
    }

    public static double prosecnaZarada(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            for (Preduzece cooltaxi: ucitanoPreduzece){
                double cenaPoKm = cooltaxi.getCenaPoKilometru();
                double cenaStarta = cooltaxi.getCenaStartaVoznje();
                ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
            }
        }return ukupnaZarada / pronadjeneVoznje.size();
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

    public void initText() {
        txtUkupanBrojVoznji.setText(ukupanBrVoznji);
        txtUkupanBrojVoznjiApp.setText(brVoznjiApp);
        txtUkupanBrojVoznjiTel.setText(brVoznjiTel);
        txtProsecnoTrajanjeVoznji.setText(trajanjeVoznje);
        txtProsecanBrojKM.setText(brojKM);
        txtUkupnaZarada.setText(ukupnaZarada);
        txtProsecnaZarada.setText(prosecnaZarada);
    }
}
