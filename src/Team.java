public class Team {
    private OrderedList<Engineer> engineerList;
    private int id;

    public Team(int id) {
        this.id = id;
        this.engineerList = new MyOrderedList<>();
    }

    public int getId() {
        return this.id;
    }

    public OrderedList<Engineer> getEngineerList() {
        return this.engineerList;
    }

    public boolean hire(Engineer e) {
        if (this.engineerList.size() >= 3) {
            return false;
        }
        this.engineerList.add(e);
        return true;
    }

    public void layoff(double bonusThreshold) {
        engineerList = engineerList.subList((Engineer e) -> e.getBonus() >= bonusThreshold);
    }
}