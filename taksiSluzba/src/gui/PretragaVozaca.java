package gui;

import cooltaxi.Preduzece;
import korisnici.Korisnik;
import korisnici.Vozaci;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.ArrayList;

public class PretragaVozaca extends JFrame {
    int broj = 20;
    private JLabel lblKorisnickoIme = new JLabel("Pretrazite vozaca po korisnickom imenu: ");
    private JTextField txtKorisnickoIme = new JTextField(broj);
    private JLabel lblPrezime = new JLabel("Pretrazite vozaca po prezimenu: ");
    private JTextField txtPrezime = new JTextField(broj);
    private JLabel lblPlata = new JLabel("Pretrazite vozaca po plati: ");
    private JTextField txtPlata = new JTextField(broj);
    private JLabel lblAuto = new JLabel("Pretrazite vozaca po automobilu: ");
    private JTextField txtAuto = new JTextField(broj);
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
        add(lblAuto);
        add(txtAuto);
        add(btnPretraga);
    }

    private void initActions() {
        btnPretraga.addActionListener(e -> {
            if (txtKorisnickoIme.getText().length() != 0) {
                Vozaci pretrazeniKorisnik = Preduzece.pronadjiVozacaPoKorisnickomImenu(txtKorisnickoIme.getText());
                System.out.print(pretrazeniKorisnik);
            }
            if (txtPrezime.getText().length() != 0) {
                Vozaci pretrazeniKorisnik = Preduzece.pronadjiVozacaPoPrezimenu(txtPrezime.getText());
                System.out.print(pretrazeniKorisnik);
            }
            if (txtPlata.getText().length() != 0) {
                Vozaci pretrazeniKorisnik = Preduzece.pronadjiVozacaPoPlati(Double.parseDouble(txtPlata.getText()));
                System.out.print(pretrazeniKorisnik);
            }
            if (txtAuto.getText().length() != 0) {
                Vozaci pretrazeniKorisnik = Preduzece.pronadjiVozacaPoAutomobilu(txtAuto.getText());
                System.out.print(pretrazeniKorisnik);
            }
        });
    }
}
