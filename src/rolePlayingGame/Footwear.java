package rolePlayingGame;

public class Footwear extends AbstractGear {
    private int attack;
    private int defense;

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public AbstractGear combine(AbstractGear abstractGear) {
        return null;
    }
}
