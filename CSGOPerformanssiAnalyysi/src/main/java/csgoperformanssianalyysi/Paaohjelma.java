package csgoperformanssianalyysi;

import csgoperformanssianalyysi.kayttoliittyma.GraafinenKayttoliittyma;
import csgoperformanssianalyysi.kayttoliittyma.NakymaHallitsija;
import csgoperformanssianalyysi.tietokanta.ProfiiliHallinta;

public class Paaohjelma {

    public static void main(String[] args) throws Exception {
        ProfiiliHallinta ph = new ProfiiliHallinta();
        NakymaHallitsija nh = new NakymaHallitsija(ph);
        nh.profiiliNakyma("Arttu");
        
        GraafinenKayttoliittyma gkl = new GraafinenKayttoliittyma(nh);
        gkl.run();
    }
    
}
