
package csgoperformanssianalyysi.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProfiiliLatausNakymaKlikkaustenKuuntelija implements ActionListener {
    
    public ProfiiliLatausNakymaKlikkaustenKuuntelija() {
        
    }
    
    private String ladattava;
    private NakymaHallitsija nh;

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Lataa profiili")) {
            System.out.println(ladattava);
        } else  if (ae.getActionCommand().equals("Luo uusi profiili")) {
            ladattava = JOptionPane.showInputDialog("Profiilin nimi", null);
            System.out.println(ladattava);
        } else {
            ladattava = ae.getActionCommand();
        }
    }
    
    
    
}
