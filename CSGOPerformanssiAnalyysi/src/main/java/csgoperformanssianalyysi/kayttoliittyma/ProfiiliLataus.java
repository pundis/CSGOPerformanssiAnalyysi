//
//
//package csgoperformanssianalyysi.kayttoliittyma;
//
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.GridLayout;
//import java.util.ArrayList;
//import javax.swing.ButtonGroup;
//import javax.swing.JLabel;
//import javax.swing.JRadioButton;
//
//public class ProfiiliLataus {
//    
//
//    public Container luoKomponentit(ArrayList<String> profiilit) {
//        Container container = new Container();
//        ButtonGroup bg = new ButtonGroup();
//        KlikkaustenKuuntelija kk = new KlikkaustenKuuntelija();
//        
//        container.setBackground(Color.CYAN);
//        GridLayout gl = new GridLayout(10, 1);
//        container.setLayout(new GridLayout(10, 1));
//        container.add(new JLabel("Valitse ladattava profiili"));
//        
//        for (String profiili : profiilit) {
//            JRadioButton profiiliNappula = new JRadioButton(profiili);
//            profiiliNappula.addActionListener(kk);
//            bg.add(profiiliNappula);
//            container.add(profiiliNappula);
//        }
//        
//        return container;
//        
//    }
//}
