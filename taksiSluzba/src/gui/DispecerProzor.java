package gui;


import cooltaxi.Preduzece;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DispecerProzor extends JFrame {
    private JMenuBar mainMenu = new JMenuBar();
    private JMenu dispecerMenu = new JMenu("Tabelarni prikaz");
    private JMenuItem vozaci = new JMenuItem("Vozaci");
    private JMenuItem automobili = new JMenuItem("Automobili");
    private JMenuItem voznje = new JMenuItem("Voznje");
    private DefaultTableModel tableModel;
    private JTable tabela;
    private JToolBar mainToolbar = new JToolBar();
    private JButton btnEdit = new JButton("                                   Izmeni podatke o taksi sluzbi                                   ");

    public DispecerProzor() {
        setTitle("Dispecerski meni");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu(){
        setJMenuBar(mainMenu);
        mainMenu.add(dispecerMenu);
        dispecerMenu.add(vozaci);
        dispecerMenu.add(automobili);
        dispecerMenu.add(voznje);
        mainToolbar.add(btnEdit);
        add(mainToolbar, BorderLayout.SOUTH);
        mainToolbar.setFloatable(false);

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
        vozaci.addActionListener(e -> {
            VozaciTabela KTabela = new VozaciTabela();
            KTabela.setVisible(true);
        });

        automobili.addActionListener(e -> {
            AutomobiliTabela ATabela = new AutomobiliTabela();
            ATabela.setVisible(true);
        });

        voznje.addActionListener(e -> {
            VoznjaTabela VTabela = new VoznjaTabela();
            VTabela.setVisible(true);
        });

        btnEdit.addActionListener(e -> {
            int selektovanRed = tabela.getSelectedRow();
            if(selektovanRed == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
            }else {
                String naziv = tableModel.getValueAt(selektovanRed, 2).toString();
                Preduzece preduzece = Preduzece.pronadjiPreduzece(naziv);
                if(preduzece == null) {
                    JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja automobila", "Greska", JOptionPane.WARNING_MESSAGE);
                }else {
                    IzmeniPreduzece IzmeniP = new IzmeniPreduzece(preduzece);
                    IzmeniP.setVisible(true);
                }
            }
        });
    }
}

