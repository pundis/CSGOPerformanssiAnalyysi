package csgoperformanssianalyysi.kayttoliittyma;

import csgoperformanssianalyysi.logiikka.Kartta;
import csgoperformanssianalyysi.logiikka.PelattuKartta;
import csgoperformanssianalyysi.logiikka.Profiili;
import csgoperformanssianalyysi.logiikka.ProfiiliAnalyysi;
import csgoperformanssianalyysi.tietokanta.ProfiiliHallinta;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * valmistelee komponentit profiilinäkymälle
 * @author fuksi
 */
public class ProfiiliNakyma implements Nakyma {
    
    private ProfiiliAnalyysi profana;
    private Profiili prof;
    private double kdr;
    private ProfiiliNakymaKlikkaustenKuuntelija kk;
    private Container kontti;
    private NakymaHallitsija nh;
    
    public ProfiiliNakyma(ProfiiliAnalyysi profana, NakymaHallitsija nh) {
        this.profana = profana;
        this.prof = profana.getProfiili();
        this.kdr = profana.getKdr();
        this.nh = nh;
        this.kk = new ProfiiliNakymaKlikkaustenKuuntelija(this.prof, nh);
    }
    
    @Override
    public Container luoKomponentit() {     
        Container container = new Container();
        container.setLayout(new GridLayout(12, 12));
        container.setSize(800, 600);
        
        
        
        JPanel yleiskatsaus = luoYleisKatsaus();

        
        container.add(yleiskatsaus);
        
        
        container.add(new JLabel());
        JPanel pnl = new JPanel();

        container.add(pnl);
        
        JPanel karttakatsaustila = new JPanel(new GridLayout(1, 10));
        
        HashMap<Kartta, ArrayList<PelattuKartta>> kartatmapissa = prof.getKartatMapissa();
        
        for (Kartta kartta : kartatmapissa.keySet()) {
            JPanel kartanKatsaus = luoKartanKatsaus(kartta);
            karttakatsaustila.add(kartanKatsaus);
        }
        
        container.add(karttakatsaustila);
        
        container.add(new JPanel());
        
        JPanel laajennapelattuihin = new JPanel(new GridLayout(1, 10));
        
        for (Kartta kartta : prof.getKartatMapissa().keySet()) {
            JButton pelatut = new JButton(kartta.name());
            pelatut.addActionListener(kk);
            laajennapelattuihin.add(pelatut);
        }
        container.add(laajennapelattuihin);
        
        
        JPanel napit = new JPanel();
        JButton lisaysnappi = luoKartanLisaysNappula();
        JButton palaaProfiilinLataukseen = luoPaluuNappula();
        napit.add(lisaysnappi);
        napit.add(palaaProfiilinLataukseen);
        

        container.add(new JPanel());
        container.add(new JPanel());
        container.add(napit);
        
        this.kontti = container;
        
        return container;
    }
    
    public JPanel luoYleisKatsaus() {
        JPanel yleiskatsaus = new JPanel(new GridLayout(1, 5));
        JPanel yleiskatsaus2 = new JPanel (new GridLayout(1, 5));
        
        String pnimi = prof.getNimi();
        JLabel nimi = new JLabel(pnimi.substring(0, 1).toUpperCase() + pnimi.substring(1));
        yleiskatsaus.add(nimi);
        
        JLabel wl = new JLabel("Win/Loss/Tie");
        yleiskatsaus.add(wl);
        
        JLabel kd = new JLabel("K-D (KDRatio)");
        yleiskatsaus.add(kd);
        
        yleiskatsaus2.add(new JLabel());
        yleiskatsaus2.add(new JLabel(profana.getVoittoja() + "-" + profana.getHavioita() + "-" + profana.getTasapeleja()));
        yleiskatsaus2.add(new JLabel(profana.getTapotYht() + "-" + profana.getKuolematYht() + " (" + new DecimalFormat("#.##").format(profana.getKdr()) + ")"));
        
        JPanel yk = new JPanel(new GridLayout(2, 1));
        
        yk.add(yleiskatsaus);
        yk.add(yleiskatsaus2);
        
        return yk;
    }
    
    public JPanel luoKartanKatsaus(Kartta kartta) {
        JPanel kartankatsaus = new JPanel(new GridLayout(5, 1));
        
        JLabel kartannimi = new JLabel(kartta.name());
        kartannimi.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
        kartannimi.setForeground(Color.GRAY);
        kartankatsaus.add(kartannimi);
        
        JLabel kartanwl = new JLabel(profana.getKartanVoitot(kartta) + "-" + profana.getKartanHaviot(kartta) + "-" + profana.getKartanTasapelit(kartta));
        kartankatsaus.add(new JLabel());
        kartankatsaus.add(kartanwl);
        
        JLabel kartanKDR = new JLabel(profana.getKartanTapot(kartta) + "-" + profana.getKartanKuolemat(kartta) + " (" + new DecimalFormat("#.##").format(profana.getKartanKD(kartta)) + ")");
        if (profana.getKartanKD(kartta) > this.kdr) {
            kartanKDR.setForeground(Color.GREEN);
        }
        kartankatsaus.add(new JLabel());
        kartankatsaus.add(kartanKDR);
        
        return kartankatsaus;
    }
    
    public JButton luoPaluuNappula() {
        JButton paluu = new JButton("Vaihda profiilia");
        paluu.addActionListener(kk);
        return paluu;
    }
    
    public JButton luoKartanLisaysNappula() {
        JButton lisaakartta = new JButton("Lisää uusi kartta");
        lisaakartta.addActionListener(kk);
        return lisaakartta;
    }
   
   
}
