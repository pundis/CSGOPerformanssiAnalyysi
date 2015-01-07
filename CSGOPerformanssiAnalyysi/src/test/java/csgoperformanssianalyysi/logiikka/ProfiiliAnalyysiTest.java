package csgoperformanssianalyysi.logiikka;



import csgoperformanssianalyysi.logiikka.Kartta;
import csgoperformanssianalyysi.logiikka.PelattuKartta;
import csgoperformanssianalyysi.logiikka.Profiili;
import csgoperformanssianalyysi.logiikka.ProfiiliAnalyysi;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class ProfiiliAnalyysiTest {
    
    private Profiili profiili;
    
    
    public ProfiiliAnalyysiTest() {
    }
    
    @Test
    public void oikeaMaaraOverallTappoja() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(pa.getTapotYht(), 165);
    }
    
    @Test
    public void oikeaMaaraOverallTappoja2() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.OTHER, 15, 15, 33, 22));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(pa.getTapotYht(), 198);
    }
    
    @Test
    public void oikeaMaaraOverallKuolemia() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(pa.getKuolematYht(), 100);
    }
    
    @Test
    public void oikeaMaaraOverallKuolemia2() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.OTHER, 16, 11, 22, 15));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(pa.getKuolematYht(), 115);
    }
    
    @Test
    public void oikeaMaaraOverallVoittoja() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(pa.getVoittoja(), 4);
    }
    
    @Test
    public void oikeaMaaraOverallVoittoja2() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.nuke, 16, 14, 31, 11));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(pa.getVoittoja(), 5);
    }
    
    @Test
    public void oikeaMaaraOverallVoittoja3() throws Exception {
        Profiili asd = new Profiili("Keke Rosberg");
        asd.lisaaKartta(new PelattuKartta(Kartta.OTHER, 15, 15, 15, 15));
        asd.lisaaKartta(new PelattuKartta(Kartta.OTHER, 4, 16, 2, 16));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(asd);
        assertEquals(pa.getVoittoja(), 0);
    }
    
    @Test
    public void oikeaMaaraOverallHavioita() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(pa.getHavioita(), 2);
    }
    
    @Test
    public void oikeaMaaraOverallHavioita2() throws Exception {
        Profiili keke = new Profiili("Keke");
        keke.lisaaKartta(new PelattuKartta(Kartta.OTHER, 10, 16, 19, 19));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(keke);
        assertEquals(pa.getVoittoja(), 0);
    }
    
    @Test
    public void oikeaMaaraOverallHavioita3() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.inferno, 16, 11, 22, 19));
        profiili.lisaaKartta(new PelattuKartta(Kartta.mirage, 2, 16, 15, 15));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(pa.getHavioita(), 3);
    }
    
    @Test
    public void oikeaMaaraOverallTasapeleja() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(pa.getTasapeleja(), 0);
    }
 
    @Test
    public void oikeaMaaraOverallTasapeleja2() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.train, 15, 15, 16, 12));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(pa.getTasapeleja(), 1);
    }
    
    @Test
    public void oikeaOverallKdr() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(1.65, pa.getKdr(), 3);
    }
    
    @Test
    public void oikeaOverallKdr2() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.mirage, 15, 15, 30, 20));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(1.625, pa.getKdr(), 3);
    }
    
    @Test
    public void oikeaMaaraCobblestoneTappoja() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(55, pa.getKartanTapot(Kartta.cobble));
    }
    
    @Test
    public void oikeaMaaraCobblestoneTappoja2() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.cobble, 15, 15, 30, 15));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(85, pa.getKartanTapot(Kartta.cobble));
    }
    
    @Test
    public void oikeaMaaraCobblestoneKuolemia() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(35, pa.getKartanKuolemat(Kartta.cobble));
    }
    
    @Test
    public void oikeaMaaraCobblestoneKuolemia2() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.cobble, 15, 15, 25, 20));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(55, pa.getKartanKuolemat(Kartta.cobble));
    }
    
    @Test
    public void oikeaCobblestoneKdr() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(1.571, pa.getKartanKD(Kartta.cobble), 3);
    }
    
    @Test
    public void oikeaCobblestoneKdr2() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.cobble, 15, 15, 30, 10));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(1.888, pa.getKartanKD(Kartta.cobble), 3);
    }
    
    @Test
    public void oikeaMaaraTrainTappojaKunPelattujaJuniaNolla() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(0, pa.getKartanTapot(Kartta.train));
    }
    
    @Test
    public void oikeaMaaraTrainVoittojaKunPelattujaJuniaNolla() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(0, pa.getKartanVoitot(Kartta.train));
    }
    
    @Test
    public void oikeaMaaraCobblestoneVoittoja() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(1, pa.getKartanVoitot(Kartta.cobble));
    }
    
    @Test
    public void oikeaMaaraCobblestoneVoittoja2() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.cobble, 16, 14, 26, 24));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(2, pa.getKartanVoitot(Kartta.cobble));
    }
    
    @Test
    public void oikeaMaaraCobblestoneHavioita() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(1, pa.getKartanHaviot(Kartta.cobble));
    }
    
    @Test
    public void oikeaMaaraCobblestoneHavioita2() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.cobble, 14, 16, 25, 25));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(2, pa.getKartanHaviot(Kartta.cobble));
    }
    
    @Test
    public void oikeaMaaraDust2HavioitaKunPelattujaHiekkojaNolla() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(0, pa.getKartanHaviot(Kartta.dust2));
    }
    
    @Test
    public void oikeaMaaraCobblestoneTasapelejaKunTasureitaNolla() {
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(0, pa.getKartanTasapelit(Kartta.cobble));
    }
    
    @Test
    public void oikeaMaaraCobblestoneTasapeleja() {
        profiili.lisaaKartta(new PelattuKartta(Kartta.cobble, 15, 15, 33, 19));
        ProfiiliAnalyysi pa = new ProfiiliAnalyysi(profiili);
        assertEquals(1, pa.getKartanTasapelit(Kartta.cobble));
    }
    
    @Test
    public void overallStatistiikkaPaivitysPaivittaaOliomuuttujatOikein() {
        
    }
 
    @Before
    public void setUp() throws Exception {
        profiili = new Profiili("Arttu");
        profiili.lisaaKartta(new PelattuKartta(Kartta.OTHER, 16, 11, 40, 20));
        profiili.lisaaKartta(new PelattuKartta(Kartta.nuke, 10, 16, 20, 20));
        profiili.lisaaKartta(new PelattuKartta(Kartta.cobble, 16, 14, 40, 20));
        profiili.lisaaKartta(new PelattuKartta(Kartta.cobble, 2, 16, 15, 15));
        profiili.lisaaKartta(new PelattuKartta(Kartta.mirage, 16, 5, 25, 10));
        profiili.lisaaKartta(new PelattuKartta(Kartta.OTHER, 16, 12, 25, 15));
    }
    
    

}
