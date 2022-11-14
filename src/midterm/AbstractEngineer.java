package midterm;

public abstract class AbstractEngineer implements Engineer {

    private String name;
    private int base;

    private double bonus;

    public AbstractEngineer(String name, int salary) {
        this.name = name;
        this.base = salary;
        this.bonus = 0d;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setBonus(Rating rating) {
        double baseBonus = this.base;
        baseBonus += pullDepartmentProfit();
        baseBonus += pullNASDQIndex();
        baseBonus += pullManagerMood();
        baseBonus += pullCPI();
        double ratio = this.calculateRatio(rating);
        this.bonus = baseBonus * ratio;
    }

    abstract double calculateRatio(Rating rating);

    @Override
    public double getBonus() {
        return this.bonus;
    }

    @Override
    public int compareTo(Engineer o) {
        return this.getName().compareTo(o.getName());
    }
}
