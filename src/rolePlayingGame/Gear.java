package rolePlayingGame;

public interface Gear {
    Gear combine(Gear gear);

    String getFullName();

    int getDefense();

    int getAttack();
}
