package rolePlayingGame;

import java.util.List;

public abstract class Gear {

    private List<String> adjectives;
    private String noun;

    public Gear combine(Gear gear) {
        adjectives.addAll(gear.getAdjectives());
        // combine number.
        this.combineNumber(gear);
        return this;
    }

    public List<String> getAdjectives() {
        return adjectives;
    }

    public String getNoun() {
        return noun;
    }

    public abstract void combineNumber(Gear gear);

}
