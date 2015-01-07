

package csgoperformanssianalyysi.logiikka;


public enum Kartta {

    train, dust2, nuke, mirage, inferno, cobble, overpass, cache,
    OTHER;
    
    @Override
    public String toString() {
        return this.name();
    }
}