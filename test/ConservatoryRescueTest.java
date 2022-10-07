import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class ConservatoryRescueTest {

    /**
     * Test rescue method.
     * 1. extinct bird, should not be rescued, will return false, and the aviary is empty.
     * 2. owls, should rescue successfully, and the aviary is 1, the bird number in the aviary is 1.
     * 3. Duck(Waterfowl), emus(Flightless birds), hawk(birds of prey) could not be mixed.
     * So they will be added to new aviary.
     * 4. add parrot, it should be mixed with owls, the aviary number would not grow.
     * 5. Keep rescuing 4 parrots, the first aviary will hold 5 birds, and aviary number become 5.
     * 6. Keep rescuing 16 * 5 - 1 = 79 parrots, the aviary number will become 20, and the last one will hold 5 birds.
     * 7. Rescuing another parrot, will return false.
     */
    @Test
    public void rescue() {
        ConservatoryRescue conservatory = new ConservatoryRescue();
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
        Assert.assertTrue(conservatory.rescue(new Bird("Black Duck", duckType)));
        Assert.assertEquals(3, conservatory.getAviaryList().size());

        // Check hawk
        BirdType hawkType = new BirdType("hawk", false, 2, Classification.BirdsOfPrey);
        Assert.assertTrue(conservatory.rescue(new Bird("Big Hawk", hawkType)));
        Assert.assertEquals(4, conservatory.getAviaryList().size());

        // Check parrot
        BirdType parrotType = new BirdType("parrot", false, 2, Classification.Parrots);
        Assert.assertTrue(conservatory.rescue(new Bird("Beautiful P", parrotType)));
        Assert.assertEquals(4, conservatory.getAviaryList().size());
        Assert.assertEquals(2, conservatory.getAviaryList().get(0).getBirdList().size());

        // Rescuing 4 parrots.
        conservatory.rescue(new Bird("Normal Parrot 1", parrotType));
        conservatory.rescue(new Bird("Normal Parrot 2", parrotType));
        conservatory.rescue(new Bird("Normal Parrot 3", parrotType));
        conservatory.rescue(new Bird("Normal Parrot 4", parrotType));
        Assert.assertEquals(5, conservatory.getAviaryList().size());
        Assert.assertEquals(5, conservatory.getAviaryList().get(0).getBirdList().size());

        // Rescuing 79 parrots.
        for (int i = 0; i < 79; i++) {
            Assert.assertTrue(conservatory.rescue(new Bird("Batch Parrot " + i, parrotType)));
        }
        Assert.assertEquals(20, conservatory.getAviaryList().size());
        Assert.assertEquals(5, conservatory.getAviaryList().get(19).getBirdList().size());

        // Rescue the last
        Assert.assertFalse(conservatory.rescue(new Bird("Last one", parrotType)));
    }

    /**
     * Rescue 10 parrots into conservatory, and print them.
     * It should have 2 aviary list, the first 5 belong to the first, and other five belong to the second.
     * In an alphabetical way by bird name.
     */
    @Test
    public void printIndex() {
        ConservatoryRescue conservatory = new ConservatoryRescue();
        BirdType parrotType = new BirdType("parrot", false, 2, Classification.Parrots);
        conservatory.rescue(new Bird("A Parrot 1st", parrotType));
        conservatory.rescue(new Bird("C Parrot 2st", parrotType));
        conservatory.rescue(new Bird("E Parrot 3st", parrotType));
        conservatory.rescue(new Bird("G Parrot 4st", parrotType));
        conservatory.rescue(new Bird("I Parrot 5st", parrotType));
        conservatory.rescue(new Bird("B Parrot 6st", parrotType));
        conservatory.rescue(new Bird("D Parrot 7st", parrotType));
        conservatory.rescue(new Bird("F Parrot 8st", parrotType));
        conservatory.rescue(new Bird("H Parrot 9st", parrotType));
        conservatory.rescue(new Bird("J Parrot 10st", parrotType));
        String indexStr = conservatory.printIndex();
        Assert.assertEquals("The bird name is:A Parrot 1st, locates in Aviary number 0\n" +
                "The bird name is:B Parrot 6st, locates in Aviary number 1\n" +
                "The bird name is:C Parrot 2st, locates in Aviary number 0\n" +
                "The bird name is:D Parrot 7st, locates in Aviary number 1\n" +
                "The bird name is:E Parrot 3st, locates in Aviary number 0\n" +
                "The bird name is:F Parrot 8st, locates in Aviary number 1\n" +
                "The bird name is:G Parrot 4st, locates in Aviary number 0\n" +
                "The bird name is:H Parrot 9st, locates in Aviary number 1\n" +
                "The bird name is:I Parrot 5st, locates in Aviary number 0\n" +
                "The bird name is:J Parrot 10st, locates in Aviary number 1\n", indexStr);
    }

    /**
     * 1. rescue a bird need 1 berry, check food type quantities should only have one berry.
     * 2. rescue a bird need 1 berry and 1 seed, check quantities, should have berry: 2, seed: 1.
     */
    @Test
    public void getFoodTypeQuantities() {
        ConservatoryRescue conservatory = new ConservatoryRescue();
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