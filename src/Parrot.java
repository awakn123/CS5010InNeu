import java.util.ArrayList;
import java.util.List;

/**
 * Parrot Class. Use for setting and getting their vocabulary and favourite saying.
 */
public class Parrot extends Bird {

    private List<String> vocabulary = new ArrayList<>();
    private String favorite;

    /**
     * Construct a Parrot objet that has the provided bird type
     *
     * @param birdType the type of the bird
     */
    public Parrot(BirdType birdType) {
        super(birdType);
    }

    /**
     * Construct a Parrot objet that has the provided name and bird type
     *
     * @param name     the name of the parrot
     * @param birdType the type of the parrot
     */
    public Parrot(String name, BirdType birdType) {
        super(name, birdType);
    }

    /**
     * Get the vocabulary of the parrot
     *
     * @return the vocabulary of the parrot
     */
    public List<String> getVocabulary() {
        return vocabulary;
    }

    /**
     * Set the vocabulary of the parrot
     *
     * @param vocabulary the vocabulary of the parrot
     */
    public void setVocabulary(List<String> vocabulary) {
        this.vocabulary = vocabulary;
    }

    /**
     * Get the favorite saying of the parrot
     *
     * @return the favorite saying of the parrot
     */

    public String getFavorite() {
        return favorite;
    }

    /**
     * Set the favorite saying of the parrot
     *
     * @param favorite the favorite saying of the parrot
     */

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }
}
