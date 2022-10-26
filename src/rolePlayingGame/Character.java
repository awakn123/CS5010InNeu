package rolePlayingGame;

import java.awt.*;

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

    public Character(int initialAttack, int initialDefense) {
        this.initialAttack = initialAttack;
        this.initialDefense = initialDefense;
        this.defense = initialDefense;
        this.attack = initialAttack;
    }



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

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

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

    public HandGear getLeftHandGear() {
        return leftHandGear;
    }

    public HandGear getRightHandGear() {
        return rightHandGear;
    }

    public Footwear getLeftFootwear() {
        return leftFootwear;
    }

    public Footwear getRightFootwear() {
        return rightFootwear;
    }

    public HeadGear getHeadGear() {
        return headGear;
    }


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

}
