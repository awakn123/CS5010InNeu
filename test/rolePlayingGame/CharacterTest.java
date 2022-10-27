package rolePlayingGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CharacterTest {

    /**
     * test the result of picking up headgear
     * whether it should be combined with the other gear or added in the empty slot as the first one
     * and judge whether the values of attack and defense are correct
     */
    @Test
    public void pickUpHeadGear() {
        Character a = new Character(100, 200);
        Assert.assertEquals(100, a.getAttack());
        Assert.assertEquals(200, a.getDefense());
        Assert.assertNull(a.getHeadGear());
        //pickup headGear b
        Gear b = new HeadGear("blue", "hat", 3);
        a.pickUp(b);
        Assert.assertEquals(100, a.getAttack());
        Assert.assertEquals(203, a.getDefense());
        assertNotNull(a.getHeadGear());
        //pickup headGear c
        Gear c = new HeadGear("red", "cap", 4);
        a.pickUp(c);
        Assert.assertEquals(100, a.getAttack());
        Assert.assertEquals(207, a.getDefense());
        assertNotNull(a.getHeadGear());
    }

    /**
     * test the result of picking up hand gear
     * whether it should be combined with the other gear or added in the empty slot as the first one
     * and judge whether the values of attack and defense are correct
     */
    @Test
    public void pickUpHandGear() {
        Character a = new Character(50, 60);
        Assert.assertEquals(50, a.getAttack());
        Assert.assertEquals(60, a.getDefense());
        Assert.assertNull(a.getLeftHandGear());
        Assert.assertNull(a.getRightHandGear());
        //pickup handGear b
        Gear b = new HandGear("blue", "gloves", 3);
        a.pickUp(b);
        Assert.assertEquals(53, a.getAttack());
        Assert.assertEquals(60, a.getDefense());
        assertNotNull(a.getLeftHandGear());
        assertNull(a.getRightHandGear());
        //pickup headGear c
        Gear c = new HandGear("sharp", "sword", 4);
        a.pickUp(c);
        Assert.assertEquals(57, a.getAttack());
        Assert.assertEquals(60, a.getDefense());
        assertNotNull(a.getLeftHandGear());
        assertNotNull(a.getRightHandGear());
        Gear d = new HandGear("thick", "shield", 10);
        a.pickUp(d);
        Assert.assertEquals(67, a.getAttack());
        Assert.assertEquals(60, a.getDefense());
        assertNotNull(a.getLeftHandGear());
        assertNotNull(a.getRightHandGear());
    }

    /**
     * test the result of picking up footwear
     * whether it should be combined with the other gear or added in the empty slot as the first one
     * and judge whether the values of attack and defense are correct
     */
    @Test
    public void pickUpFootwear() {
        Character a = new Character(50, 60);
        Assert.assertEquals(50, a.getAttack());
        Assert.assertEquals(60, a.getDefense());
        Assert.assertNull(a.getLeftFootwear());
        Assert.assertNull(a.getRightFootwear());
        //pickup handGear b
        Gear b = new Footwear("blue", "boots", 3, 4);
        a.pickUp(b);
        Assert.assertEquals(53, a.getAttack());
        Assert.assertEquals(64, a.getDefense());
        assertNotNull(a.getLeftFootwear());
        assertNull(a.getRightFootwear());
        //pickup headGear c
        Gear c = new Footwear("fancy", "skateboard", 4, 5);
        a.pickUp(c);
        Assert.assertEquals(57, a.getAttack());
        Assert.assertEquals(69, a.getDefense());
        assertNotNull(a.getLeftFootwear());
        assertNotNull(a.getRightFootwear());
        Gear d = new Footwear("thick", "shield", 10, 11);
        a.pickUp(d);
        Assert.assertEquals(67, a.getAttack());
        Assert.assertEquals(80, a.getDefense());
        assertNotNull(a.getLeftFootwear());
        assertNotNull(a.getRightFootwear());
    }

    /**
     * test the result of picking up different types of gear
     * mainly to test the values of attack and defense
     */
    @Test
    public void pickUpGear() {
        Character a = new Character(100, 200);
        Assert.assertEquals(100, a.getAttack());
        Assert.assertEquals(200, a.getDefense());
        Assert.assertNull(a.getHeadGear());
        //pickup headGear b
        Gear b = new HeadGear("blue", "hat", 5);
        Gear c = new HandGear("sharp", "sword", 4);
        Gear d = new Footwear("thick", "shield", 10, 11);
        a.pickUp(b);
        a.pickUp(c);
        a.pickUp(d);
        Assert.assertEquals(114, a.getAttack());
        Assert.assertEquals(216, a.getDefense());
    }

    /**
     * test the method choose and toString
     * see the order of the chosen gear and the display of each turn, including wearing, attack and defense
     */
    @Test
    public void chooseTest() {
        Character a = new Character("Mary", 100, 200);
        List<Gear> gear = new ArrayList<>();
        gear.add(new HeadGear("blue", "hat", 5));
        gear.add(new HandGear("white", "glove", 10));
        gear.add(new HandGear("black", "sword", 100));
        gear.add(new HeadGear("big", "hat", 20));
        gear.add(new Footwear("fancy", "skateboard", 10, 20));
        gear.add(new Footwear("black", "boots", 200, 300));
        //the first choice [blue hat, white glove, black sword, big hat, fancy skateboard, black boots] expected:black boots
        int choose1 = a.choose(gear);
        a.pickUp(gear.get(choose1));
        Assert.assertEquals(5, choose1);
        Assert.assertEquals("black boots", gear.get(choose1).getFullName());
        gear.remove(gear.get(choose1));
        //the second choice [blue hat, white glove, black sword, big hat, fancy skateboard] expected: black sword
        int choose2 = a.choose(gear);
        a.pickUp(gear.get(choose2));
        Assert.assertEquals(2, choose2);
        Assert.assertEquals("black sword", gear.get(choose2).getFullName());
        gear.remove(gear.get(choose2));
        //the third choice [blue hat, white glove, big hat, fancy skateboard] expected :fancy skateboard
        int choose3 = a.choose(gear);
        a.pickUp(gear.get(choose3));
        Assert.assertEquals(3, choose3);
        Assert.assertEquals("fancy skateboard", gear.get(choose3).getFullName());
        gear.remove(gear.get(choose3));
        //the fourth choice [blue hat, white glove, big hat] expected :white glove
        int choose4 = a.choose(gear);
        a.pickUp(gear.get(choose4));
        Assert.assertEquals(1, choose4);
        Assert.assertEquals("white glove", gear.get(choose4).getFullName());
        gear.remove(gear.get(choose4));
        //the fifth choice [blue hat, big hat] expected: big hat
        int choose5 = a.choose(gear);
        a.pickUp(gear.get(choose5));
        Assert.assertEquals(1, choose5);
        Assert.assertEquals("big hat", gear.get(choose5).getFullName());
        gear.remove(gear.get(choose5));
        //the sixth choice [blue hat] expected: blue hat
        int choose6 = a.choose(gear);
        a.pickUp(gear.get(choose6));
        Assert.assertEquals(0, choose6);
        Assert.assertEquals("blue hat", gear.get(choose6).getFullName());
        gear.remove(gear.get(choose6));
        //test toString method
        String s = a.toString();
        Assert.assertEquals(" Character name: Mary, Character gear: blue, big hat ," +
                " black sword , white glove , black boots , fancy skateboard ,   Attack power = 420, Defense Strength =  545", s);

// Use following code if needed to use following code. Don't forget to annotate the all the six steps above.
//        for (int i = 0; i < 6; i++) {
//            int chooseItem = a.choose(gear);
//            //System.out.println(chooseItem);
//            a.pickUp(gear.get(chooseItem));
//            gear.remove(gear.get(chooseItem));
//            String s = a.toString();
//            System.out.println(s);
//            }
    }

}