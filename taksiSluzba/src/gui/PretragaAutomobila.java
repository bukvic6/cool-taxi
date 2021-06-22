package gui;

import automobili.Automobil;
import cooltaxi.Preduzece;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.ArrayList;

public class PretragaAutomobila extends JFrame {

    int BROJ = 20;
    private JLabel lblModel = new JLabel("Pretrazite automobil po modelu: ");
    private JTextField txtModel = new JTextField(BROJ);
    private JLabel lblProizvodjac = new JLabel("Pretrazite automobil po proizvodjacu: ");
    private JTextField txtProizvodjac = new JTextField(BROJ);
    private JLabel lblGodinaProiz = new JLabel("Pretrazite automobil po godini proizvodnje: ");
    private JTextField txtGodinaProiz = new JTextField(BROJ);
    private JLabel lblRegistracija = new JLabel("Pretrazite automobil po registraciji: ");
    private JTextField txtRegistracija = new JTextField(BROJ);
    private JLabel lblTaxiBroj = new JLabel("Pretrazite automobil po broju: ");
    private JTextField txtTaxiBroj = new JTextField(BROJ);
    private JButton btnPretraga = new JButton("Pretrazi automobile");

    public PretragaAutomobila() {
        setTitle("Pretraga automobila");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    public void initGUI(){
        MigLayout mig = new MigLayout("wrap 2", "[][]","[]10[][]10[]");
        setLayout(mig);
        add(lblModel);
        add(txtModel);
        add(lblProizvodjac);
        add(txtProizvodjac);
        add(lblGodinaProiz);
        add(txtGodinaProiz);
        add(lblRegistracija);
        add(txtRegistracija);
        add(lblTaxiBroj);
        add(txtTaxiBroj);
        add(btnPretraga);
    }

    private void initActions() {
        btnPretraga.addActionListener(e -> {
            ArrayList<Automobil> pretrazenAutomobil = Preduzece.pronadjiAutomobil(txtModel.getText(),
                    txtProizvodjac.getText(),txtGodinaProiz.getText(), txtRegistracija.getText(),txtTaxiBroj.getText());
            PronadjenAutomobil pronadjenAutomobil1 = new PronadjenAutomobil(pretrazenAutomobil);
            pronadjenAutomobil1.setVisible(true);
        });
    }
}