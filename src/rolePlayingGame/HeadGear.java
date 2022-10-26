package rolePlayingGame;

/**
 * The gear with type which is headgear.
 */
public class HeadGear extends AbstractGear {

    /**
     * construct a headgear with defense
     * @param adjective
     * @param noun
     * @param defense
     */
    public HeadGear(String adjective, String noun, int defense) {
        super(adjective, noun);
        this.setDefense(defense);
    }

    /**
     * combine gear:
     * if the parameter is not a headgear, it is not the same type with current gear, will throw IllegalArgumentException.
     * If type is ok, then combine name and add the defense to it.
     * @param gear
     */
    public void combine(Gear gear) {
        if (!(gear instanceof HeadGear)) {
            throw new IllegalArgumentException("Cannot combine " + gear.getFullName() + ", Class is " +
                    gear.getClass().getSimpleName() + " with " + this.getFullName() + ", Class is " +
                    this.getClass().getSimpleName());
        }
        this.combineNames(gear);
        this.setDefense(this.getDefense() + gear.getDefense());
    }
}
