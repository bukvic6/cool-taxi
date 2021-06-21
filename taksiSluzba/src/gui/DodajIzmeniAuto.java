package gui;

import automobili.Automobil;
import automobili.VrstaAutomobila;
import cooltaxi.io;
import cooltaxi.Preduzece;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cooltaxi.io.automobiliTXT;

public class DodajIzmeniAuto extends JFrame {
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
    private JComboBox<VrstaAutomobila> txtVrstaAutomobila = new JComboBox<VrstaAutomobila>(VrstaAutomobila.values());
    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private Automobil automobil;

    public DodajIzmeniAuto(Automobil automobil){
        this.automobil = automobil;
        if(automobil == null){
            setTitle("Dodavanje Automobila");
        }
        else {
            setTitle("Izmena podatka" + automobil.getRegistracija());
        }
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
        add(lblModel);
        add(txtModel);
        add(lblProizvodjac);
        add(txtProizvodjac);
        add(lblGodinaProizvodnje);
        add(txtGodinaProizvodnja);
        add(lblRegistracija);
        add(txtRegistracija);
        add(lblVrstaAutomobila);
        add(txtVrstaAutomobila);
        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }
    public void initActions() {
        btnOk.addActionListener(e -> {

            String BRVozila = txtBRVozila.getText().trim();
            String Model = txtModel.getText().trim();
            String Proizvodjac = txtProizvodjac.getText().trim();
            String GodinaPro = txtGodinaProizvodnja.getText().trim();
            String Registracija = txtRegistracija.getText().trim();
            VrstaAutomobila vrstaAutomobila = (VrstaAutomobila) txtVrstaAutomobila.getSelectedItem();
            if(automobil == null) {
                Automobil automobil = new Automobil(false, BRVozila, Model, Proizvodjac, GodinaPro, Registracija, vrstaAutomobila);
                Preduzece.ucitaniAutomobili.add(automobil);
            }else {
                automobil.setBrojTaksiVozila(BRVozila);
                automobil.setModel(Model);
                automobil.setProizvodjac(Proizvodjac);
                automobil.setGodinaProizvodnje(GodinaPro);
                automobil.setRegistracija(Registracija);
                automobil.setTipAutomobila(vrstaAutomobila);
            }
            io.sacuvajAutomobile(automobiliTXT);
            DodajIzmeniAuto.this.dispose();
            DodajIzmeniAuto.this.setVisible(false);
        });

        btnCancel.addActionListener(e -> {
            DodajIzmeniAuto.this.dispose();
            DodajIzmeniAuto.this.setVisible(false);
        });
    }

    private void popuniPolja() {
        txtBRVozila.setText(automobil.getBrojTaksiVozila());
        txtModel.setText(automobil.getModel());
        txtProizvodjac.setText(automobil.getProizvodjac());
        txtGodinaProizvodnja.setText(automobil.getGodinaProizvodnje());
        txtRegistracija.setText(automobil.getRegistracija());
        txtVrstaAutomobila.setSelectedItem(automobil.getTipAutomobila());
    }
}
