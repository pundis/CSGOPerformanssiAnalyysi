
package csgoperformanssianalyysi.logiikka;

/**
 * analysoi konstruktorin parametrinä saadun profiili olion karttoja sekä niiden
 * statistiikkoja
 * @author fuksi
 */
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
    
    
    /**
     * laskee kaikista pelatuista kartoista yht. tapot, kuolemat, voitot häviöt ja tasapelit
     * ja taltioi ne oliomuuttujaan
     */
    public void luoYhtTapotKuolematVoitotHaviot() {
        if (!profiili.getKaikkiKartat().isEmpty()) {
            int tapot = 0;
            int kuolemat = 0;
            this.voittoja = 0;
            this.havioita = 0;
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
    /**
     * 
     * @param kartta
     * @return palauttaa parametrinä annetun kentän yht. voitot
     */
    public int getKartanVoitot(Kartta kartta) {
        int wins = 0;
        if (profiili.getKartatMapissa().keySet().contains(kartta)) {
            for (PelattuKartta map : profiili.getKartatMapissa().get(kartta)) {
                if (map.getOmatKierrokset() > map.getVihollisenKierrokset()) {
                    wins++;
                }
            }
            return wins;
        } else {
            return 0;
        }
    }
    
    /**
     * 
     * @param kartta
     * @return palauttaa parametrinä annetun kartan yht. häviöt 
     */
    public int getKartanHaviot(Kartta kartta) {
        int haviot = 0;
        if (profiili.getKartatMapissa().keySet().contains(kartta)) {    
            for (PelattuKartta map : profiili.getKartatMapissa().get(kartta)) {
                if (map.getVihollisenKierrokset() > map.getOmatKierrokset()) {
                    haviot++;
                }
            }
            return haviot;
        } else {
            return 0;
        }
    }
    
    
    /**
     * 
     * @param kartta
     * @return palauttaa parametrinä annetun kentän yht. tasapelit 
     */
    public int getKartanTasapelit(Kartta kartta) {
        int ties = 0;
        if (profiili.getKartatMapissa().keySet().contains(kartta)) {
            for (PelattuKartta map : profiili.getKartatMapissa().get(kartta)) {
                if (map.getOmatKierrokset() == map.getVihollisenKierrokset()) {
                    ties++;
                }
            } 
            return ties;
        } else {
            return 0;
        }
    }
    
    /**
     * 
     * @param kartta
     * @return palauttaa parametrinä annetun kentän yht. tapot 
     */
    public int getKartanTapot(Kartta kartta) {
        int kills = 0;
        if (profiili.getKartatMapissa().keySet().contains(kartta)) {
            for (PelattuKartta map : profiili.getKartatMapissa().get(kartta)) {
                kills = kills + map.getOmatTapot();
            }
            return kills;
        } else {
            return 0;
        }
    } 
    
    /**
     * 
     * @param kartta
     * @return palauttaa parametrinä annetun kentän yht. kuolemat
     */
    public int getKartanKuolemat(Kartta kartta) {
        int deaths = 0;
        if (profiili.getKartatMapissa().keySet().contains(kartta)) {
            for (PelattuKartta map : profiili.getKartatMapissa().get(kartta)) {
                deaths = deaths + map.getOmatKuolemat();
            }
            return deaths;
        } else {
            return 0;
        }
    }
    
    /**
     * 
     * @param kartta
     * @return palauttaa parametrinä annetun kentän Kuolema-tappo ration
     */
    public double getKartanKD(Kartta kartta) {
        if (profiili.getKartatMapissa().keySet().contains(kartta)) {
            int kartanTapot = getKartanTapot(kartta);
            int kartanKuolemat = getKartanKuolemat(kartta);
            double palautus = 1.0 * kartanTapot / kartanKuolemat;
            return palautus;
        } else {
            return 0;
        }
    }
    
}
