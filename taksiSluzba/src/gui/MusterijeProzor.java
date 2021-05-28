package gui;

import cooltaxi.Main;
import cooltaxi.Preduzece;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class MusterijeProzor extends JFrame {
    Preduzece CoolTaxi = new Preduzece();
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu korisniciMenu = new JMenu("Istorija voznje");
    private JLabel nazivSLuzbe = new JLabel(CoolTaxi.getNaziv());
    private JLabel PIB = new JLabel(CoolTaxi.getPIB());
    private JLabel adresaSluzbe = new JLabel(CoolTaxi.getAdresa());
    private DefaultTableModel tableModel;
    private JTable tabela;



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
        add(nazivSLuzbe);
        add(PIB);
        add(adresaSluzbe);

        String [] zaglavlje = new String[]{"PIB", "Adresa","Ime"};
        Object[][] sadrzaj = new Object[Preduzece.ucitanoPreduzece.size()][zaglavlje.length];

        for (int i = 0; i < Preduzece.ucitanoPreduzece.size(); i++){
            Preduzece preduzece = Preduzece.ucitanoPreduzece.get(i);
            sadrzaj[i][0] = preduzece.getPIB();
            sadrzaj[i][1] = preduzece.getAdresa();
            sadrzaj[i][2] = preduzece.getNaziv();
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
        korisniciMenu.addActionListener(e -> {
        });
    }
}
