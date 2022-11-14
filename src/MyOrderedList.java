import java.util.Arrays;
import java.util.function.Predicate;

public class MyOrderedList<T extends Comparable<T>> implements OrderedList<T> {
    private Object[] array;
    private int size = 0;

    private static final int INITIAL_SIZE = 16;

    public MyOrderedList() {
        this.size = 0;
        this.array = new Object[INITIAL_SIZE];
    }

    @Override
    public void add(T val) {
        if (val == null) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        for (; i < this.size; i++) {
            if (((T) array[i]).compareTo(val) >= 0) {
                break;
            }
        }
        this.size++;
        if (this.size > this.array.length) {
            this.array = Arrays.copyOf(this.array, this.array.length * 2);
        }
        for (int j = this.size - 1; j > i; j--) {
            array[j] = array[j - 1];
        }
        array[i] = val;
    }

    @Override
    public T get(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public OrderedList<T> subList(Predicate<T> pred) {
        OrderedList<T> result = new MyOrderedList<T>();
        for (int i = 0; i < this.size; i++) {
            if (pred.test(this.get(i))) {
                result.add(this.get(i));
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            out.append(this.array[i]);
            if (i != this.size - 1) {
                out.append(" ");
            }
        }
        return out.toString();
    }
}
