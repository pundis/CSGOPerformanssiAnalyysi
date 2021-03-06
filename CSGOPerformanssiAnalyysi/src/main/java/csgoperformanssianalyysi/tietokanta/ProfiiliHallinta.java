package csgoperformanssianalyysi.tietokanta;

import csgoperformanssianalyysi.logiikka.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lataa / tallettaa profiileita .txt tiedoistoihin
 * @author fuksi
 */
public class ProfiiliHallinta {
    
    
    private Scanner lukija;

    private String path;
    private File profiilit;
    
    public ProfiiliHallinta() throws Exception {
        this.profiilit  = new File("profiilit.txt");
    }
    
    /**
     * lataa profiilin sekä sille syötetyn datan aiemmalta istunnolta
     * @param nimi
     * @return
     * @throws Exception 
     */
    public Profiili lataaProfiili(String nimi) throws Exception {
        
        File profile = new File(nimi.toLowerCase() + "statistics.txt");
        lukija = new Scanner(profile);
        String rivi = lukija.nextLine();
        Profiili ladattavaProfiili = new Profiili(rivi);
        
        if (lukija.hasNextLine()) {
        
            while (lukija.hasNextLine()) {
                rivi = lukija.nextLine();
                String[] tiedot = rivi.split("-");
                PelattuKartta k = new PelattuKartta(Kartta.valueOf(tiedot[0]),
                Integer.parseInt(tiedot[1]), Integer.parseInt(tiedot[2]), 
                Integer.parseInt(tiedot[3]), Integer.parseInt(tiedot[4]));
                ladattavaProfiili.lisaaKartta(k);
            }
            lukija.close();
        }
            return ladattavaProfiili;
    }   
    
    
    /**
     * Tallentaa profiilin käytettäväksi seuraaville istunnoille
     * @param profiili
     * @throws Exception 
     */
    public void tallennaProfiili(Profiili profiili) throws Exception {
        FileWriter kirjuri = new FileWriter(profiili.getNimi().toLowerCase() + "statistics.txt");
        kirjuri.write(profiili.getNimi() + "\n");

        for (PelattuKartta kartta : profiili.getKaikkiKartat()) {
            kirjuri.write("" + kartta.getKartta().toString() + "-" + kartta.getOmatKierrokset() + "-"
            + kartta.getVihollisenKierrokset() + "-" + kartta.getOmatTapot() + "-"
            + kartta.getOmatKuolemat() + "\n");
        }
            kirjuri.close();
    }

    /**
     * palauttaa listan profiileista jotka voidaan ladata
     * @return 
     * @throws Exception 
     */
    public ArrayList<String> getProfiilit() throws Exception {
        lukija = new Scanner(profiilit);
        String rivi;
        ArrayList<String> palaute = new ArrayList<String>();
        
        while (lukija.hasNextLine()) {
            rivi = lukija.nextLine();
            palaute.add(rivi);
        }
        lukija.close();
        return palaute;
    }
    
    public void lisaaUusiProfiili(String profiili) throws Exception {
        try (FileWriter fw = new FileWriter(profiilit)) {
            fw.append(profiili + "\n");
            fw.close();
        }
    }
    
}
