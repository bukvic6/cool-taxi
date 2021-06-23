package gui;

import cooltaxi.Preduzece;
import net.miginfocom.swing.MigLayout;
import porudzbina.TipPorudzbine;
import porudzbina.Voznja;

import javax.swing.*;
import java.util.ArrayList;

import static cooltaxi.Preduzece.ucitanoPreduzece;
import static cooltaxi.Preduzece.ulogovaniKorisnik;

public class PronadjeneVoznje extends JFrame {
    private ArrayList<Voznja> pronadjeneVoznje = new ArrayList<Voznja>();
    public ArrayList<Voznja> getVoznjaAplikacija(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: pronadjeneVoznje){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.APLIKACIJA) &&
                    porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }
    public ArrayList<Voznja> getVoznjaTelefon(){
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        for (Voznja porudzbina: pronadjeneVoznje){
            if (porudzbina.getTipPorudzbine().equals(TipPorudzbine.TELEFON) &&
                    porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
                Voznja voznja = porudzbina;
                voznje.add(voznja);
            }
        }return voznje;
    }
    public float prosecanBrojKMpoVoznji(){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            ukupanBrojPredjenihKM += porudzbina.getBrojKM();

        }return ukupanBrojPredjenihKM / (getVoznjaTelefon().size() + getVoznjaAplikacija().size());
    }
    public float ukupanBrojKm(){
        float ukupanBrojPredjenihKM = 0;
        for (Voznja porudzbina: this.pronadjeneVoznje){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())) {
                ukupanBrojPredjenihKM += porudzbina.getBrojKM();
            }
        }return ukupanBrojPredjenihKM;
    }
    public float ukupnoTrajanjeVoznje(){
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())) {
                ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
            }
        }return ukupnoTrajanjeVoznje;
    }
    public float prosecnoTrajanjeVoznje(){
        float ukupnoTrajanjeVoznje = 0;
        for (Voznja porudzbina: pronadjeneVoznje){
            if (porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())) {
                ukupnoTrajanjeVoznje += porudzbina.getTrajanjeVoznje();
            }
        }return ukupnoTrajanjeVoznje / (getVoznjaTelefon().size() + getVoznjaAplikacija().size());
    }
    public double ukupnaZaradaVozaca(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: this.pronadjeneVoznje){
            if(porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
                for (Preduzece cooltaxi: ucitanoPreduzece){
                    double cenaPoKm = cooltaxi.getCenaPoKilometru();
                    double cenaStarta = cooltaxi.getCenaStartaVoznje();
                    ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
                }}
        }return ukupnaZarada;
    }
    public double prosecnaZaradaVozaca(){
        double ukupnaZarada = 0;
        for (Voznja porudzbina: this.pronadjeneVoznje){
            if(porudzbina.getVozac().equals(ulogovaniKorisnik.getKorisnickoIme())){
                for (Preduzece cooltaxi: ucitanoPreduzece){
                    double cenaPoKm = cooltaxi.getCenaPoKilometru();
                    double cenaStarta = cooltaxi.getCenaStartaVoznje();
                    ukupnaZarada += ((porudzbina.getBrojKM() * cenaPoKm) + cenaStarta);
                }}
        }return ukupnaZarada  / (getVoznjaTelefon().size() + getVoznjaAplikacija().size());
    }
    int broj = 15;

    String ukupanBrVoznji = String.valueOf(getVoznjaAplikacija().size() + getVoznjaTelefon().size());
    String prosekKmpoVoznji = String.valueOf(prosecanBrojKMpoVoznji());
    String brPredjenihKm = String.valueOf(ukupanBrojKm());
    String trajanjeVoznje = String.valueOf(ukupnoTrajanjeVoznje());
    String prosecnoTrajanjeVoznje = String.valueOf(prosecnoTrajanjeVoznje());
    String ukupnaZarada = String.valueOf(ukupnaZaradaVozaca());
    String prosecnaZarada = String.valueOf(prosecnaZaradaVozaca());
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

    public PronadjeneVoznje(ArrayList<Voznja> pronadjenaVoznja) {
        this.pronadjeneVoznje = pronadjenaVoznja;
        setTitle("Sumirana statistika voznji");
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
}
