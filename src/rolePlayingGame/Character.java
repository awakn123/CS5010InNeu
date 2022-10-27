package rolePlayingGame;


import java.util.ArrayList;
import java.util.List;

/**
 * Character class
 * The class are mainly created to choose and pick up gear.
 */

public class Character {
    private final int initialAttack;
    private final int initialDefense;
    private int attack;
    private int defense;
    private HeadGear headGear;
    private HandGear leftHandGear;
    private HandGear rightHandGear;
    private Footwear leftFootwear;
    private Footwear rightFootwear;

    private String name;

    /**
     * constructor
     *
     * @param initialAttack
     * @param initialDefense
     */
    public Character(int initialAttack, int initialDefense) {
        this.initialAttack = initialAttack;
        this.initialDefense = initialDefense;
        this.defense = initialDefense;
        this.attack = initialAttack;
    }

    /**
     * constructor
     *
     * @param name
     * @param initialAttack
     * @param initialDefense
     */

    public Character(String name, int initialAttack, int initialDefense) {
        this.name = name;
        this.initialAttack = initialAttack;
        this.initialDefense = initialDefense;
        this.defense = initialDefense;
        this.attack = initialAttack;
    }

    /**
     * compute the character's attack(also includes all the gear the character wears )
     *
     * @return attack that computed
     */

    private int computeAttack() {
        int attackSum = initialAttack;
        Gear[] g = {headGear, leftHandGear, rightHandGear, leftFootwear, rightFootwear};
        for (int i = 0; i < 5; i++) {
            if (!(g[i] == null)) {
                attackSum = attackSum + g[i].getAttack();
            }
        }
        return attackSum;
    }

    /**
     * get the character's attack
     *
     * @return attack
     */

    public int getAttack() {
        return attack;
    }

    /**
     * get the character's defense
     *
     * @return defense
     */

    public int getDefense() {
        return defense;
    }

    /**
     * compute the character's defense(also includes all the gear the character wears)
     *
     * @return defense that computed
     */

    private int computeDefense() {
        int defenseSum = initialDefense;
        Gear[] g = {headGear, leftHandGear, rightHandGear, leftFootwear, rightFootwear};
        for (int i = 0; i < 5; i++) {
            if (!(g[i] == null)) {
                defenseSum = defenseSum + g[i].getDefense();
            }
        }
        return defenseSum;
    }

    /**
     * get the left hand gear
     *
     * @return the left hand gear
     */
    public HandGear getLeftHandGear() {
        return leftHandGear;
    }

    /**
     * get the right hand gear
     *
     * @return the right hand gear
     */

    public HandGear getRightHandGear() {
        return rightHandGear;
    }

    /**
     * get the left footwear
     *
     * @return the left footwear
     */

    public Footwear getLeftFootwear() {
        return leftFootwear;
    }

    /**
     * get the right footwear
     *
     * @return the right footwear
     */

    public Footwear getRightFootwear() {
        return rightFootwear;
    }

    /**
     * get the headgear
     *
     * @return the headgear
     */

    public HeadGear getHeadGear() {
        return headGear;
    }

    /**
     * pick up the gear and judge whether it should be attached to one of the empty slot or combine it to another gear
     *
     * @param obj gear
     */

    public void pickUp(Gear obj) {
        if (obj instanceof HeadGear) {
            if (headGear == null) {
                HeadGear gear = (HeadGear) obj;
                headGear = gear;
            } else {
                this.getHeadGear().combine(obj);
            }
        } else if (obj instanceof HandGear) {
            //first leftHandGear-rightHandGear-combine
            if (leftHandGear == null) {
                HandGear gear = (HandGear) obj;
                this.leftHandGear = gear;
            } else if (rightHandGear == null) {
                HandGear gear = (HandGear) obj;
                this.rightHandGear = gear;
            } else {
                this.getLeftHandGear().combine(obj);
            }
        } else if (obj instanceof Footwear) {
            if (leftFootwear == null) {
                Footwear gear = (Footwear) obj;
                leftFootwear = gear;
            } else if (rightFootwear == null) {
                Footwear gear = (Footwear) obj;
                rightFootwear = gear;
            } else {
                this.getLeftFootwear().combine(obj);
            }
        }
        attack = this.computeAttack();
        defense = this.computeDefense();
    }

    /**
     * choose in the gear list.
     * if the character has available slot, then prefer the type of the item
     * then if there is a tie in the above situation,choose the gear whose attack the most
     * then if there is a tie in the above situation,choose the gear whose defense the most
     * then if there is a tie in the above situation,pick a random one(available slot, defense and attack most)
     *
     * @param gearList a gear list
     * @return the index of the chosen gear in the gearList
     */
    public int choose(List<Gear> gearList) {
        List<Gear> option = new ArrayList<>();
        for (int i = 0; i < gearList.size(); i++) {
            if (gearList.get(i) instanceof HeadGear) {
                if (headGear == null) {
                    option.add(gearList.get(i));
                }
            } else if (gearList.get(i) instanceof HandGear) {
                if (leftHandGear == null || rightHandGear == null) {
                    option.add(gearList.get(i));
                }
            } else if (gearList.get(i) instanceof Footwear) {
                if (leftFootwear == null || rightFootwear == null) {
                    option.add(gearList.get(i));
                }
            }
        }
        if (option.size() == 0) {
            option.addAll(gearList);
        }
        //rule2 and rule3
        int attackMax = 0;
        int defenseCompare = 0;//when compare defense
        int index = 0;
        int j;
        for (j = 0; j < option.size(); j++) {
            if (option.get(j).getAttack() > attackMax) {
                attackMax = option.get(j).getAttack();
                defenseCompare = option.get(j).getDefense();
                index = j;
            } else if (option.get(j).getAttack() == attackMax) {
                if (option.get(j).getDefense() >= defenseCompare) {
                    attackMax = option.get(j).getAttack();
                    defenseCompare = option.get(j).getDefense();
                    index = j;
                }
            }
        }
        int index2 = (gearList.indexOf(option.get(index)) + gearList.size()) % (gearList.size());
        return index2;
    }

    /**
     * Print out each character in the fight along with what they are wearing and
     * their attack and defense
     */
    @Override

    public String toString() {
        Gear[] g = {headGear, leftHandGear, rightHandGear, leftFootwear, rightFootwear};
        String wear = "";
        for (int i = 0; i < 5; i++) {
            if (!(g[i] == null)) {
                wear = wear + g[i].getFullName() + " , ";
            }
        }
        return String.format(" Character name: %s, Character gear: %s  Attack power = %d, "
                        + "Defense Strength =  %d",
                this.name, wear, this.getAttack(), this.getDefense());
    }


}
