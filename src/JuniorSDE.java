public class JuniorSDE extends AbstractEngineer {
    private int linesOfCode;

    public JuniorSDE(String name, int salary, int linesOfCode) {
        super(name, salary);
        this.linesOfCode = linesOfCode;
    }

    @Override
    double calculateRatio(Rating rating) {
        double r = linesOfCode / 100.0;
        if (Rating.SUPERB == rating) {
            r = r * 2.0;
        }
        return r;
    }
}
