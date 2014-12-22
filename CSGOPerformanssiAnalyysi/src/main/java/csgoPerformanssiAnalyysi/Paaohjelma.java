
package csgoPerformanssiAnalyysi;

import csgoPerformanssiAnalyysi.logiikka.PelattuKartta;
import csgoPerformanssiAnalyysi.logiikka.Kartta;
import csgoPerformanssiAnalyysi.logiikka.Profiili;
import csgoPerformanssiAnalyysi.logiikka.ProfiiliAnalyysi;

public class Paaohjelma {

    public static void main(String[] args) {
        Profiili arttu = new Profiili("Arttu");
        
        arttu.lisaaKartta(new PelattuKartta(Kartta.OTHER, 16, 12, 29, 16));
        arttu.lisaaKartta(new PelattuKartta(Kartta.cache, 15, 15, 24, 22));
        arttu.lisaaKartta(new PelattuKartta(Kartta.nuke, 16, 3, 27, 5));
        arttu.lisaaKartta(new PelattuKartta(Kartta.nuke, 16, 11, 22, 11));
        arttu.lisaaKartta(new PelattuKartta(Kartta.nuke, 11, 16, 16, 22));
        
        ProfiiliAnalyysi analysoija = new ProfiiliAnalyysi(arttu);
        analysoija.luoYhtTapotKuolematVoitotHaviot();
        
        System.out.println("KDR = " + analysoija.getKdr());
        System.out.println("WL = " + analysoija.getVoittoja() + "-" + analysoija.getHavioita());
        System.out.println("");
        System.out.println("Nuken KDR = " + analysoija.getKartanKD(Kartta.nuke));
    }
    
}
