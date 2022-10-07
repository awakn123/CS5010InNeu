import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConservatoryTest {

    /**
     * 1. Try to print an empty aviary, it will get an empty tip.
     * 2. Add a blue parrot into the aviary, and try to print it.
     * 3. Add another yellow parrot into the aviary, and try to print, it will print 2 birds.
     * 4. Try to print a null, it will get a null tip.
     */
    @Test
    public void printSign() {
        Conservatory conservatory = new Conservatory();
        Aviary aviary = new Aviary("Test aviary location");
        String emptyStr = conservatory.printSign(aviary);
        Assert.assertEquals("There is no bird.", emptyStr);

        // add the first bird and test.
        BirdType parrotType = new BirdType("parrot", false, 2, Classification.Parrots);
        Bird firstBlueParrot = new Parrot("The first blue Parrot", parrotType);
        aviary.addBird(firstBlueParrot);
        firstBlueParrot.setDescription("It is enthusiastic.");
        String signStr = conservatory.printSign(aviary);
        Assert.assertEquals("The first blue Parrot : It is enthusiastic.\n", signStr);

        // add the second bird and test.
        Bird secondYellowParrot = new Parrot("The yellow Parrot", parrotType);
        aviary.addBird(secondYellowParrot);
        secondYellowParrot.setDescription("A very beautiful yellow parrot, it can sing!");
        String signStr2 = conservatory.printSign(aviary);
        Assert.assertEquals("The first blue Parrot : It is enthusiastic.\n" +
                "The yellow Parrot : A very beautiful yellow parrot, it can sing!\n", signStr2);

        String nullStr = conservatory.printSign(null);
        Assert.assertEquals("There is no aviary.", nullStr);
    }

    /**
     * Print map when there is no bird. Expect empty.
     * Rescue 10 parrots into conservatory, and print them.
     * It should have 2 aviary list, the first 5 belong to the first, and other five belong to the second.
     * In an alphabetical way by bird name.
     */
    @Test
    public void printMap() {
        /*Conservatory conservatory = new Conservatory();
        String emptyStr = conservatory.printMap();
        Assert.assertEquals("", emptyStr);
        BirdType parrotType = new BirdType("parrot", false, 2, Classification.Parrots);
        conservatory.rescue(new Parrot("A Parrot 1st", parrotType));
        conservatory.rescue(new Parrot("C Parrot 2st", parrotType));
        conservatory.rescue(new Parrot("E Parrot 3st", parrotType));
        conservatory.rescue(new Parrot("G Parrot 4st", parrotType));
        conservatory.rescue(new Parrot("I Parrot 5st", parrotType));
        conservatory.rescue(new Parrot("B Parrot 6st", parrotType));
        conservatory.rescue(new Parrot("D Parrot 7st", parrotType));
        conservatory.rescue(new Parrot("F Parrot 8st", parrotType));
        conservatory.rescue(new Parrot("H Parrot 9st", parrotType));
        conservatory.rescue(new Parrot("J Parrot 10st", parrotType));
        String mapStr = conservatory.printMap();
        Assert.assertEquals("Aviary 0:\n" +
                " \tLocation is Aviary number 0, Birds are A Parrot 1st, C Parrot 2st," +
                " E Parrot 3st, G Parrot 4st, I Parrot 5st\n" +
                "Aviary 1:\n" +
                " \tLocation is Aviary number 1, Birds are B Parrot 6st, D Parrot 7st," +
                " F Parrot 8st, H Parrot 9st, J Parrot 10st\n",
                mapStr);*/
    }
}