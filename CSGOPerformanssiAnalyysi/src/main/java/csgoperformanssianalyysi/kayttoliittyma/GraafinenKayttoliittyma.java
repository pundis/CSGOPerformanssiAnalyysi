package csgoperformanssianalyysi.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private ArrayList<String> profiilit;
    
    public GraafinenKayttoliittyma(ArrayList<String> profiilit) {
        this.profiilit = profiilit;
    }

    @Override
    public void run() {
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoProfiilinLatausNakyma(frame.getContentPane(), profiilit);
        
        frame.pack();
        frame.setVisible(true);
    }

    
    public void luoProfiilinLatausNakyma(Container container, ArrayList<String> profiilit) {
//        ProfiiliLataus pl = new ProfiiliLataus();
//        frame.setContentPane(pl.luoKomponentit(profiilit));
    }
    
}
