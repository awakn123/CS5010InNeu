public class WaterBird extends Bird{
    private String waterBody;

    public WaterBird(BirdType birdType) {
        super(birdType);
    }

    public String getWaterBody() {
        return waterBody;
    }

    public void setWaterBody(String waterBody) {
        this.waterBody = waterBody;
    }
}
