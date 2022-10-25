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
    public Character(int initialAttack, int initialDefense){
        this.initialAttack = initialAttack;
        this.initialDefense= initialDefense;
        this.defense= initialDefense;
        this.attack=initialAttack;
    }



    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
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

//    private void wear(Gear obj){
//    }

    public void pickUp(Gear obj){
        if(obj instanceof HeadGear){
            if(headGear == null){
                HeadGear gear =(HeadGear) obj;
                defense=initialDefense + gear.getDefense();
                headGear=gear;
            } else {
                this.getHeadGear().combine(obj);
                defense=initialDefense+this.getHeadGear().getDefense();
            }
        } else if (obj instanceof HandGear) {
            //first leftHandGear-rightHandGear-combine
            if(leftHandGear==null){
                HandGear gear=(HandGear) obj;
                this.leftHandGear=gear;
                attack=initialAttack+this.getLeftHandGear().getAttack();
            } else if (rightHandGear==null) {
                HandGear gear=(HandGear) obj;
                this.rightHandGear=gear;
                attack=initialAttack+this.getLeftHandGear().getAttack()+this.getRightHandGear().getAttack();
            }else {
                this.getLeftHandGear().combine(obj);
                attack=initialAttack+this.getLeftHandGear().getAttack()+this.getRightHandGear().getAttack();
            }


        } else if (obj instanceof Footwear) {

            if(leftFootwear==null){
                Footwear gear=(Footwear) obj;
                leftFootwear=gear;
                attack=initialAttack+this.getLeftFootwear().getAttack();
                defense=initialDefense+this.getLeftFootwear().getDefense();
            } else if (rightFootwear==null) {
                Footwear gear=(Footwear) obj;
                rightFootwear=gear;
                attack=initialAttack+this.getLeftFootwear().getAttack()+this.getRightFootwear().getAttack();
                defense=initialDefense+this.getLeftFootwear().getDefense()+this.getRightFootwear().getDefense();
            }else {
                this.getLeftFootwear().combine(obj);
                attack=initialAttack+this.getLeftFootwear().getAttack()+this.getRightFootwear().getAttack();
                defense=initialDefense+this.getLeftFootwear().getDefense()+this.getRightFootwear().getDefense();
            }
        }

    }

}
