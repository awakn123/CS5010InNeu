import java.util.ArrayList;
import java.util.List;

public class Bird {
    private int id;
    private BirdType birdType;
    private List<Food> foodList = new ArrayList<>();
    private static int maxId = 1;

    public Bird(BirdType birdType) {
        this.birdType = birdType;
        this.id = maxId;
        maxId++;
    }

    public int getId() {
        return id;
    }

    public BirdType getBirdType() {
        return birdType;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

}
