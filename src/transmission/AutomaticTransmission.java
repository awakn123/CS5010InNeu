package transmission;

/**
 * an Automatic Transmission
 */
public class AutomaticTransmission implements Transmission {
    private int[] thresholds;
    private int speed = 0;
    private int gearIndex = 0;
    private static final int CHANGE_SPEED = 2;

    /**
     * Please input 5 thresholds by sort, and all of them should not be same or non-positive.
     *
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     * @param t5
     */
    public AutomaticTransmission(int t1, int t2, int t3, int t4, int t5) {
        if (t1 >= t2 || t2 >= t3 || t3 >= t4 || t4 >= t5) {
            throw new IllegalArgumentException("Please input thresholds by sort and make sure there is no same thresholds.");
        }
        if (t1 <= 0) {
            throw new IllegalArgumentException("Please make sure all thresholds are bigger than 0.");
        }
        this.thresholds = new int[]{t1, t2, t3, t4, t5};
    }

    /**
     * Increase the speed of the car. Will increase the gear to an appropriate position too.
     *
     * @return current Transmission status.
     */
    @Override
    public Transmission increaseSpeed() {
        this.speed += AutomaticTransmission.CHANGE_SPEED;
        while (this.gearIndex < this.thresholds.length && this.speed >= this.thresholds[this.gearIndex]) {
            this.gearIndex++;
        }
        return this;
    }

    /**
     * Decrease the speed of the car. Will decrease the gear to an appropriate position too.
     * Will throw IllegalStateException when the speed try to become negative.
     *
     * @return
     */
    @Override
    public Transmission decreaseSpeed() {
        if (this.speed < AutomaticTransmission.CHANGE_SPEED) {
            throw new IllegalStateException("Cannot decrease speed to negative.");
        }
        this.speed -= AutomaticTransmission.CHANGE_SPEED;
        while (this.gearIndex > 0 && this.speed < this.thresholds[this.gearIndex - 1]) {
            this.gearIndex--;
        }
        return this;
    }

    /**
     * Return current Speed
     *
     * @return
     */
    @Override
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Return current gear.
     *
     * @return
     */
    @Override
    public int getGear() {
        return this.gearIndex;
    }

    /**
     * Print transmission status.
     *
     * @return
     */
    public String toString() {
        return "Transmission (speed = " + this.speed + ", gear = " + this.gearIndex + ")";
    }
}
