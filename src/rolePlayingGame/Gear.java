package rolePlayingGame;

import java.util.List;

/**
 * Gear Interface
 */
public interface Gear {

    /**
     * combine the gear to current gear;
     * @param gear
     */
    void combine(Gear gear);

    /**
     * get full name of the gear;
     * Format is: The first adjective, the second, ..., the last adjective noun.
     * @return
     */
    String getFullName();

    /**
     * get defense
     * @return
     */
    int getDefense();

    /**
     * get attack
     * @return
     */
    int getAttack();

    /**
     * get all adjectives.
     * @return
     */
    List<String> getAdjectives();
}
