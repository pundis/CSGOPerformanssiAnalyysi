
package csgoperformanssianalyysi.logiikka;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Profiili {

    private String nimi;
    private HashMap<Kartta, ArrayList<PelattuKartta>> kartat = new HashMap<Kartta, ArrayList<PelattuKartta>>();
    private ArrayList<PelattuKartta> kaikkiKartat = new ArrayList<PelattuKartta>();
    private ProfiiliAnalyysi pa;
    
    public Profiili(String nimi) throws Exception {
        this.pa = new ProfiiliAnalyysi(this);
        this.nimi = nimi;
        
        File file = new File("profiilit.txt");
        Scanner lukija = new Scanner(file);
        String rivi = "";
        boolean onkoOlemassa = false;
        
        while (lukija.hasNextLine()) {
            rivi = rivi + lukija.nextLine();
            if (rivi.contains(nimi)) {
                onkoOlemassa = true;
            }
        }
        if (onkoOlemassa == false) {
            FileWriter kirjuri = new FileWriter("profiilit.txt");
            kirjuri.write(rivi + "\n");
            kirjuri.close();
        }
    }
    
    /**
     * Lisää profiiliin pelatun kartan.
     * @param kartta 
     */
    public void lisaaKartta(PelattuKartta kartta) {
        if (kartat.containsKey(kartta.getKartta())) {
            ArrayList<PelattuKartta> asd = kartat.get(kartta.getKartta());
            asd.add(kartta);
            kaikkiKartat.add(kartta);
        } else {
            ArrayList<PelattuKartta> asd = new ArrayList<PelattuKartta>();
            asd.add(kartta);
            kartat.put(kartta.getKartta(), asd);
            kaikkiKartat.add(kartta);
        }
        this.pa.luoYhtTapotKuolematVoitotHaviot();
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    /**
     * 
     * @return palauttaa HashMapin jossa on jokaisen eri kentän pelatut kartat,
     * avaimena kenttä, ja arvona arraylist jossa kaikki pelatut kartat kyseisessä kentässä 
     */
    public HashMap<Kartta, ArrayList<PelattuKartta>> getKartatMapissa() {
        return kartat;
    }
    
    /**
     * 
     * @return palauttaa arraylistin kaikista pelatuista kentistä 
     */
    public ArrayList<PelattuKartta> getKaikkiKartat() {
        return kaikkiKartat;
    }
    
    
}
