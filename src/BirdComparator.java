import java.util.Comparator;

/**
 * BirdComparator Class
 * Compare bird by bird name.
 */
public class BirdComparator implements Comparator<Bird> {
    /**
     * compare the bird by bird name, in alphabetical order.
     * @param o1 the first bird to be compared.
     * @param o2 the second bird to be compared.
     * @return
     */
    @Override
    public int compare(Bird o1, Bird o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
