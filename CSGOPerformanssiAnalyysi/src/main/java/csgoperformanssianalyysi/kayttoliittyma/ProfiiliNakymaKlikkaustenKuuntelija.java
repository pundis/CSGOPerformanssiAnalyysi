package csgoperformanssianalyysi.kayttoliittyma;

import csgoperformanssianalyysi.logiikka.Kartta;
import csgoperformanssianalyysi.logiikka.PelattuKartta;
import csgoperformanssianalyysi.logiikka.Profiili;
import csgoperformanssianalyysi.tietokanta.ProfiiliHallinta;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfiiliNakymaKlikkaustenKuuntelija implements ActionListener {
    
    private Profiili profiili;
    private ArrayList<PelattuKartta> pelatut;
    private NakymaHallitsija nh;
    
    public ProfiiliNakymaKlikkaustenKuuntelija(Profiili profiili, NakymaHallitsija nh) {
        this.profiili = profiili;
        this.pelatut = profiili.getKaikkiKartat();
        this.nh = nh;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("mirage")) {
            String viesti = "";
            for (PelattuKartta kartta : pelatut) {
                if (kartta.getKartta().name().equals("mirage")) {
                    viesti = viesti + kartta.toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, viesti);
        
        } else if (ae.getActionCommand().equals("nuke")) {
            String viesti = "";
            for (PelattuKartta kartta : pelatut) {
                if (kartta.getKartta().name().equals("nuke")) {
                    viesti = viesti + kartta.toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, viesti);
            
        } else if (ae.getActionCommand().equals("dust2")) {
            String viesti = "";
            for (PelattuKartta kartta : pelatut) {
                if (kartta.getKartta().name().equals("dust2")) {
                    viesti = viesti + kartta.toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, viesti);
        
        } else if (ae.getActionCommand().equals("OTHER")) {
            String viesti = "";
            for (PelattuKartta kartta : pelatut) {
                if (kartta.getKartta().name().equals("OTHER")) {
                    viesti = viesti + kartta.toString() + "\n";
                }
            }
         JOptionPane.showMessageDialog(null, viesti);
        
        } else if (ae.getActionCommand().equals("inferno")) {
            String viesti = "";
            for (PelattuKartta kartta : pelatut) {
                if (kartta.getKartta().name().equals("inferno")) {
                    viesti = viesti + kartta.toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, viesti);
            
        }else if (ae.getActionCommand().equals("cobble")) {
            String viesti = "";
            for (PelattuKartta kartta : pelatut) {
                if (kartta.getKartta().name().equals("cobble")) {
                    viesti = viesti + kartta.toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, viesti);
            
        } else if (ae.getActionCommand().equals("overpass")) {
            String viesti = "";
            for (PelattuKartta kartta : pelatut) {
                if (kartta.getKartta().name().equals("overpass")) {
                    viesti = viesti + kartta.toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, viesti);
            
        } else if (ae.getActionCommand().equals("train")) {
            String viesti = "";
            for (PelattuKartta kartta : pelatut) {
                if (kartta.getKartta().name().equals("train")) {
                    viesti = viesti + kartta.toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, viesti);
            
        } else if (ae.getActionCommand().equals("cache")) {
            String viesti = "";
            for (PelattuKartta kartta : pelatut) {
                if (kartta.getKartta().name().equals("cache")) {
                    viesti = viesti + kartta.toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, viesti);
        } else if (ae.getActionCommand().equals("Lisää uusi kartta")) {
            Kartta[] kartat = Kartta.values();
            JComboBox combo = new JComboBox(kartat);
            JTextField omatkierrokset = new JTextField();
            JTextField vihollisenkierrokset = new JTextField();
            JTextField omattapot = new JTextField();
            JTextField omatkuolemat = new JTextField();
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(combo);
            panel.add(new JLabel("Voitetut kierrokset"));
            panel.add(omatkierrokset);
            panel.add(new JLabel("Hävityt kierrokset"));
            panel.add(vihollisenkierrokset);
            panel.add(new JLabel("Omat tapot"));
            panel.add(omattapot);
            panel.add(new JLabel("Omat kuolemat"));
            panel.add(omatkuolemat);
            JOptionPane.showConfirmDialog(null, panel, "Lisää uusi kartta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            profiili.lisaaKartta(new PelattuKartta(Kartta.valueOf(combo.getSelectedItem().toString()), 
                    Integer.parseInt(omatkierrokset.getText()), Integer.parseInt(vihollisenkierrokset.getText()), 
                    Integer.parseInt(omattapot.getText()), Integer.parseInt(omatkuolemat.getText())));
            ProfiiliHallinta ph;
            try {
                ph = new ProfiiliHallinta();
                ph.tallennaProfiili(profiili);
                nh.profiiliNakyma(profiili.getNimi());
                nh.paivitaGui(nh.nykyinenNakyma());
            } catch (Exception ex) {
            }
        } else if (ae.getActionCommand().equals("Vaihda profiilia")) {
            try {
                nh.profiiliLatausNakyma();
                Container container = nh.nykyinenNakyma();
                nh.paivitaGui(container);
            } catch (Exception ex) {
            }
            
        }
    }
}
