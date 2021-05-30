package gui;


import cooltaxi.Preduzece;
import cooltaxi.io;
import net.miginfocom.swing.MigLayout;
import porudzbina.StatusVoznje;
import porudzbina.Voznja;

import javax.swing.*;

import static cooltaxi.io.voznjaTXT;

public class RezervacijaAplikacija extends JFrame {

    private JTextField txtID = new JTextField(20);
    private JTextField txtVremePorudzbine = new JTextField(20);
    private JLabel lblAdresaPolaska = new  JLabel("Adresa polaska");
    private JTextField txtAdresaPolaska = new JTextField(20);
    private JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije");
    private JTextField txtAdresaDestinacije = new JTextField(20);
    private JComboBox<StatusVoznje> txtStatusVoznje = new JComboBox<StatusVoznje>(StatusVoznje.values());
    private JTextField txtTrajanjeVoznje = new JTextField(20);
    private JTextField txtBrojKM = new JTextField(20);
    private JLabel lblMusterija = new JLabel("Unesite ime: (jovanaj)");
    private JTextField txtMusterija = new JTextField(20);
    private JTextField txtVozac = new JTextField(20);
    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");


    public RezervacijaAplikacija(){

        setTitle("Rezervacija voznje putem aplikacije");
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
        txtID.setText("100003");
        txtVremePorudzbine.setText("2021-01-21T05:47:08.644");
        add(lblAdresaPolaska);
        add(txtAdresaPolaska);
        add(lblAdresaDestinacije);
        add(txtAdresaDestinacije);
        txtStatusVoznje.setSelectedItem(StatusVoznje.KREIRANA_NA_CEKANJU);
        txtTrajanjeVoznje.setText("5");
        txtBrojKM.setText("15");
        add(lblMusterija);
        add(txtMusterija);
        txtVozac.setText("petarp");
        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    public void initActions() {
        btnOk.addActionListener(e -> {

            String id = txtID.getText().trim();
            String vremePoruzbine = txtVremePorudzbine.getText().trim();
            String adresaPolaska = txtAdresaPolaska.getText().trim();
            String adresaDestinacije = txtAdresaDestinacije.getText().trim();
            StatusVoznje statusVoznje = (StatusVoznje) txtStatusVoznje.getSelectedItem();
            String trajanjeVoznje = txtTrajanjeVoznje.getText().trim();
            String brojKM = txtBrojKM.getText().trim();
            String musterija = txtMusterija.getText().trim();
            String vozac = txtVozac.getText().trim();


            Voznja porudzbina = new Voznja("false", id, vremePoruzbine, adresaPolaska, adresaDestinacije, String.valueOf(statusVoznje), trajanjeVoznje, brojKM, musterija, vozac);
            Preduzece.ucitaneVoznje.add(porudzbina);

            io.sacuvajVoznju(voznjaTXT);
            RezervacijaAplikacija.this.dispose();
            RezervacijaAplikacija.this.setVisible(false);
        });

        btnCancel.addActionListener(e -> {
            RezervacijaAplikacija.this.dispose();
            RezervacijaAplikacija.this.setVisible(false);
        });
    }

}


