package gui;

import cooltaxi.Preduzece;
import korisnici.Vozaci;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.ArrayList;

public class PretragaVozaca extends JFrame {
    int BROJ = 20;
    private JLabel lblKorisnickoIme = new JLabel("Pretrazite vozaca po korisnickom imenu: ");
    private JTextField txtKorisnickoIme = new JTextField(BROJ);
    private JLabel lblPrezime = new JLabel("Pretrazite vozaca po prezimenu: ");
    private JTextField txtPrezime = new JTextField(BROJ);
    private JLabel lblPlata = new JLabel("Pretrazite vozaca po plati: ");
    private JFormattedTextField txtPlata = new JFormattedTextField();
    private JLabel lblAuto = new JLabel("Pretrazite vozaca po automobilu: ");
    private JTextField txtAuto = new JTextField(BROJ);
    private JButton btnPretraga = new JButton("Pretrazi vozace");

    public PretragaVozaca() {
        setTitle("Pretraga vozaca");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }

    public void initGUI(){
        MigLayout mig = new MigLayout("wrap 2", "[][]","[]10[][]10[]");
        setLayout(mig);
        add(lblKorisnickoIme);
        add(txtKorisnickoIme);
        add(lblPrezime);
        add(txtPrezime);
        add(lblPlata);
        add(txtPlata);
        txtPlata.setValue(Double.valueOf(0.0));
        txtPlata.setColumns(BROJ);
        add(lblAuto);
        add(txtAuto);
        add(btnPretraga);
    }

    private void initActions() {
        btnPretraga.addActionListener(e -> {
            ArrayList<Vozaci> pretrazenVozac = Preduzece.pronadjiVozaca(txtKorisnickoIme.getText(), txtPrezime.getText(),
                    Double.parseDouble(txtPlata.getText()), txtAuto.getText());
            System.out.println(pretrazenVozac);
            PronadjenVozac pronadjenVozac1 = new PronadjenVozac(pretrazenVozac);
            pronadjenVozac1.setVisible(true);
        });
    }
}
