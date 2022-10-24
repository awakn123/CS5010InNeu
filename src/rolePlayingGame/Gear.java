package rolePlayingGame;

import java.util.List;

public interface Gear {
    void combine(Gear gear);

    String getFullName();

    int getDefense();

    int getAttack();

    public List<String> getAdjectives();
}
