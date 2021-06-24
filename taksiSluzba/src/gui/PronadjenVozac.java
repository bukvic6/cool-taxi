package gui;

import automobili.Automobil;
import cooltaxi.Preduzece;
import cooltaxi.io;
import korisnici.Korisnik;
import korisnici.Vozaci;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

import static cooltaxi.io.automobiliTXT;
import static cooltaxi.io.korisniciTXT;

public class PronadjenVozac extends JFrame {
    private ArrayList<Vozaci> pronadjenVozac = new ArrayList<>();
    private JToolBar mainToolbar = new JToolBar();
    private JButton btnEdit = new JButton("Izmeni");
    private JButton btnDelete = new JButton("Obrisi");
    private DefaultTableModel tableModel;
    private JTable tabela;

    public PronadjenVozac(ArrayList<Vozaci> pronadjenVozac){
        this.pronadjenVozac = pronadjenVozac;
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        mainToolbar.add(btnEdit);
        mainToolbar.add(btnDelete);
        add(mainToolbar, BorderLayout.NORTH);
        mainToolbar.setFloatable(false);
        String[] zaglavlje = new String[]{"JMBG", "Korisnicko ime", "Ime", "Prezime", "Adresa", "Pol", "Broj telefona", "Broj clanske karte", "Plata", "Vozilo"};
        Object[][] sadrzaj = new Object[this.pronadjenVozac.size()][zaglavlje.length];

        for (int i = 0; i < this.pronadjenVozac.size(); i++) {
            Korisnik korisnik = this.pronadjenVozac.get(i);
            sadrzaj[i][0] = korisnik.getJmbg();
            sadrzaj[i][1] = korisnik.getKorisnickoIme();
            sadrzaj[i][2] = korisnik.getIme();
            sadrzaj[i][3] = korisnik.getPrezime();
            sadrzaj[i][4] = korisnik.getAdresa();
            sadrzaj[i][5] = korisnik.getPol();
            sadrzaj[i][6] = korisnik.getBrojTelefona();
            sadrzaj[i][7] = ((Vozaci) korisnik).getBrojClanskeKarte();
            sadrzaj[i][8] = ((Vozaci) korisnik).getPlata();
            sadrzaj[i][9] = ((Vozaci) korisnik).getTaksiBroj();
        }

        tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
        tabela = new JTable(tableModel);
        TableRowSorter<TableModel> sortiranje = new TableRowSorter<TableModel>(tabela.getModel());
        tabela.setRowSorter(sortiranje);
        tabela.setRowSelectionAllowed(true);
        tabela.setColumnSelectionAllowed(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setDefaultEditor(Object.class, null);
        tabela.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions(){
        btnDelete.addActionListener(e -> {
            int selektovanRed = tabela.getSelectedRow();
            if (selektovanRed == -1) {
                JOptionPane.showMessageDialog(null, "Odaberite red u tabeli",
                        "Greska", JOptionPane.WARNING_MESSAGE);
            } else {
                String korisnickoIme = tableModel.getValueAt(selektovanRed, 1).toString();
                Korisnik korisnik = Preduzece.pronadjiKorisnika(korisnickoIme);

                int izbor = JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da zelite da obrisete korisnika?",
                        korisnickoIme + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
                if (izbor == JOptionPane.YES_OPTION) {
                    korisnik.setObrisan(true);
                    tableModel.removeRow(selektovanRed);
                    io.sacuvajKorisnike(korisniciTXT);
                }
            }
        });

        btnEdit.addActionListener(e -> {
            int selektovanRed = tabela.getSelectedRow();
            if(selektovanRed == -1) {
                JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.",
                        "Greska", JOptionPane.WARNING_MESSAGE);
            }else {
                String korisnickoIme = tableModel.getValueAt(selektovanRed, 1).toString();
                Vozaci vozac = (Vozaci) Preduzece.pronadjiKorisnika(korisnickoIme);
                if(vozac == null) {
                    JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja automobila",
                            "Greska", JOptionPane.WARNING_MESSAGE);
                }else {
                    DodajIzmeniVozaca izmenaVozaca = new DodajIzmeniVozaca(vozac);
                    izmenaVozaca.setVisible(true);
                }
            }
        });
    }
}