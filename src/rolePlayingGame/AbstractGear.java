package rolePlayingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractGear implements Gear{

    private List<String> adjectives;
    private String noun;

    private int attack = 0;

    private int defense = 0;

    private static final String DELIMITER_BETWEEN_ADJ = ", ";
    private static final String DELIMITER_BEFORE_NOUN = " ";

    public AbstractGear(String adjective, String noun) {
        this.adjectives = new ArrayList<>();
        this.adjectives.add(adjective);
        this.noun = noun;
    }

    public List<String> getAdjectives() {
        return adjectives;
    }

    public String getNoun() {
        return noun;
    }

    protected void combineNames(Gear gear) {
        this.adjectives.addAll(0, gear.getAdjectives());
    }

    @Override
    public String getFullName() {
        return this.adjectives.stream().collect(Collectors.joining(DELIMITER_BETWEEN_ADJ)) + DELIMITER_BEFORE_NOUN + this.noun;
    }

    @Override
    public int getDefense() {
        return this.defense;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    protected void setDefense(int defense) {
        this.defense = defense;
    }
}
