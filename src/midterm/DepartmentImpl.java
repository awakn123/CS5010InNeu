package midterm;

import java.util.Iterator;

public class DepartmentImpl implements Department {
    private Team[] teams;
    private static final int INITIAL_TEAM_NUMBER = 4;

    public DepartmentImpl() {
        this.teams = new Team[INITIAL_TEAM_NUMBER];
        for (int i = 0; i < this.teams.length; i++) {
            this.teams[i] = new Team(i);
        }
    }

    @Override
    public boolean hire(Engineer e, int teamId) {
        if (teamId < 0 || teamId >= this.teams.length) {
            throw new IndexOutOfBoundsException("Wrong team id");
        }
        return this.teams[teamId].hire(e);
    }

    @Override
    public void giveOutBonus() {
        Iterator<Engineer> iterator = this.iterator();
        while (iterator.hasNext()) {
            iterator.next().setBonus(Rating.EXCEED_EXPECTATION);
        }
    }

    public Team[] getTeams() {
        return this.teams;
    }

    @Override
    public void layoff(double bonusThreshold) {
        for (Team team: this.teams) {
            team.layoff(bonusThreshold);
        }
    }

    @Override
    public Iterator<Engineer> iterator() {
        return new DepartmentIterator(this);
    }
}
