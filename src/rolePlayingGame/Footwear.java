package rolePlayingGame;

/**
 * The gear with type which is foot wear
 */
public class Footwear extends AbstractGear {
    /**
     * construct a footwear with attack and defense.
     * @param adjective
     * @param noun
     * @param attack
     * @param defense
     */
    public Footwear(String adjective, String noun, int attack, int defense) {
        super(adjective, noun);
        this.setAttack(attack);
        this.setDefense(defense);
    }

    /**
     * combine gear:
     * if the parameter is not a footwear, it is not the same type with current gear, will throw IllegalArgumentException.
     * If type is ok, then combine name and add the attack and defense to it.
     * @param gear
     */
    public void combine(Gear gear) {
        if (!(gear instanceof Footwear)) {
            throw new IllegalArgumentException("Cannot combine " + gear.getFullName() + ", Class is " +
                    gear.getClass().getSimpleName() + " with " + this.getFullName() + ", Class is " +
                    this.getClass().getSimpleName());
        }
        this.combineNames(gear);
        this.setAttack(this.getAttack() + gear.getAttack());
        this.setDefense(this.getDefense() + gear.getDefense());
    }

}
