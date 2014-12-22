
package csgoPerformanssiAnalyysi.logiikka;

import java.util.ArrayList;
import java.util.HashMap;

public class Profiili {

    private String nimi;
    private HashMap<Kartta, ArrayList<PelattuKartta>> kartat = new HashMap<Kartta, ArrayList<PelattuKartta>>();
    private ArrayList<PelattuKartta> kaikkiKartat = new ArrayList<PelattuKartta>();
    
    public Profiili(String nimi) {
        this.nimi = nimi;
    }
    
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
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public HashMap<Kartta, ArrayList<PelattuKartta>> getKartatMapissa() {
        return kartat;
    }
    
    public ArrayList<PelattuKartta> getKaikkiKartat() {
        return kaikkiKartat;
    }
    
}
