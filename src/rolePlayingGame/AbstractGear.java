package rolePlayingGame;

import java.util.List;

public abstract class AbstractGear implements Gear{

    private List<String> adjectives;
    private String noun;

    private int attack;

    private int defense;

    public abstract AbstractGear combine(AbstractGear abstractGear);

    public List<String> getAdjectives() {
        return adjectives;
    }

    public String getNoun() {
        return noun;
    }

    @Override
    public Gear combine(Gear gear) {
        return null;
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public int getDefense() {
        return 0;
    }

    @Override
    public int getAttack() {
        return 0;
    }

}
