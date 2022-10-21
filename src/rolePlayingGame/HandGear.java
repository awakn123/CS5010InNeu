package rolePlayingGame;

public class HandGear extends AbstractGear {

    @Override
    public AbstractGear combine(AbstractGear abstractGear) {
        return this;
    }
}
