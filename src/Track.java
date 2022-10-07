import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class Track. Use for track the bird.
 */
public class Track {
    private Map<Integer, Bird> birdMap = new HashMap<>();

    public List<Bird> getBirdList() {
        return birdMap.values().stream().collect(Collectors.toList());
    }

    /**
     * Get the bird by id
     *
     * @param id id of the bird
     * @return the bird
     */

    public Bird getBird(int id) {
        return birdMap.get(id);
    }

    /**
     * Observe new bird
     *
     * @param birdType the type of the bird
     *                 If the bird type is parrot, create a bird whose type is a Parrot
     *                 If the bird type is Shorebirds or Waterfowl, create a bird whose type is WaterBird
     *                 Otherwise create a bird whose type is the given bird type
     * @return the id of the bird
     */
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

    /**
     * Mark the words of the parrot
     *
     * @param id         the id of the bird
     * @param vocabulary the vocabulary that the bird get
     */
    public void markParrotWords(int id, List<String> vocabulary) {
        Bird bird = getBirdNotNull(id);
        bird.setVocabulary(vocabulary);
    }

    /**
     * Mark the words of the parrot
     *
     * @param id       the id of the bird
     * @param favorite the favorite saying of the bird
     */
    public void markParrotFavorite(int id, String favorite) {
        Bird bird = getBirdNotNull(id);
        bird.setFavorite(favorite);
    }

    /**
     * Market the eating of bird
     *
     * @param id   the id of the bird
     * @param food the food that the bird eat
     */

    public void markEating(int id, String food) {
        Bird bird = getBirdNotNull(id);
        bird.eat(food);
    }

    /**
     * Get the bird by id
     *
     * @param id the id of the bird
     * @return the bird
     */
    private Bird getBirdNotNull(int id) {
        Bird bird = birdMap.get(id);
        if (bird == null) {
            throw new IllegalArgumentException("The id:" + id + " does not exist.");
        }
        return bird;
    }

    /**
     * Get the water body of the bird
     *
     * @param id        the id of the bird
     * @param waterBody the water body that the bird lives by
     */
    public void markWaterBody(int id, String waterBody) {
        Bird bird = birdMap.get(id);
        bird.setWaterBody(waterBody);
    }

}
