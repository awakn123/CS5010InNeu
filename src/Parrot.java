import java.util.ArrayList;
import java.util.List;

public class Parrot extends Bird {

    private List<String> vocabulary = new ArrayList<>();
    private String favorite;

    public Parrot(BirdType birdType) {
        super(birdType);
    }
    public Parrot(String name, BirdType birdType) {
        super(name, birdType);
    }

    public List<String> getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(List<String> vocabulary) {
        this.vocabulary = vocabulary;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }
}
