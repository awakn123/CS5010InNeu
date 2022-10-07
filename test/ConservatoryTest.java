import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConservatoryTest {

    /**
     * 1. Try to print an empty aviary, it will get an empty tip.
     * 2. Add a blue parrot into the aviary, and try to print it.
     * 3. Add another yellow parrot into the aviary, and try to print, it will get 2 birds.
     * 4. Try to print a null, it will get a null tip.
     */
    @Test
    public void printSign() {
        Conservatory conservatory = new Conservatory();
        Aviary aviary = new Aviary("Test aviary location");
        BirdType parrotType = new BirdType("parrot", false, 2, Classification.Parrots);
        Bird firstBlueParrot = new Parrot("The first blue Parrot", parrotType);
        aviary.addBird(firstBlueParrot);
        firstBlueParrot.setDescription("It is enthusiastic.");
        String signStr = conservatory.printSign(aviary);
        Assert.assertEquals("The first blue Parrot : It is enthusiastic.\n", signStr);

    }

    @Test
    public void printMap() {
    }
}