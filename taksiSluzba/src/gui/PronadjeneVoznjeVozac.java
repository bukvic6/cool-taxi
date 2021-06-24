package gui;

import cooltaxi.Preduzece;
import net.miginfocom.swing.MigLayout;
import porudzbina.Voznja;

import javax.swing.*;
import java.util.ArrayList;

import static cooltaxi.Preduzece.ucitanoPreduzece;

public class PronadjeneVoznjeVozac extends JFrame {
    private static ArrayList<Voznja> pronadjeneVoznje = new ArrayList<>();

    int broj = 15;
    private String ukupanBrVoznji;
    private String prosekKmpoVoznji;
    private String brPredjenihKm;
    private String trajanjeVoznje;
    private String prosecnoTrajanjeVoznje;
    private String ukupnaZarada;
    private String prosecnaZarada;
    private JLabel lblSveVoznje = new JLabel("Ukupan broj voznji: ");
    private JTextField txtUkupanBrojVoznji = new JTextField(ukupanBrVoznji, broj);
    private JLabel lblProsekKmpoVoznji = new JLabel("Prosecan broj km po voznji: ");
    private JTextField txtprosekKmpoVoznji = new JTextField(prosekKmpoVoznji, broj);
    private JLabel lblUkupanBrojKm = new JLabel("Ukupan broj km: ");
    private JTextField txtUkupanBrojKm = new JTextField(brPredjenihKm, broj);
    private JLabel lblTrajanjeVoznje = new JLabel("Ukupno trajanje voznje: ");
    private JTextField txtTrajanjeVoznji = new JTextField(trajanjeVoznje, broj);
    private JLabel lblProsecnoTrajanjeVoznje = new JLabel("Prosecno trajanje voznje: ");
    private JTextField txtProsecnoTrajanjeVoznje = new JTextField(prosecnoTrajanjeVoznje, broj);
    private JLabel lblUkupnaZarada = new JLabel("Ukupna zarada: ");
    private JTextField txtUkupnaZarada = new JTextField(ukupnaZarada, broj);
    private JLabel lblProsecnaZarada = new JLabel("Prosecna zarada po voznji: ");
    private JTextField txtProsecnaZarada = new JTextField(prosecnaZarada, broj);

    public PronadjeneVoznjeVozac(ArrayList<Voznja> pronadjenaVoznja) {
        this.pronadjeneVoznje = pronadjenaVoznja;
        ukupanBrVoznji = String.valueOf(pronadjeneVoznje.size());
        prosekKmpoVoznji = String.valueOf(prosecanBrojKMpoVoznji());
        brPredjenihKm = String.valueOf(ukupanBrojKm());
        trajanjeVoznje = String.valueOf(ukupnoTrajanjeVoznje());
        prosecnoTrajanjeVoznje = String.valueOf(prosecnoTrajanjeVoznje());
        ukupnaZarada = String.valueOf(ukupnaZaradaVozaca());
        prosecnaZarada = String.valueOf(prosecnaZaradaVozaca());
        setTitle("Sumirana statistika voznji");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initText();
        pack();
    }

    public static float prosecanBrojKMpoVoznji(){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            ukupanBrojPredjenihKM += porudzbina.getBrojKM();

        }return ukupanBrojPredjenihKM / pronadjeneVoznje.size();
    }

    public static float ukupanBrojKm(){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            ukupanBrojPredjenihKM += porudzbina.getBrojKM();
        }return ukupanBrojPredjenihKM;
    }

    public static float ukupnoTrajanjeVoznje(){
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
        }return ukupnoTrajanjeVoznje;
    }

    public static float prosecnoTrajanjeVoznje(){
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
        }return ukupnoTrajanjeVoznje / pronadjeneVoznje.size();
    }

    public static double ukupnaZaradaVozaca(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            for (Preduzece cooltaxi: ucitanoPreduzece){
                double cenaPoKm = cooltaxi.getCenaPoKilometru();
                double cenaStarta = cooltaxi.getCenaStartaVoznje();
                ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
            }
        }return ukupnaZarada;
    }

    public static double prosecnaZaradaVozaca(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            for (Preduzece cooltaxi: ucitanoPreduzece) {
                double cenaPoKm = cooltaxi.getCenaPoKilometru();
                double cenaStarta = cooltaxi.getCenaStartaVoznje();
                ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
            }
        }return ukupnaZarada  / pronadjeneVoznje.size();
    }
    
    public void initGUI(){
        MigLayout mig = new MigLayout("wrap 2", "[][]","[]10[][]10[]");
        setLayout(mig);
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

    public void initText(){
        txtUkupanBrojVoznji.setText(ukupanBrVoznji);
        txtprosekKmpoVoznji.setText(prosekKmpoVoznji);
        txtUkupanBrojKm.setText(brPredjenihKm);
        txtTrajanjeVoznji.setText(trajanjeVoznje);
        txtProsecnoTrajanjeVoznje.setText(prosecnoTrajanjeVoznje);
        txtUkupnaZarada.setText(ukupnaZarada);
        txtProsecnaZarada.setText(prosecnaZarada);
    }
}
