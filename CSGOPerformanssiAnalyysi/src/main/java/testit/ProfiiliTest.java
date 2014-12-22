package testit;

import csgoPerformanssiAnalyysi.logiikka.Kartta;
import csgoPerformanssiAnalyysi.logiikka.PelattuKartta;
import csgoPerformanssiAnalyysi.logiikka.Profiili;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProfiiliTest {
    
    public Profiili luoProfiiliJa5PelattuaKarttaa() {
        Profiili profiili = new Profiili("Arttu");
        profiili.lisaaKartta(new PelattuKartta(Kartta.dust2, 8, 16, 11, 23));
        profiili.lisaaKartta(new PelattuKartta(Kartta.nuke, 16, 8, 22, 20));
        profiili.lisaaKartta(new PelattuKartta(Kartta.cache, 16, 11, 31, 12));
        profiili.lisaaKartta(new PelattuKartta(Kartta.cache, 14, 16, 25, 25));
        profiili.lisaaKartta(new PelattuKartta(Kartta.cache, 16, 14, 16, 11));
        return profiili;
    }
    
    @Test
    public void kaikkienKarttaListassaOikeaMaaraPelattjaKarttoja() {
        Profiili profiili = luoProfiiliJa5PelattuaKarttaa();
        assertEquals(profiili.getKaikkiKartat().size(), 5);
    }
    
    @Test
    public void kaikkienKarttaListassaOikeaMaaraPelattujaKarttoja2() {
        Profiili arttu = new Profiili("Arttu");
        assertEquals(arttu.getKaikkiKartat().isEmpty(), true);
    }
    
    @Test
    public void oikeaMaaraCachePeleja() {
        Profiili profiili = luoProfiiliJa5PelattuaKarttaa();
        assertEquals(profiili.getKartatMapissa().get(Kartta.cache).size(), 3);
    }
    
    
}
