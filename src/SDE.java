public class SDE extends AbstractEngineer {

    private int linesOfCode;
    private int numDesignDoc;

    public SDE(String name, int salary, int linesOfCode, int numDesignDoc) {
        super(name, salary);
        this.linesOfCode = linesOfCode;
        this.numDesignDoc = numDesignDoc;
    }

    @Override
    double calculateRatio(Rating rating) {
        double r = linesOfCode / 80.0 + numDesignDoc / 5.0;
        if (Rating.EXCEED_EXPECTATION == rating) {
            r = r * 1.2;
        } else if (Rating.SUPERB == rating) {
            r = r * 1.7;
        }
        return r;
    }
}
