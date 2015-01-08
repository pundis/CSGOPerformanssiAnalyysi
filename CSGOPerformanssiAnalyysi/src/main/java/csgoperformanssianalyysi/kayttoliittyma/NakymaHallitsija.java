package csgoperformanssianalyysi.kayttoliittyma;

import csgoperformanssianalyysi.logiikka.Profiili;
import csgoperformanssianalyysi.logiikka.ProfiiliAnalyysi;
import csgoperformanssianalyysi.tietokanta.ProfiiliHallinta;
import java.awt.Container;
import java.util.ArrayList;


/**
 * hallinnoi graafista käyttöliittymää kertomalla sille mikä näkymä piirretään
 * @author fuksi
 */

public class NakymaHallitsija {

    private ProfiiliHallinta profhal;
    private Container nykyinengrafiikka;
    private String nykyinenProfiili;
    private GraafinenKayttoliittyma gkl;
    
    public NakymaHallitsija() {
    }
    
    public void setProfiilinHallinta(ProfiiliHallinta profhal) {
        this.profhal = profhal;
    }
    
    public void setGkl(GraafinenKayttoliittyma gkl) {
        this.gkl = gkl;
    }
    
    /**
     * valmistele profiililatausnäkymän
     * @throws Exception 
     */
    public void profiiliLatausNakyma() throws Exception {
        ArrayList<String> profiilit = profhal.getProfiilit();
        System.out.println(profiilit);
        
        ProfiiliLatausNakyma pln = new ProfiiliLatausNakyma(profiilit, this);
        nykyinengrafiikka = pln.luoKomponentit();
    }
    
    public Container nykyinenNakyma() {
        return this.nykyinengrafiikka;
    }
    
    /**
     * valmistelee profiilinäkymän parametrinä syötetystä profiilinimestä
     * @param profiilinNimi
     * @throws Exception 
     */
    public void profiiliNakyma(String profiilinNimi) throws Exception {
        Profiili profiili = profhal.lataaProfiili(profiilinNimi);
        ProfiiliAnalyysi profana = new ProfiiliAnalyysi(profiili);
        
        ProfiiliNakyma pn = new ProfiiliNakyma(profana, this);
        this.nykyinengrafiikka = pn.luoKomponentit();
    }
    
    
    /**
     * päivittää graafiselle käyttöliittymälle sen hetkisen grafiikan
     * @param container 
     */
    public void paivitaGui(Container container) {
        gkl.paivita(container);
    }
    
        
}
