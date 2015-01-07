package csgoperformanssianalyysi.logiikka;

import csgoperformanssianalyysi.logiikka.Kartta;
import csgoperformanssianalyysi.logiikka.PelattuKartta;
import csgoperformanssianalyysi.logiikka.Profiili;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProfiiliTest {
    
    public ProfiiliTest() {
    }
    
    public Profiili luoProfiiliJa5PelattuaKarttaa() throws Exception {
        Profiili profiili = new Profiili("Arttu");
        profiili.lisaaKartta(new PelattuKartta(Kartta.dust2, 8, 16, 11, 23));
        profiili.lisaaKartta(new PelattuKartta(Kartta.nuke, 16, 8, 22, 20));
        profiili.lisaaKartta(new PelattuKartta(Kartta.cache, 16, 11, 31, 12));
        profiili.lisaaKartta(new PelattuKartta(Kartta.cache, 14, 16, 25, 25));
        profiili.lisaaKartta(new PelattuKartta(Kartta.cache, 16, 14, 16, 11));
        return profiili;
    }
    
    
    @Test
    public void kaikkienKarttaListassaOikeaMaaraPelattjaKarttoja() throws Exception {
        Profiili profiili = luoProfiiliJa5PelattuaKarttaa();
        assertEquals(profiili.getKaikkiKartat().size(), 5);
    }
    
    @Test
    public void kaikkienKarttaListassaOikeaMaaraPelattujaKarttoja2() throws Exception {
        Profiili arttu = new Profiili("Arttu");
        assertEquals(arttu.getKaikkiKartat().isEmpty(), true);
    }
    
    @Test
    public void oikeaMaaraCachePeleja() throws Exception {
        Profiili profiili = luoProfiiliJa5PelattuaKarttaa();
        assertEquals(profiili.getKartatMapissa().get(Kartta.cache).size(), 3);
    }
    
    @Test
    public void oikeaMaaraDust2Peleja() throws Exception {
        Profiili profiili = luoProfiiliJa5PelattuaKarttaa();
        assertEquals(profiili.getKartatMapissa().get(Kartta.dust2).size(), 1);
    }
    
    @Test
    public void karttaKohtaisessaMapissaOikeaMaaraAvaimia() throws Exception {
        Profiili profiili = luoProfiiliJa5PelattuaKarttaa();
        HashMap<Kartta, ArrayList<PelattuKartta>> asd = profiili.getKartatMapissa();
        int i = 0;
        for (Kartta kartta : asd.keySet()) {
            i++;
        }
        assertEquals(3, i);
    }
    
    @Test
    public void getNimiToimii() throws Exception {
        Profiili profiili = new Profiili("Arttu");
        assertEquals(profiili.getNimi(), "Arttu");
    }
  
  
}
