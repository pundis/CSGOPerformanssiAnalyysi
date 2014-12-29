package csgoperformanssianalyysi;

import csgoperformanssianalyysi.logiikka.Kartta;
import csgoperformanssianalyysi.logiikka.PelattuKartta;
import csgoperformanssianalyysi.logiikka.Profiili;
import csgoperformanssianalyysi.logiikka.ProfiiliAnalyysi;
import csgoperformanssianalyysi.tietokanta.ProfiiliHallinta;

public class Paaohjelma {

    public static void main(String[] args) throws Exception {
//        Profiili arttu = new Profiili("Arttu");
//        
//        arttu.lisaaKartta(new PelattuKartta(Kartta.OTHER, 16, 12, 29, 16));
//        arttu.lisaaKartta(new PelattuKartta(Kartta.cache, 15, 15, 24, 22));
//        arttu.lisaaKartta(new PelattuKartta(Kartta.nuke, 16, 3, 27, 5));
//        arttu.lisaaKartta(new PelattuKartta(Kartta.nuke, 16, 11, 22, 11));
//        arttu.lisaaKartta(new PelattuKartta(Kartta.nuke, 11, 16, 16, 22));
//        
//        ProfiiliAnalyysi analysoija = new ProfiiliAnalyysi(arttu);
//        analysoija.luoYhtTapotKuolematVoitotHaviot();
        
//        System.out.println("KDR = " + analysoija.getKdr());
//        System.out.println("WL = " + analysoija.getVoittoja() + "-" + analysoija.getHavioita());
//        System.out.println("");
//        System.out.println("Nuken KDR = " + analysoija.getKartanKD(Kartta.nuke));
        ProfiiliHallinta ph = new ProfiiliHallinta();
        Profiili p = ph.lataaProfiili("Arttu".toLowerCase());
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(p);
        pa.luoYhtTapotKuolematVoitotHaviot();
        System.out.println("OVERALLKD: " + pa.getTapotYht() + ":" + pa.getKuolematYht());
        p.lisaaKartta(new PelattuKartta(Kartta.train, 16, 14, 33, 15));
        p.lisaaKartta(new PelattuKartta(Kartta.inferno, 12, 16, 20, 22));
        ph.tallennaProfiili(p);
    }
    
}
