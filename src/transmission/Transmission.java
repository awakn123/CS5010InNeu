package transmission;

/**
 * Transmission of a car.
 */
public interface Transmission {

    /**
     * Increase 2 speed.
     * @return
     */
    Transmission increaseSpeed();

    /**
     * Decrease 2 speed.
     * @return
     */
    Transmission decreaseSpeed();

    /**
     * getCurrentSpeed
     * @return
     */
    int getSpeed();

    /**
     * get Current Gear
     * @return
     */
    int getGear();

}
