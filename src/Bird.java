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

    public void eat(String food) {
        //todo
    }

    public void setFavorite(String favorite) {
        throw new IllegalCallerException("The id:" + id + " does not refer to a parrot.");
    }

    public void setVocabulary(List<String> vocabulary) {
        throw new IllegalCallerException("The id:" + id + " does not refer to a parrot.");
    }

    public void setWaterBody(String waterBody) {
        throw new IllegalCallerException("The id:" + id + " does not refer to a shorebird or waterfowl.");
    }

}
