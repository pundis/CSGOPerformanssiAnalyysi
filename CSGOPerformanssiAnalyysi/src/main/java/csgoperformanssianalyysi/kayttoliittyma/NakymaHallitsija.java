package csgoperformanssianalyysi.kayttoliittyma;

import csgoperformanssianalyysi.logiikka.Profiili;
import csgoperformanssianalyysi.logiikka.ProfiiliAnalyysi;
import csgoperformanssianalyysi.tietokanta.ProfiiliHallinta;
import java.awt.Container;
import java.util.ArrayList;

public class NakymaHallitsija {

    private ProfiiliHallinta profhal;
    private Container nykyinengrafiikka;
    private String nykyinenProfiili;

    public NakymaHallitsija(ProfiiliHallinta profhal) {
        this.profhal = profhal;
        
    }
    
    public void profiiliLatausNakyma() throws Exception {
        ArrayList<String> profiilit = profhal.getProfiilit();
        System.out.println(profiilit);
        
        ProfiiliLatausNakyma pln = new ProfiiliLatausNakyma(profiilit);
        nykyinengrafiikka = pln.luoKomponentit();
    }
    
    public Container nykyinenNakyma() {
        return this.nykyinengrafiikka;
    }
    
    public void profiiliNakyma(String profiilinNimi) throws Exception {
        Profiili profiili = profhal.lataaProfiili(profiilinNimi);
        ProfiiliAnalyysi profana = new ProfiiliAnalyysi(profiili);
        
        ProfiiliNakyma pn = new ProfiiliNakyma(profana);
        this.nykyinengrafiikka = pn.luoKomponentit();
    }
    
        
}