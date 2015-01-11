package csgoperformanssianalyysi.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame frame;
    private NakymaHallitsija nh;
    
    public GraafinenKayttoliittyma() {
    }
    
    public void setNakymaHallitsija(NakymaHallitsija nh) {
        this.nh = nh;
    }

    @Override
    public void run() {
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setContentPane(nh.nykyinenNakyma());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    
    /**
     * päivittää GUI:n parametristä saadulla containerilla ja piirtää uudestaan
     * @param container 
     */
    public void paivita(Container container) {
        frame.getContentPane().removeAll();
        frame.setContentPane(container);
        frame.pack();
    }

}
