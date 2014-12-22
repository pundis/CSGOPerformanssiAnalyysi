
package csgoPerformanssiAnalyysi.logiikka;

public class PelattuKartta {

    private Kartta kartta;
    private int omatKierrokset;
    private int vihollisenKierrokset;
    private int omatTapot;
    private int omatKuolemat;

    public PelattuKartta(Kartta kartta, int omatKierrokset, int vihollisenKierrokset,
            int omatTapot, int omatKuolemat) {
        this.kartta = kartta;
        this.omatKierrokset = omatKierrokset;
        this.vihollisenKierrokset = vihollisenKierrokset;
        this.omatTapot = omatTapot;
        this.omatKuolemat = omatKuolemat;
    }

    public Kartta getKartta() {
        return kartta;
    }

    public int getOmatKierrokset() {
        return omatKierrokset;
    }

    public int getVihollisenKierrokset() {
        return vihollisenKierrokset;
    }

    public int getOmatTapot() {
        return omatTapot;
    }

    public int getOmatKuolemat() {
        return omatKuolemat;
    }
    
    
    
    
    
}
