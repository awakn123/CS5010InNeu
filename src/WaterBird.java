/**
 * WaterBird Class.
 */
public class WaterBird extends Bird{
    private String waterBody;

    /**
     * Construct the waterbird
     * @param birdType the type of the bird
     */
    public WaterBird(BirdType birdType) {
        super(birdType);
    }

    /**
     * Construct the waterbird
     * @param name the name of the bird
     * @param birdType the bird type of the bird
     */
    public WaterBird(String name, BirdType birdType) {
        super(name, birdType);
    }

    /**
     * Get the water Body
     * @return the water body
     */
    public String getWaterBody() {
        return waterBody;
    }

    /**
     * Set the water body
     * @param waterBody the water body that the shorebird or waterfowl live by
     */

    public void setWaterBody(String waterBody) {
        this.waterBody = waterBody;
    }
}
