import java.util.Iterator;
import java.util.NoSuchElementException;

public class DepartmentIterator implements Iterator<Engineer> {
    private Engineer[] engineers;
    private int index;

    public DepartmentIterator(DepartmentImpl department) {
        this.index = 0;
        int size = 0;
        for (Team team : department.getTeams()) {
            size += team.getEngineerList().size();
        }
        this.engineers = new Engineer[size];
        int j = 0;
        for (Team team : department.getTeams()) {
            for (int i = 0; i < team.getEngineerList().size(); i++) {
                engineers[j] = team.getEngineerList().get(i);
                j++;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return index < engineers.length;
    }

    @Override
    public Engineer next() {
        if (!hasNext())
            throw new NoSuchElementException();
        Engineer engineer = engineers[index];
        index++;
        return engineer;
    }
}
