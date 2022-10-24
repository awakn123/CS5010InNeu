package rolePlayingGame;

public class Footwear extends AbstractGear {
    public Footwear(String adjective, String noun, int attack, int defense) {
        super(adjective, noun);
        this.setAttack(attack);
        this.setDefense(defense);
    }

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
