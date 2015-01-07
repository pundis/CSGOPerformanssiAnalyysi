

package csgoperformanssianalyysi.kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class ProfiiliLatausNakyma implements Nakyma {

    private ArrayList<String> profiilit;

    public ProfiiliLatausNakyma(ArrayList<String> profiilit) {
        this.profiilit = profiilit;
    }
    
    @Override
    public Container luoKomponentit() {
        Container container = new Container();
        ButtonGroup bg = new ButtonGroup();
        ProfiiliLatausNakymaKlikkaustenKuuntelija kk = new ProfiiliLatausNakymaKlikkaustenKuuntelija();
        
        container.setBackground(Color.CYAN);
        GridLayout gl = new GridLayout(10, 1);
        container.setLayout(new GridLayout(10, 1));
        container.add(new JLabel("Valitse ladattava profiili"));
        
        for (String profiili : profiilit) {
            JRadioButton profiiliNappula = new JRadioButton(profiili);
            profiiliNappula.addActionListener(kk);
            bg.add(profiiliNappula);
            profiiliNappula.addActionListener(kk);
            container.add(profiiliNappula);
        }
        JButton uusiprofiilinappula = new JButton("Luo uusi profiili");
        uusiprofiilinappula.addActionListener(kk);
        container.add(uusiprofiilinappula);
        JButton suoritavalinta = new JButton("Lataa profiili");
        suoritavalinta.addActionListener(kk);
        
        container.add(suoritavalinta);
        return container;
        
    }
    
}
