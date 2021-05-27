package gui;

import automobili.Automobil;
import cooltaxi.io;
import cooltaxi.Preduzece;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cooltaxi.io.automobiliTXT;



public class DodajAuto extends JFrame {
    private JLabel lblBrojVozila = new JLabel("Broj vozila");
    private JTextField txtBRVozila = new JTextField(20);
    private JLabel lblModel = new  JLabel("Model");
    private JTextField txtModel = new JTextField(20);
    private JLabel lblProizvodjac = new  JLabel("Proizvodjac");
    private JTextField txtProizvodjac = new JTextField(20);
    private JLabel lblGodinaProizvodnje = new JLabel("Godina proizvodnje");
    private JTextField txtGodinaProizvodnja = new JTextField(20);
    private JLabel lblRegistracija = new JLabel("Registracija");
    private JTextField txtRegistracija = new JTextField(20);
    private JLabel lblVrstaAutomobila = new JLabel("Vrsta Automobila");
    private JTextField txtVrstaAutomobila = new JTextField(20);
    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private Automobil automobil;

    public DodajAuto(){
        if(automobil == null){
            setTitle("Dodavanje Automobila");
        }
//        else {
//            setTitle("Izmena podatka -" + automobil.getRegistracija());
//        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        setResizable(false);
        pack();
    }
    public void initGUI(){
        MigLayout layout = new MigLayout("wrap 2", "[][]","[][][][][][]20[]");
        setLayout(layout);
        if(automobil != null) {
            popuniPolja();

        }
        add(lblBrojVozila);
        add(txtBRVozila);
        add(lblGodinaProizvodnje);
        add(txtGodinaProizvodnja);
        add(lblModel);
        add(txtModel);
        add(lblProizvodjac);
        add(txtProizvodjac);
        add(lblVrstaAutomobila);
        add(txtVrstaAutomobila);
        add(lblRegistracija);
        add(txtRegistracija);
        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }
    public void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Obrisan = "false";
                String BRVozila = txtBRVozila.getText().trim();
                String GodinaPro = txtGodinaProizvodnja.getText().trim();
                String Proizvodjac = txtProizvodjac.getText().trim();
                String Model = txtModel.getText().trim();
                String VrstaAuta = txtVrstaAutomobila.getText().trim();
                String Registracija = txtRegistracija.getText().trim();
                if(automobil == null) {
//                    OVDE TREBA DODATI
                }
                io.sacuvajAutomobile(automobiliTXT);
                DodajAuto.this.dispose();
                DodajAuto.this.setVisible(false);

            }
        });

    }
    private void popuniPolja() {
        txtBRVozila.setText(automobil.getBrojTaksiVozila());
        txtGodinaProizvodnja.setText(automobil.getGodinaProizvodnje());
        txtModel.setText(automobil.getModel());
        txtRegistracija.setText(automobil.getRegistracija());
        txtVrstaAutomobila.setText(String.valueOf(automobil.getTipAutomobila()));

    }




}
