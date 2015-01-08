

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
    private NakymaHallitsija nh;
    private ProfiiliLatausNakymaKlikkaustenKuuntelija pnkk;
    
    public ProfiiliLatausNakyma(ArrayList<String> profiilit, NakymaHallitsija nh) throws Exception {
        this.profiilit = profiilit;
        this.nh = nh;
        this.pnkk = new ProfiiliLatausNakymaKlikkaustenKuuntelija(nh);
    }
    
    @Override
    public Container luoKomponentit() {
        Container container = new Container();
        ButtonGroup bg = new ButtonGroup();
        
        container.setBackground(Color.CYAN);
        GridLayout gl = new GridLayout(10, 1);
        container.setLayout(new GridLayout(10, 1));
        container.add(new JLabel("Valitse ladattava profiili"));
        
        for (String profiili : profiilit) {
            JRadioButton profiiliNappula = new JRadioButton(profiili);
            profiiliNappula.addActionListener(this.pnkk);
            bg.add(profiiliNappula);
            profiiliNappula.addActionListener(this.pnkk);
            container.add(profiiliNappula);
        }
        JButton uusiprofiilinappula = new JButton("Luo uusi profiili");
        uusiprofiilinappula.addActionListener(this.pnkk);
        container.add(uusiprofiilinappula);
        JButton suoritavalinta = new JButton("Lataa profiili");
        suoritavalinta.addActionListener(this.pnkk);
        
        container.add(suoritavalinta);
        return container;
        
    }
    
}
