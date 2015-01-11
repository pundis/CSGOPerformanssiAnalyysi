
package csgoperformanssianalyysi.kayttoliittyma;

import csgoperformanssianalyysi.logiikka.Profiili;
import csgoperformanssianalyysi.tietokanta.ProfiiliHallinta;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 * konfiguroi komennot profiililatausnäkymän napeille
 * @author fuksi
 */
public class ProfiiliLatausNakymaKlikkaustenKuuntelija implements ActionListener {
    
    private String ladattava;
    private NakymaHallitsija nh;
    private ProfiiliHallinta ph = new ProfiiliHallinta();
    
    public ProfiiliLatausNakymaKlikkaustenKuuntelija(NakymaHallitsija nh) throws Exception {
        this.nh = nh;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Lataa profiili")) {
            try {
                Profiili profiili = ph.lataaProfiili(ladattava);
                nh.profiiliNakyma(profiili.getNimi());
                Container container = nh.nykyinenNakyma();
                nh.paivitaGui(container);
            } catch (Exception ex) {
                System.out.println("Profiilin lataus ei onnistunut, tarkista tekstitiedostojen sijainti");
            }
        } else  if (ae.getActionCommand().equals("Luo uusi profiili")) {
            ladattava = JOptionPane.showInputDialog("Profiilin nimi", null);
            if (ladattava != null) {
                try {
                    Profiili profiili = new Profiili(ladattava);
                    nh.profiiliNakyma(profiili.getNimi());
                    Container container = nh.nykyinenNakyma();
                    nh.paivitaGui(container);
                } catch (Exception ex) {
                    System.out.println("Profiilin lataus ei onnistunut, tarkista tekstitiedostojen sijainti");
                }
            }
        } else {
            ladattava = ae.getActionCommand();
        }
    }
    
    
    
}
