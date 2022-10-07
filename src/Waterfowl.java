/**
 * Waterfowl class
 */
public class Waterfowl extends WaterBird {
    /**
     * Construct a Waterfowl Object that has provided bird type
     *
     * @param birdType the bird type
     */
    public Waterfowl(BirdType birdType) {
        super(birdType);
    }

    /**
     * Construct a Waterfowl Object that has provided name and bird type
     *
     * @param name     the name of the waterfowl
     * @param birdType the bird type
     */
    public Waterfowl(String name, BirdType birdType) {
        super(name, birdType);
    }
}
