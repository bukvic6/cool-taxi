package gui;


import cooltaxi.Main;
import cooltaxi.Preduzece;
import korisnici.Korisnik;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Loginprozor extends JFrame {

    private JLabel lblGreeting = new JLabel("Dobrodosli molimo da se prijavite");
    private JLabel lblUsername = new JLabel("Korisnicko ime");
    private JTextField txtKorisnickoIme = new JTextField(20);
    private JLabel lblPassword = new JLabel("Sifra");
    private JPasswordField pfPassword = new JPasswordField(20);
    private JButton btnOK = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    public Loginprozor(){
        setTitle("Prijava");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();
    }
    public void initGUI(){
        MigLayout mig = new MigLayout("wrap 2", "[][]","[]10[][]10[]");
        setLayout(mig);
        add(lblGreeting, "span 2");
        add(lblUsername);
        add(txtKorisnickoIme);
        add(lblPassword);
        add(pfPassword);
        add(new JLabel());
        add(btnOK, "split 2");
        add(btnCancel);

    }

   public void initActions(){
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loginprozor.this.dispose();
                Loginprozor.this.setVisible(false);
            }
        });
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String korisnickoIme = txtKorisnickoIme.getText().trim();
                String sifra = new String(pfPassword.getPassword()).trim();

                if(korisnickoIme.equals("") || sifra.equals("")) {
                    JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu", "greska", JOptionPane.WARNING_MESSAGE);
                }else {
                    Korisnik ulogovani  = (Korisnik) Preduzece.login(korisnickoIme, sifra);
                    if(ulogovani == null) {
                        JOptionPane.showMessageDialog(null, "Pogrešni login podaci.", "Greška", JOptionPane.WARNING_MESSAGE);
                    }else {
                        Loginprozor.this.dispose();
                        Loginprozor.this.setVisible(false);
                        GlavniProzor gp = new GlavniProzor();
                        gp.setVisible(true);
                    }
                }
            }
        });
    }
}
