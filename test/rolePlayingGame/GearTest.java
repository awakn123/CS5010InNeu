package rolePlayingGame;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GearTest {

    @Test
    public void testConstructor() {
        Assert.assertNotNull(new HeadGear("Iron", "Helmet", 10));
        Assert.assertNotNull(new HandGear("Iron", "Blade", 10));
        Assert.assertNotNull(new Footwear("Wood", "Shoe", 5, 5));
    }

    @Test
    public void getAttackAndDefense() {
        Gear headGear = new HeadGear("Iron", "Helmet", 10);
        Assert.assertEquals(10, headGear.getDefense());
        Assert.assertEquals(0, headGear.getAttack());
        Gear handGear = new HandGear("Iron", "Blade", 10);
        Assert.assertEquals(10, handGear.getAttack());
        Assert.assertEquals(0, handGear.getDefense());
        Gear footwear = new Footwear("Wood", "Shoe", 5, 4);
        Assert.assertEquals(5, footwear.getAttack());
        Assert.assertEquals(4, footwear.getDefense());
    }

    @Test
    public void combineWithHeadGear() {
        Gear ironHelmet = new HeadGear("Iron", "Helmet", 10);
        Assert.assertEquals("Iron Helmet", ironHelmet.getFullName());
        Gear ironBlade = new HandGear("Iron", "Blade", 10);
        Assert.assertThrows(IllegalArgumentException.class, () -> ironHelmet.combine(ironBlade));
        Gear thickCap = new HeadGear("Thick", "Cap", 5);
        ironHelmet.combine(thickCap);
        Assert.assertEquals(15, ironHelmet.getDefense());
        Assert.assertEquals("Thick, Iron Helmet", ironHelmet.getFullName());
        Assert.assertEquals(0, ironHelmet.getAttack());
    }

    @Test
    public void combineWithHandGear() {
        Gear ironBlade = new HandGear("Iron", "Blade", 10);
        Gear ironHelmet = new HeadGear("Iron", "Helmet", 10);
        Gear yellowGlove = new HandGear("Yellow", "Glove", 5);
        Assert.assertThrows(IllegalArgumentException.class, () -> yellowGlove.combine(ironHelmet));
        ironBlade.combine(yellowGlove);
        Assert.assertEquals("Yellow, Iron Blade", ironBlade.getFullName());
        Assert.assertEquals(15, ironBlade.getAttack());
        Assert.assertEquals(0, ironBlade.getDefense());
    }

    @Test
    public void combineWithFootwear() {
        Gear leatherBoots = new Footwear("Leather", "Boots", 4, 6);
        Assert.assertEquals("Leather Boots", leatherBoots.getFullName());
        Gear ironHelmet = new HeadGear("Iron", "Helmet", 10);
        Assert.assertThrows(IllegalArgumentException.class, () -> leatherBoots.combine(ironHelmet));
        Gear fiberSneaker = new Footwear("Fiber", "Sneaker", 6, 3);
        leatherBoots.combine(fiberSneaker);
        Assert.assertEquals("Fiber, Leather Boots", leatherBoots.getFullName());
        Assert.assertEquals(10, leatherBoots.getAttack());
        Assert.assertEquals(9, leatherBoots.getDefense());
    }
}