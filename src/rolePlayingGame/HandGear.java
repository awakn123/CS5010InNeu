package rolePlayingGame;

/**
 * The gear with type which is hand gear.
 */
public class HandGear extends AbstractGear {

    /**
     * construct a hand gear with attack
     * @param adjective
     * @param noun
     * @param attack
     */
    public HandGear(String adjective, String noun, int attack) {
        super(adjective, noun);
        this.setAttack(attack);
    }

    /**
     * combine gear:
     * if the parameter is not a hand gear, it is not the same type with current gear, will throw IllegalArgumentException.
     * If type is ok, then combine name and add the attack to it.
     * @param gear
     */
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
