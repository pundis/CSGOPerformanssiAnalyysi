package csgoperformanssianalyysi.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    

    @Override
    public void run() {
        frame = new JFrame("CSGO Performanssi seuranta");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        
    }
    
    private void luoProfiilinLatausNakyma(ArrayList<String> profiilit) {
        ProfiilinValinta pv = new ProfiilinValinta();
        Container container = pv.getProfiilinLatausNakyma(profiilit);
        frame.pack();
        frame.setVisible(true);
        
    }
    
}
