package csgoperformanssianalyysi;

import csgoperformanssianalyysi.kayttoliittyma.GraafinenKayttoliittyma;
import csgoperformanssianalyysi.kayttoliittyma.NakymaHallitsija;
import csgoperformanssianalyysi.tietokanta.ProfiiliHallinta;

public class Paaohjelma {

    public static void main(String[] args) throws Exception {
        NakymaHallitsija nh = new NakymaHallitsija();
        GraafinenKayttoliittyma gkl = new GraafinenKayttoliittyma();
        gkl.setNakymaHallitsija(nh);
        nh.setGkl(gkl);
        
        ProfiiliHallinta ph = new ProfiiliHallinta();
        nh.setProfiilinHallinta(ph);
        nh.profiiliLatausNakyma();
        gkl.run();
    }
    
}
