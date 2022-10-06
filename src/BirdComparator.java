import java.util.Comparator;

public class BirdComparator implements Comparator<Bird> {
    @Override
    public int compare(Bird o1, Bird o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
