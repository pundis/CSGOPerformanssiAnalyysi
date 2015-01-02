package csgoperformanssianalyysi;

import csgoperformanssianalyysi.kayttoliittyma.GraafinenKayttoliittyma;
import csgoperformanssianalyysi.tietokanta.ProfiiliHallinta;
import java.util.ArrayList;

public class Paaohjelma {

    public static void main(String[] args) throws Exception {

        GraafinenKayttoliittyma gkl = new GraafinenKayttoliittyma();
        gkl.run();
        ProfiiliHallinta ph = new ProfiiliHallinta();
        ArrayList<String> profiilit = ph.getProfiilit();
        
    }
    
}
