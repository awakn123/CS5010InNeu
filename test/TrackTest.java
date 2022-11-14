import old.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrackTest {

    private int eagleId;
    private int parrotId;
    private int waterBirdId;
    private Track track;
    @Before
    public void setUp() throws Exception {
        track = new Track();
        this.eagleId = track.observeNewBird(new BirdType("eagle", false, 2,
                Classification.BirdsOfPrey));
        this.parrotId = track.observeNewBird(new BirdType("old.Parrot", false, 2,
                Classification.Parrots));
        this.waterBirdId = track.observeNewBird(new BirdType("Duck", false, 2,
                Classification.Waterfowl));
    }
    @Test
    public void getBirdList() {
        Assert.assertEquals(3, track.getBirdList().size());
    }

    @Test
    public void getBird() {
        Bird bird = track.getBird(this.eagleId);
        Assert.assertNotNull(bird);
    }

    @Test
    public void markParrotWords() {
        List<String> vocabulary = new ArrayList<>();
        vocabulary.add("Hello");
        vocabulary.add("world");
        track.markParrotWords(parrotId, vocabulary);
        Bird parrot = track.getBird(this.parrotId);
        Assert.assertEquals(vocabulary, parrot.getVocabulary());
        Assert.assertThrows(IllegalCallerException.class, ()->{
            track.markParrotWords(eagleId, vocabulary);
        });
    }

    @Test
    public void markParrotFavorite() {
        String favorite = "Hello world";
        track.markParrotFavorite(parrotId, favorite);
        Bird parrot = track.getBird(this.parrotId);
        Assert.assertEquals(favorite, parrot.getFavorite());
        Assert.assertThrows(IllegalCallerException.class, ()->{
            track.markParrotFavorite(eagleId, favorite);
        });
    }

    @Test
    public void markEating() {
        track.markEating(eagleId, "otherBirds");
        Assert.assertTrue(track.getBird(eagleId).getFoodList().contains(Food.otherBirds));
        Assert.assertThrows(IllegalArgumentException.class, ()->{
            track.markEating(eagleId, "milk");
        });
    }

    @Test
    public void markWaterBody() {
        track.markWaterBody(waterBirdId, "River");
        Assert.assertEquals("River", track.getBird(waterBirdId).getWaterBody());
        Assert.assertThrows(IllegalCallerException.class, ()->{
            track.markWaterBody(eagleId, "River");
        });
    }
}