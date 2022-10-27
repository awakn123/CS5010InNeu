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
        gear.add(new HeadGear("big", "hat", 20));//3
        gear.add(new Footwear("fancy", "skateboard", 10, 20));
        gear.add(new Footwear("black", "boots", 200, 300));
        for (int i = 0; i < 6; i++) {
            int chooseItem = a.choose(gear);
            //System.out.println(chooseItem);
            a.pickUp(gear.get(chooseItem));
            gear.remove(gear.get(chooseItem));
            String s = a.toString();
            System.out.println(s);
        }
    }

}