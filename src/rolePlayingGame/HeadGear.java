package rolePlayingGame;

public class HeadGear extends Gear{
    private int defense;

    public int getDefense() {
        return defense;
    }

    @Override
    public void combineNumber(Gear gear) {
        Object o = new Object();
        if (gear instanceof HeadGear) {
            this.defense += ((HeadGear) gear).getDefense();
        } else {
            throw new IllegalArgumentException("not same type");
        }
    }
}
