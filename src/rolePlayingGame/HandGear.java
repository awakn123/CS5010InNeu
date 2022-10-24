package rolePlayingGame;

public class HandGear extends AbstractGear {


    public HandGear(String adjective, String noun, int attack) {
        super(adjective, noun);
        this.setAttack(attack);
    }

    @Override
    public void combine(Gear gear) {
        if (!(gear instanceof HandGear)) {
            throw new IllegalArgumentException("Cannot combine " + gear.getFullName() + ", Class is " +
                    gear.getClass().getSimpleName() + " with " + this.getFullName() + ", Class is " +
                    this.getClass().getSimpleName());
        }
        this.combineNames(gear);
        this.setAttack(this.getAttack() + gear.getAttack());
    }
}
