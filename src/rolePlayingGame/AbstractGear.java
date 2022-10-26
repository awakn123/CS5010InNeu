package rolePlayingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The abstract gear class. implements most common logics.
 */
public abstract class AbstractGear implements Gear{

    private List<String> adjectives;
    private String noun;

    private int attack = 0;

    private int defense = 0;

    private static final String DELIMITER_BETWEEN_ADJ = ", ";
    private static final String DELIMITER_BEFORE_NOUN = " ";

    /**
     * constructor with names.
     * @param adjective
     * @param noun
     */
    public AbstractGear(String adjective, String noun) {
        this.adjectives = new ArrayList<>();
        this.adjectives.add(adjective);
        this.noun = noun;
    }

    /**
     * get current adjectives
     * @return
     */
    public List<String> getAdjectives() {
        return adjectives;
    }

    /**
     * combine the names from the gear of the parameter to itself.
     * @param gear
     */
    protected void combineNames(Gear gear) {
        this.adjectives.addAll(0, gear.getAdjectives());
    }

    /**
     * get the whole name.
     * @return
     */
    @Override
    public String getFullName() {
        return this.adjectives.stream().collect(Collectors.joining(DELIMITER_BETWEEN_ADJ)) + DELIMITER_BEFORE_NOUN + this.noun;
    }

    /**
     * get defense
     * @return
     */
    @Override
    public int getDefense() {
        return this.defense;
    }

    /**
     * get attack
     * @return
     */
    @Override
    public int getAttack() {
        return this.attack;
    }

    /**
     * set attack, should be used in combine only.
     * @param attack
     */
    protected void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * set defense, should be used in combine only.
     * @param defense
     */
    protected void setDefense(int defense) {
        this.defense = defense;
    }
}
