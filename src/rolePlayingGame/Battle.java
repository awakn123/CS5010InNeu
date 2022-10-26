package rolePlayingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Battle {
    private Character character1;
    private Character character2;
    private List<Gear> gearList;

    public Battle(Character character1, Character character2, List<Gear> gearList) {
        this.character1 = character1;
        this.character2 = character2;
        this.gearList = gearList;
    }

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

    public Character battle() {
        int damageFrom1 = character1.getAttack() - character2.getDefense();
        int damageFrom2 = character2.getAttack() - character1.getDefense();
        if (damageFrom1 > damageFrom2) {
            return character1;
        } else if (damageFrom2 > damageFrom1) {
            return character2;
        }
        return null;
    }

    public String printWinner(Character winner) {
        if (winner == null) {
            return "The battle is a tie, no one wins.";
        } else {
            return "The winner is: " + winner;
        }
    }

    public static Character generateCharacter(String name) {
        Character c = new Character(ThreadLocalRandom.current().nextInt(100, 150),
                ThreadLocalRandom.current().nextInt(100, 150));
        return c;
    }

    private static String[] adjectives = {"cold-weather", "assorted", "heavier", "unbroken", "incredible"};
    private static String[] handGears = {"blade", "axe", "sword", "spear", "hammer"};
    private static String[] headGears = {"cap", "helmet"};
    private static String[] footWears = {"boot", "sneaker", "shoe"};

    public static List<Gear> generateGearList(int amount) {
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

    public static void main(String[] args) {
        Character character1 = generateCharacter("John");
        Character character2 = generateCharacter("Wilson");
        List<Gear> gears = generateGearList(10);
        Battle battle = new Battle(character1, character2, gears);
        String dressProcess = battle.dress();
        System.out.println(dressProcess);
        Character winner = battle.battle();
        String winnerTip = battle.printWinner(winner);
        System.out.println(winnerTip);
    }
}
