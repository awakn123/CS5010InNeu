package rolePlayingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Battle class
 * The main class for preparing a battle, fight for it, and show the result.
 */
public class Battle {
    private Character character1;
    private Character character2;
    private List<Gear> gearList;
    private Character winner;

    public static final String TIE_TIP = "The battle is a tie, no one wins.";
    public static final String WINNER_TIP = "The winner is: ";

    /**
     * Construct Battle class with 3 properties.
     * @param character1
     * @param character2
     * @param gearList
     */
    public Battle(Character character1, Character character2, List<Gear> gearList) {
        this.character1 = character1;
        this.character2 = character2;
        this.gearList = gearList;
    }

    /**
     * Characters take turn to pick up gears and dress for themselves.
     * @return the dress process description.
     */
    public String dress() {
        StringBuilder out = new StringBuilder();
        int length = gearList.size();
        for (int i = 0; i < length; i++) {
            Character character = i % 2 == 0 ? character1 : character2;
            int chooseItem = character.choose(gearList);
            gearList.remove(chooseItem);
            out.append(character).append(System.lineSeparator());
        }
        return out.toString();
    }

    /**
     * Fight process, will mark winner as the fight result;
     * Win by the damage amount. If character 1 makes more damage, character 1 wins;
     * If character 2 makes more damage, character 2 wins;
     * If damage equals, it's a tie.
     * @return the winner of the fight, if draws, return tie tip;
     */
    public String fight() {
        int damageFrom1 = character1.getAttack() - character2.getDefense();
        int damageFrom2 = character2.getAttack() - character1.getDefense();
        if (damageFrom1 > damageFrom2) {
            this.winner = character1;
            return WINNER_TIP + winner;
        } else if (damageFrom2 > damageFrom1) {
            this.winner = character2;
            return WINNER_TIP + winner;
        } else {
            this.winner = null;
            return TIE_TIP;
        }
    }

    private static Character generateCharacter(String name) {
        Character c = new Character(ThreadLocalRandom.current().nextInt(100, 150),
                ThreadLocalRandom.current().nextInt(100, 150));
        return c;
    }

    private static String[] adjectives = {"cold-weather", "assorted", "heavier", "unbroken", "incredible"};
    private static String[] handGears = {"blade", "axe", "sword", "spear", "hammer"};
    private static String[] headGears = {"cap", "helmet"};
    private static String[] footWears = {"boot", "sneaker", "shoe"};

    private static List<Gear> generateGearList(int amount) {
        List<Gear> gears = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            Gear gear;
            int typeInt = ThreadLocalRandom.current().nextInt(0, 3);
            String adj = adjectives[ThreadLocalRandom.current().nextInt(0, adjectives.length)];
            if (typeInt == 0) {
                String noun = handGears[ThreadLocalRandom.current().nextInt(0, handGears.length)];
                gear = new HandGear(adj, noun, ThreadLocalRandom.current().nextInt(0, 100));
            } else if (typeInt == 1) {
                String noun = headGears[ThreadLocalRandom.current().nextInt(0, headGears.length)];
                gear = new HeadGear(adj, noun, ThreadLocalRandom.current().nextInt(0, 50));
            } else {
                String noun = footWears[ThreadLocalRandom.current().nextInt(0, footWears.length)];
                gear = new Footwear(adj, noun,
                        ThreadLocalRandom.current().nextInt(0, 25),
                        ThreadLocalRandom.current().nextInt(0, 25));
            }
            gears.add(gear);
        }
        return gears;
    }

    /**
     * The whole process of the battle.
     * Will prepare characters and gears in it, dress 2 characters, get the winner, and show winner tip.
     * @param args
     */
    public static void main(String[] args) {
        Character character1 = generateCharacter("John");
        Character character2 = generateCharacter("Wilson");
        List<Gear> gears = generateGearList(10);
        Battle battle = new Battle(character1, character2, gears);
        String dressProcess = battle.dress();
        System.out.println(dressProcess);
        String winnerTip = battle.fight();
        System.out.println(winnerTip);
    }
}
