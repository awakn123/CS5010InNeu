import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Track {
    private Map<Integer, Bird> birdMap = new HashMap<>();

    public List<Bird> getBirdList() {
        return birdMap.values().stream().collect(Collectors.toList());
    }

    public Bird getBird(int id) {
        return birdMap.get(id);
    }

    public int observeNewBird(BirdType birdType) {
        Bird bird;
        if (Classification.Parrots.equals(birdType.getClassification())) {
            bird = new Parrot(birdType);
        } else if (Classification.Shorebirds.equals(birdType.getClassification()) ||
            Classification.Waterfowl.equals(birdType.getClassification())) {
            bird = new WaterBird(birdType);
        } else {
            bird = new Bird(birdType);
        }
        birdMap.put(bird.getId(), bird);
        return bird.getId();
    }

    public void markParrotWords(int id, List<String> vocabulary) {
        Bird bird = getBirdNotNull(id);
        bird.setVocabulary(vocabulary);
    }

    public void markParrotFavorite(int id, String favorite) {
        Bird bird = getBirdNotNull(id);
        bird.setFavorite(favorite);
    }

    public void markEating(int id, String food) {
        Bird bird = getBirdNotNull(id);
        bird.eat(food);
    }

    private Bird getBirdNotNull(int id) {
        Bird bird = birdMap.get(id);
        if (bird == null) {
            throw new IllegalArgumentException("The id:" + id + " does not exist.");
        }
        return bird;
    }

    public void markWaterBody(int id, String waterBody) {
        Bird bird = birdMap.get(id);
        bird.setWaterBody(waterBody);
    }

}
