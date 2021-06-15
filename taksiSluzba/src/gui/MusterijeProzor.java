package gui;

import cooltaxi.Preduzece;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class MusterijeProzor extends JFrame {
    Preduzece CoolTaxi = new Preduzece();
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu korisniciMenu = new JMenu("Istorija voznje");
    private JMenuItem sopstveneVoznje = new JMenuItem("Istorija sopstvenih voznji");
    private JLabel nazivSLuzbe = new JLabel(CoolTaxi.getNaziv());
    private JLabel PIB = new JLabel(CoolTaxi.getPIB());
    private JLabel adresaSluzbe = new JLabel(CoolTaxi.getAdresa());
    private DefaultTableModel tableModel;
    private JTable tabela;
    private JToolBar mainToolbar = new JToolBar();
    private JButton btnApp = new JButton("Rezervisite voznju putem aplikacije");
    private JButton btnTel = new JButton("Rezervisite voznju putem telefona");

    public MusterijeProzor() {
        setTitle("Dobrodosli u Cool Taxi");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initMenu();
        initActions();
    }

    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(korisniciMenu);
        korisniciMenu.add(sopstveneVoznje);
        mainToolbar.add(btnApp);
        mainToolbar.add(btnTel);
        add(mainToolbar, BorderLayout.SOUTH);
        mainToolbar.setFloatable(false);
        add(nazivSLuzbe);
        add(PIB);
        add(adresaSluzbe);

        String [] zaglavlje = new String[]{"PIB", "Adresa", "Ime", "Cena starta voznje", "Cena po km"};
        Object[][] sadrzaj = new Object[Preduzece.ucitanoPreduzece.size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.ucitanoPreduzece.size(); i++){
            Preduzece preduzece = Preduzece.ucitanoPreduzece.get(i);
            sadrzaj[i][0] = preduzece.getPIB();
            sadrzaj[i][1] = preduzece.getAdresa();
            sadrzaj[i][2] = preduzece.getNaziv();
            sadrzaj[i][3] = preduzece.getCenaStartaVoznje();
            sadrzaj[i][4] = preduzece.getCenaPoKilometru();
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
        tabela = new JTable(tableModel);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);
    }
    

    private void initActions(){
        sopstveneVoznje.addActionListener(e -> {
            IstorijaVoznjeMusterije istorijaVoznje = new IstorijaVoznjeMusterije();
            istorijaVoznje.setVisible(true);
        });

        btnApp.addActionListener(e -> {
            RezervacijaAplikacija rezApp = new RezervacijaAplikacija();
            rezApp.setVisible(true);
        });

        btnTel.addActionListener(e -> {
            RezervacijaTelefonom rezTel = new RezervacijaTelefonom();
            rezTel.setVisible(true);
        });
    }
}
