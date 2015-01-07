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
    private NakymaHallitsija nh;
    
    public GraafinenKayttoliittyma(NakymaHallitsija nh) {
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

}
