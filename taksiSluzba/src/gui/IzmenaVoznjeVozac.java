package gui;

import cooltaxi.Preduzece;
import cooltaxi.io;
import net.miginfocom.swing.MigLayout;
import porudzbina.StatusVoznje;
import porudzbina.TipPorudzbine;
import porudzbina.Voznja;

import javax.swing.*;
import java.time.LocalDateTime;

import static cooltaxi.io.voznjaTXT;

public class IzmenaVoznjeVozac extends JFrame {
    private JLabel lblTipPorudzbine = new JLabel("Tip porudzbine: ");
    private JComboBox<TipPorudzbine> txtTipPorudzbine = new JComboBox<TipPorudzbine>(TipPorudzbine.values());
    private JLabel lblID = new JLabel("ID");
    private JTextField txtID = new JTextField(20);
    private JLabel lblVremePoruzbine = new  JLabel("Vreme porudzbine");
    private JTextField txtVremePorudzbine = new JTextField(20);
    private JLabel lblAdresaPolaska = new  JLabel("Adresa polaska");
    private JTextField txtAdresaPolaska = new JTextField(20);
    private JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije");
    private JTextField txtAdresaDestinacije = new JTextField(20);
    private JLabel lblStatus = new JLabel("Status voznje");
    private JComboBox<StatusVoznje> txtStatusVoznje = new JComboBox<StatusVoznje>(StatusVoznje.values());
    private JLabel lblTrajanjeVoznje = new JLabel("Trajanje voznje");
    private JTextField txtTrajanjeVoznje = new JTextField(20);
    private JLabel lblBrojKM = new JLabel("Broj predjenih km");
    private JTextField txtBrojKM = new JTextField(20);
    private JLabel lblMusterija = new JLabel("Musterija");
    private JComboBox<String> txtMusterija = new JComboBox<String>();
    private JLabel lblVozac = new JLabel("Vozac");
    private JComboBox<String> txtVozac = new JComboBox<String>();
    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private final Voznja porudzbina;

    public IzmenaVoznjeVozac(Voznja porudzbina){
        this.porudzbina = porudzbina;
        setTitle("Izmena podatka " + porudzbina.getId());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        setResizable(true);
        pack();
    }

    public void initGUI(){
        MigLayout layout = new MigLayout("wrap 2", "[][]","[][][][][][]20[]");
        setLayout(layout);

        for (Voznja voznja: Preduzece.ucitaneVoznje){
            txtStatusVoznje.addItem(voznja.getStatus());
        }

        if(porudzbina != null) {
            popuniPolja();
        }

        txtID.setText("100003");
        add(lblStatus);
        add(txtStatusVoznje);
        add(lblTrajanjeVoznje);
        add(txtTrajanjeVoznje);
        add(lblBrojKM);
        add(txtBrojKM);
        txtVozac.setSelectedItem(Preduzece.ulogovaniKorisnik.getKorisnickoIme());
        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    public void initActions() {
        btnOk.addActionListener(e -> {

            TipPorudzbine tipPorudzbine = (TipPorudzbine) txtTipPorudzbine.getSelectedItem();
            String id = txtID.getText().trim();
            String vremePoruzbine = txtVremePorudzbine.getText().trim();
            String adresaPolaska = txtAdresaPolaska.getText().trim();
            String adresaDestinacije = txtAdresaDestinacije.getText().trim();
            StatusVoznje statusVoznje = (StatusVoznje) txtStatusVoznje.getSelectedItem();
            String trajanjeVoznje = txtTrajanjeVoznje.getText().trim();
            String brojKM = txtBrojKM.getText().trim();

            porudzbina.setTipPorudzbine(tipPorudzbine);
            porudzbina.setId(Integer.parseInt(id));
            porudzbina.setVremePorudzbine(LocalDateTime.parse(vremePoruzbine));
            porudzbina.setAdresaPolaska(adresaPolaska);
            porudzbina.setAdresaDestinacije(adresaDestinacije);
            porudzbina.setStatus(statusVoznje);
            porudzbina.setTrajanjeVoznje(Integer.parseInt(trajanjeVoznje));
            porudzbina.setBrojKM(Double.parseDouble(brojKM));

            io.sacuvajVoznju(voznjaTXT);
            IzmenaVoznjeVozac.this.dispose();
            IzmenaVoznjeVozac.this.setVisible(false);
        });

        btnCancel.addActionListener(e -> {
            IzmenaVoznjeVozac.this.dispose();
            IzmenaVoznjeVozac.this.setVisible(false);
        });
    }

    private void popuniPolja() {
        txtTipPorudzbine.setSelectedItem(porudzbina.getTipPorudzbine());
        txtID.setText(String.valueOf(porudzbina.getId()));
        txtVremePorudzbine.setText(String.valueOf(porudzbina.getVremePorudzbine()));
        txtAdresaPolaska.setText(porudzbina.getAdresaPolaska());
        txtAdresaDestinacije.setText(porudzbina.getAdresaDestinacije());
        txtStatusVoznje.setSelectedItem(porudzbina.getStatus());
        txtTrajanjeVoznje.setText(String.valueOf(porudzbina.getTrajanjeVoznje()));
        txtBrojKM.setText(String.valueOf(porudzbina.getBrojKM()));
        txtMusterija.setSelectedItem(porudzbina.getMusterija());
        txtVozac.setSelectedItem(porudzbina.getVozac());
    }
}
