package gui;

import automobili.Automobil;
import cooltaxi.Preduzece;
import cooltaxi.io;
import korisnici.Pol;
import korisnici.Vozaci;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

import static cooltaxi.io.automobiliTXT;
import static cooltaxi.io.korisniciTXT;

public class DodajIzmeniVozaca extends JFrame {
    private JLabel lblJMBG = new JLabel("JMBG");
    private JTextField txtJMBG = new JTextField(20);
    private JLabel lblkorisnickoIme = new  JLabel("Korisnicko ime");
    private JTextField txKorisnickoIme = new JTextField(20);
    private JLabel lblLozinka = new  JLabel("Lozinka");
    private JTextField txtLozinka = new JTextField(20);
    private JLabel lblIme = new JLabel("Ime");
    private JTextField txtIme = new JTextField(20);
    private JLabel lblPrezime = new JLabel("Prezime");
    private JTextField txtPrezime = new JTextField(20);
    private JLabel lblAdresa = new JLabel("Adresa");
    private JTextField txtAdresa = new JTextField(20);
    private JLabel lblPol = new JLabel("Pol");
    private JComboBox<Pol> txtPol = new JComboBox<Pol>(Pol.values());
    private JLabel lblBrojTelefona = new JLabel("Broj telefona");
    private JTextField txtBrojTelefona = new JTextField(20);
    private JLabel lblBrojClanskeKarte = new JLabel("Broj clanske karte");
    private JTextField txtBrojClanskeKarte = new JTextField(20);
    private JLabel lblPlata = new JLabel("Plata");
    private JTextField txtPlata = new JTextField(20);
    private JLabel lblTaksiVozilo = new JLabel("Taksi vozilo");
    private JComboBox<String> txtTaksi = new JComboBox<String>();
    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private Vozaci vozac;

    public DodajIzmeniVozaca(Vozaci vozac){
        this.vozac = vozac;
        if(vozac == null){
            setTitle("Dodavanje vozaca");
        }
        else {
            setTitle("Izmena podatka " + vozac.getKorisnickoIme());
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

        for (Automobil automobil: Preduzece.ucitaniAutomobili){
            txtTaksi.addItem(automobil.getBrojTaksiVozila());
        }

        if(vozac != null) {
            popuniPolja();
        }

        add(lblJMBG);
        add(txtJMBG);
        add(lblkorisnickoIme);
        add(txKorisnickoIme);
        add(lblLozinka);
        add(txtLozinka);
        add(lblIme);
        add(txtIme);
        add(lblPrezime);
        add(txtPrezime);
        add(lblAdresa);
        add(txtAdresa);
        add(lblPol);
        add(txtPol);
        add(lblBrojTelefona);
        add(txtBrojTelefona);
        add(lblBrojClanskeKarte);
        add(txtBrojClanskeKarte);
        add(lblPlata);
        add(txtPlata);
        add(lblTaksiVozilo);
        add(txtTaksi);
        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    public void initActions() {
        btnOk.addActionListener(e -> {

            String jmbg = txtJMBG.getText().trim();
            String korisnickoIme = txKorisnickoIme.getText().trim();
            String lozinka = txtLozinka.getText().trim();
            String ime = txtIme.getText().trim();
            String prezime = txtPrezime.getText().trim();
            String adresa = txtAdresa.getText().trim();
            Pol pol = (Pol) txtPol.getSelectedItem();
            String brojTelefona = txtBrojTelefona.getText().trim();
            String brojClanskeKarte = txtBrojClanskeKarte.getText().trim();
            String plata = txtPlata.getText().trim();
            String brojTaksija = txtTaksi.getSelectedItem().toString();

            if(vozac == null) {
                Vozaci vozac = new Vozaci("false", "vozac", jmbg, korisnickoIme, lozinka, ime, prezime,
                        adresa, String.valueOf(pol), brojTelefona, brojClanskeKarte, plata, brojTaksija);
                Preduzece.ucitaniKorisnici.add(vozac);
            }else {
                vozac.setJmbg(jmbg);
                vozac.setKorisnickoIme(korisnickoIme);
                vozac.setLozinka(lozinka);
                vozac.setIme(ime);
                vozac.setPrezime(prezime);
                vozac.setAdresa(adresa);
                vozac.setPol(pol);
                vozac.setBrojTelefona(brojTelefona);
                vozac.setBrojClanskeKarte(brojClanskeKarte);
                vozac.setPlata(Double.parseDouble(plata));
                vozac.setTaksiBroj(brojTaksija);
            }
            io.sacuvajKorisnike(korisniciTXT);
            DodajIzmeniVozaca.this.dispose();
            DodajIzmeniVozaca.this.setVisible(false);
        });

        btnCancel.addActionListener(e -> {
            DodajIzmeniVozaca.this.dispose();
            DodajIzmeniVozaca.this.setVisible(false);
        });
    }

    private void popuniPolja() {
        txtJMBG.setText(vozac.getJmbg());
        txKorisnickoIme.setText(vozac.getKorisnickoIme());
        txtLozinka.setText(vozac.getLozinka());
        txtIme.setText(vozac.getIme());
        txtPrezime.setText(vozac.getPrezime());
        txtAdresa.setText(vozac.getAdresa());
        txtPol.setSelectedItem(vozac.getPol());
        txtBrojTelefona.setText(vozac.getBrojTelefona());
        txtBrojClanskeKarte.setText(vozac.getBrojClanskeKarte());
        txtPlata.setText(String.valueOf(vozac.getPlata()));
        txtTaksi.setSelectedItem(vozac.getTaksiBroj());
    }
}
