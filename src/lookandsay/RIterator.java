package lookandsay;

import java.util.Iterator;

/**
 * Iterator that provides previous function.
 * @param <T>
 */
public interface RIterator<T> extends Iterator<T> {

    /**
     * Get current value and iterate to the previous one.
     * @return
     */
    T prev();

    /**
     * Check whether the previous one is a valid one.
     * @return
     */
    boolean hasPrevious();
}
