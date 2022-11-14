import old.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * old.Conservatory Class. Use for rescuing birds and providing food quantities, printing some information for them.
 */
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
        Bird firstBlueParrot = new Parrot("The first blue old.Parrot", parrotType);
        aviary.addBird(firstBlueParrot);
        firstBlueParrot.setDescription("It is enthusiastic.");
        String signStr = conservatory.printSign(aviary);
        Assert.assertEquals("The first blue old.Parrot : It is enthusiastic.\n", signStr);

        // add the second bird and test.
        Bird secondYellowParrot = new Parrot("The yellow old.Parrot", parrotType);
        aviary.addBird(secondYellowParrot);
        secondYellowParrot.setDescription("A very beautiful yellow parrot, it can sing!");
        String signStr2 = conservatory.printSign(aviary);
        Assert.assertEquals("The first blue old.Parrot : It is enthusiastic.\n" +
                "The yellow old.Parrot : A very beautiful yellow parrot, it can sing!\n", signStr2);

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
        Conservatory conservatory = new Conservatory();
        String emptyStr = conservatory.printMap();
        Assert.assertEquals("", emptyStr);
        BirdType parrotType = new BirdType("parrot", false, 2, Classification.Parrots);
        conservatory.rescue(new Parrot("A old.Parrot 1st", parrotType));
        conservatory.rescue(new Parrot("C old.Parrot 2st", parrotType));
        conservatory.rescue(new Parrot("E old.Parrot 3st", parrotType));
        conservatory.rescue(new Parrot("G old.Parrot 4st", parrotType));
        conservatory.rescue(new Parrot("I old.Parrot 5st", parrotType));
        conservatory.rescue(new Parrot("B old.Parrot 6st", parrotType));
        conservatory.rescue(new Parrot("D old.Parrot 7st", parrotType));
        conservatory.rescue(new Parrot("F old.Parrot 8st", parrotType));
        conservatory.rescue(new Parrot("H old.Parrot 9st", parrotType));
        conservatory.rescue(new Parrot("J old.Parrot 10st", parrotType));
        String mapStr = conservatory.printMap();
        Assert.assertEquals("old.Aviary 0:\n" +
                " \tLocation is old.Aviary number 0, Birds are A old.Parrot 1st, C old.Parrot 2st," +
                " E old.Parrot 3st, G old.Parrot 4st, I old.Parrot 5st\n" +
                "old.Aviary 1:\n" +
                " \tLocation is old.Aviary number 1, Birds are B old.Parrot 6st, D old.Parrot 7st," +
                " F old.Parrot 8st, H old.Parrot 9st, J old.Parrot 10st\n",
                mapStr);
    }

    /**
     * Test rescue method.
     * 1. extinct bird, should not be rescued, will return false, and the aviary is empty.
     * 2. owls, should rescue successfully, and the aviary is 1, the bird number in the aviary is 1.
     * 3. Duck(old.Waterfowl), emus(Flightless birds), hawk(birds of prey) could not be mixed.
     * So they will be added to new aviary.
     * 4. add parrot, it should be mixed with owls, the aviary number would not grow.
     * 5. Keep rescuing 4 parrots, the first aviary will hold 5 birds, and aviary number become 5.
     * 6. Keep rescuing 16 * 5 - 1 = 79 parrots, the aviary number will become 20, and the last one will hold 5 birds.
     * 7. Rescuing another parrot, will return false.
     */
    @Test
    public void rescue() {
        Conservatory conservatory = new Conservatory();
        // Check Extinct bird.
        Bird extinctBird = new Bird("seaDove", new BirdType("seaDove", true, 2,
                Classification.Pigeons));
        Assert.assertFalse(conservatory.rescue(extinctBird));
        Assert.assertEquals(0, conservatory.getAviaryList().size());

        // Check normal bird(Owl).
        BirdType owlType = new BirdType("Owl", false, 2, Classification.Owls);
        Assert.assertTrue(conservatory.rescue(new Bird("Owl", owlType)));
        Assert.assertEquals(1, conservatory.getAviaryList().size());
        Assert.assertEquals(1, conservatory.getAviaryList().get(0).getBirdList().size());

        // Check emus
        BirdType emusType = new BirdType("emus", false, 2, Classification.FlightlessBirds);
        Assert.assertTrue(conservatory.rescue(new Bird("Yellow emus", emusType)));
        Assert.assertEquals(2, conservatory.getAviaryList().size());

        // Check duck
        BirdType duckType = new BirdType("duck", false, 2, Classification.Waterfowl);
        Assert.assertTrue(conservatory.rescue(new Waterfowl("Black Duck", duckType)));
        Assert.assertEquals(3, conservatory.getAviaryList().size());

        // Check hawk
        BirdType hawkType = new BirdType("hawk", false, 2, Classification.BirdsOfPrey);
        Assert.assertTrue(conservatory.rescue(new Bird("Big Hawk", hawkType)));
        Assert.assertEquals(4, conservatory.getAviaryList().size());
        Assert.assertTrue(conservatory.rescue(new Bird("Small Hawk", hawkType)));
        Assert.assertEquals(4, conservatory.getAviaryList().size());

        // Check parrot
        BirdType parrotType = new BirdType("parrot", false, 2, Classification.Parrots);
        Assert.assertTrue(conservatory.rescue(new Parrot("Beautiful P", parrotType)));
        Assert.assertEquals(4, conservatory.getAviaryList().size());
        Assert.assertEquals(2, conservatory.getAviaryList().get(0).getBirdList().size());

        // Rescuing 4 parrots.
        conservatory.rescue(new Parrot("Normal old.Parrot 1", parrotType));
        conservatory.rescue(new Parrot("Normal old.Parrot 2", parrotType));
        conservatory.rescue(new Parrot("Normal old.Parrot 3", parrotType));
        conservatory.rescue(new Parrot("Normal old.Parrot 4", parrotType));
        Assert.assertEquals(5, conservatory.getAviaryList().size());
        Assert.assertEquals(5, conservatory.getAviaryList().get(0).getBirdList().size());

        // Rescuing 79 parrots.
        for (int i = 0; i < 79; i++) {
            Assert.assertTrue(conservatory.rescue(new Parrot("Batch old.Parrot " + i, parrotType)));
        }
        Assert.assertEquals(20, conservatory.getAviaryList().size());
        Assert.assertEquals(5, conservatory.getAviaryList().get(19).getBirdList().size());

        // Rescue the last
        Assert.assertFalse(conservatory.rescue(new Parrot("Last one", parrotType)));
    }

    /**
     * Print index when there is no birds, expect empty str.
     * Rescue 10 parrots into conservatory, and print them.
     * It should have 2 aviary list, the first 5 belong to the first, and other five belong to the second.
     * In an alphabetical way by bird name.
     */
    @Test
    public void printIndex() {
        Conservatory conservatory = new Conservatory();
        String emptyStr = conservatory.printIndex();
        Assert.assertEquals("", emptyStr);
        BirdType parrotType = new BirdType("parrot", false, 2, Classification.Parrots);
        conservatory.rescue(new Parrot("A old.Parrot 1st", parrotType));
        conservatory.rescue(new Parrot("C old.Parrot 2st", parrotType));
        conservatory.rescue(new Parrot("E old.Parrot 3st", parrotType));
        conservatory.rescue(new Parrot("G old.Parrot 4st", parrotType));
        conservatory.rescue(new Parrot("I old.Parrot 5st", parrotType));
        conservatory.rescue(new Parrot("B old.Parrot 6st", parrotType));
        conservatory.rescue(new Parrot("D old.Parrot 7st", parrotType));
        conservatory.rescue(new Parrot("F old.Parrot 8st", parrotType));
        conservatory.rescue(new Parrot("H old.Parrot 9st", parrotType));
        conservatory.rescue(new Parrot("J old.Parrot 10st", parrotType));
        String indexStr = conservatory.printIndex();
        Assert.assertEquals("The bird name is:A old.Parrot 1st, locates in old.Aviary number 0\n" +
                "The bird name is:B old.Parrot 6st, locates in old.Aviary number 1\n" +
                "The bird name is:C old.Parrot 2st, locates in old.Aviary number 0\n" +
                "The bird name is:D old.Parrot 7st, locates in old.Aviary number 1\n" +
                "The bird name is:E old.Parrot 3st, locates in old.Aviary number 0\n" +
                "The bird name is:F old.Parrot 8st, locates in old.Aviary number 1\n" +
                "The bird name is:G old.Parrot 4st, locates in old.Aviary number 0\n" +
                "The bird name is:H old.Parrot 9st, locates in old.Aviary number 1\n" +
                "The bird name is:I old.Parrot 5st, locates in old.Aviary number 0\n" +
                "The bird name is:J old.Parrot 10st, locates in old.Aviary number 1\n", indexStr);
    }

    /**
     * 1. rescue a bird need 1 berry, check food type quantities should only have one berry.
     * 2. rescue a bird need 1 berry and 1 seed, check quantities, should have berry: 2, seed: 1.
     */
    @Test
    public void getFoodTypeQuantities() {
        Conservatory conservatory = new Conservatory();
        // rescue the first only 1 berry bird.
        BirdType parrotType = new BirdType("parrot", false, 2, Classification.Parrots);
        Bird berryBird = new Bird(parrotType);
        List<Food> foodList = new ArrayList<>();
        foodList.add(Food.berries);
        berryBird.setFoodList(foodList);
        conservatory.rescue(berryBird);
        Map<Food, Integer> q1 = conservatory.getFoodTypeQuantities();
        Assert.assertEquals(1, q1.values().size());
        Assert.assertEquals(1, (int) q1.get(Food.berries));

        // rescue the second bird, need 1 berry and 1 seed.
        List<Food> foodList2 = new ArrayList<>();
        foodList2.add(Food.berries);
        foodList2.add(Food.seeds);
        Bird second = new Bird(parrotType);
        second.setFoodList(foodList2);
        conservatory.rescue(second);
        Map<Food, Integer> q2 = conservatory.getFoodTypeQuantities();
        Assert.assertEquals(2, q1.values().size());
        Assert.assertEquals(2, (int) q1.get(Food.berries));
        Assert.assertEquals(1, (int) q1.get(Food.seeds));
    }
}