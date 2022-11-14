public class SeniorSDE extends AbstractEngineer{

    private int numOfReports;

    public SeniorSDE(String name, int salary, int numOfReports) {
        super(name, salary);
        this.numOfReports = numOfReports;
    }

    @Override
    double calculateRatio(Rating rating) {
        return numOfReports / 5.0;
    }
}
