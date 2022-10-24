package rolePlayingGame;

public class HeadGear extends AbstractGear {


    public HeadGear(String adjective, String noun, int defense) {
        super(adjective, noun);
        this.setDefense(defense);
    }

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
