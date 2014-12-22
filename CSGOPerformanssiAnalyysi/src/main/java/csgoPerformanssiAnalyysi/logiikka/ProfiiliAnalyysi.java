
package csgoPerformanssiAnalyysi.logiikka;

import java.util.ArrayList;


public class ProfiiliAnalyysi {
    
    
    private Profiili profiili;
    private int kuolematYht = 0;
    private int tapotYht = 0;
    private int voittoja = 0;
    private int havioita = 0;
    private int tasapeleja = 0;
    
    
    public ProfiiliAnalyysi(Profiili profiili) {
        this.profiili = profiili;
        luoYhtTapotKuolematVoitotHaviot();
    }

    public Profiili getProfiili() {
        return profiili;
    }

    public int getKuolematYht() {
        return kuolematYht;
    }

    public int getTapotYht() {
        return tapotYht;
    }

    public int getVoittoja() {
        return voittoja;
    }

    public int getHavioita() {
        return havioita;
    }

    public int getTasapeleja() {
        return tasapeleja;
    }

    public double getKdr() {
        int kills = this.tapotYht;
        int deaths = this.kuolematYht;
        double palautus = 1.0 * kills / deaths;
        return palautus;
    }
    
    
    
    public void luoYhtTapotKuolematVoitotHaviot() {
        if (!profiili.getKaikkiKartat().isEmpty()) {
            int tapot = 0;
            int kuolemat = 0;
            for (PelattuKartta kartta : profiili.getKaikkiKartat()) {
                tapot = tapot + kartta.getOmatTapot();
                kuolemat = kuolemat + kartta.getOmatKuolemat();
                if (kartta.getOmatKierrokset() > kartta.getVihollisenKierrokset()) {
                    this.voittoja++;
                } else if (kartta.getOmatKierrokset() < kartta.getVihollisenKierrokset()) {
                    this.havioita++;
                } else if (kartta.getOmatKierrokset() == kartta.getVihollisenKierrokset()) {
                    this.tasapeleja++;
                }
            }
            this.tapotYht = tapot;
            this.kuolematYht = kuolemat;
        }
    }
    
    public int getKartanVoitot(Kartta kartta) {
        int wins = 0;
        for (PelattuKartta map : profiili.getKartatMapissa().get(kartta)) {
            if (map.getOmatKierrokset() > map.getVihollisenKierrokset()) {
                wins++;
            }
        }
        return wins;
    }
    
    public int getKartanHaviot(Kartta kartta) {
        int haviot = 0;
        for (PelattuKartta map : profiili.getKartatMapissa().get(kartta)) {
            if (map.getVihollisenKierrokset() > map.getOmatKierrokset()) {
                haviot++;
            }
        }
        return haviot;
    }
    
    public int getKartanTasapelit(Kartta kartta) {
        int ties = 0;
        for (PelattuKartta map : profiili.getKartatMapissa().get(kartta)) {
            if (map.getOmatKierrokset() == map.getVihollisenKierrokset()) {
                ties++;
            }
        } 
        return ties;
    }
    
    public int getKartanTapot(Kartta kartta) {
        int kills = 0;
        for (PelattuKartta map : profiili.getKartatMapissa().get(kartta)) {
            kills = kills + map.getOmatTapot();
        }
        return kills;
    } 
    
    public int getKartanKuolemat(Kartta kartta) {
        int deaths = 0;
        for (PelattuKartta map : profiili.getKartatMapissa().get(kartta)) {
            deaths = deaths + map.getOmatKuolemat();
        }
        return deaths;
    }
    
    public double getKartanKD(Kartta kartta) {
        int kartanTapot = getKartanTapot(kartta);
        int kartanKuolemat = getKartanKuolemat(kartta);
        double palautus = 1.0 * kartanTapot / kartanKuolemat;
        return palautus;
    }
    
}
