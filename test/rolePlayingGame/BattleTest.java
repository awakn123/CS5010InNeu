package rolePlayingGame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BattleTest {
    Character character1 = new Character(10, 10);
    Character character2 = new Character(20, 20);

    /**
     * test the constructor of battle.
     */
    @Test
    public void testConstructor() {
        Assert.assertNotNull(new Battle(character1, character2, new ArrayList<>()));
    }

    /**
     * test the dress process.
     */
    @Test
    public void dress() {
        List<Gear> gearList = new ArrayList<>();
        gearList.add(new HandGear("Iron", "Blade", 30));
        gearList.add(new HandGear("Copper", "Sword", 25));
        Battle battle = new Battle(character1, character2, gearList);
        String out = battle.dress();
        String[] output = out.split(System.lineSeparator());
        Assert.assertEquals(2, output.length);
        Assert.assertEquals(character1.toString(), output[0]);
        Assert.assertEquals(character2.toString(), output[1]);
    }

    /**
     * Test the fight process.
     * When damage from 1 is bigger than damage from 2, 1 wins, return 1;
     * When damage from 1 is smaller than damage from 2, 2 wins, return 2;
     * When the damage equals, return null;
     */
    @Test
    public void fight() {
        Character character3 = new Character(10, 10);
        Character character4 = new Character(20, 20);
        Battle battle = new Battle(character3, character4, new ArrayList<>());
        Assert.assertEquals(Battle.WINNER_TIP + character4, battle.fight());
        Character character5 = new Character(20, 20);
        Battle battle2 = new Battle(character4, character5, new ArrayList<>());
        Assert.assertEquals(Battle.TIE_TIP, battle2.fight());
        Character character6 = new Character(30, 30);
        Battle battle3 = new Battle(character6, character5, new ArrayList<>());
        Assert.assertEquals(Battle.WINNER_TIP + character6, battle3.fight());

    }

}