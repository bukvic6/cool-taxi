package gui;

import cooltaxi.Preduzece;
import cooltaxi.io;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

import static cooltaxi.io.preduzeceTXT;

public class IzmeniPreduzece extends JFrame {

    private JLabel lblPIB = new JLabel("PIB");
    private JTextField txtPIB = new JTextField(20);
    private JLabel lblAdresa = new  JLabel("Adresa");
    private JTextField txtAdresa = new JTextField(20);
    private JLabel lblNaziv = new  JLabel("Naziv");
    private JTextField txtNaziv = new JTextField(20);
    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private Preduzece preduzece;

    public IzmeniPreduzece(Preduzece preduzece){
        this.preduzece = preduzece;
        setTitle("Izmena podatka o preduzecu");
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
        if(preduzece != null) {
            popuniPolja();
        }
        add(lblPIB);
        add(txtPIB);
        add(lblAdresa);
        add(txtAdresa);
        add(lblNaziv);
        add(txtNaziv);
        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    public void initActions() {
        btnOk.addActionListener(e -> {
            String PIB = txtPIB.getText().trim();
            String adresa = txtAdresa.getText().trim();
            String naziv = txtNaziv.getText().trim();
            preduzece.setPIB(PIB);
            preduzece.setAdresa(adresa);
            preduzece.setNaziv(naziv);

            io.sacuvajPreduzece(preduzeceTXT);
            IzmeniPreduzece.this.dispose();
            IzmeniPreduzece.this.setVisible(false);
        });
        btnCancel.addActionListener(e -> {
            IzmeniPreduzece.this.dispose();
            IzmeniPreduzece.this.setVisible(false);
        });
    }

    private void popuniPolja() {
        txtPIB.setText(preduzece.getPIB());
        txtAdresa.setText(preduzece.getAdresa());
        txtNaziv.setText(preduzece.getNaziv());
    }
}
