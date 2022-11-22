package lookandsay;

import java.math.BigInteger;

/**
 * A look-and-say sequence is a sequence of numbers.
 * Given the current number, the next number is obtained by reading the current number out loud, writing what we say.
 * For example, if the current number is "1", then we read that as "one 1" and thus the next number in the sequence will be "11" .
 * Similarly, if the current number is "112321", then we read that as "two 1s, one 2, one 3, one 2, one 1",
 * producing the next number as "2112131211", and so on.
 * A look-and-say sequence is a simple example of run-length encoding.
 *
 * In this class, we provide previous and next function to the look and say sequence.
 */
public class LookAndSayIterator implements RIterator<BigInteger> {

    private BigInteger currentValue;
    private BigInteger endValue;
    // The default end value.
    public static final BigInteger defaultEndValue;

    static {
        String s = "";
        for (int i = 0; i < 100; i++) {
            s += "9";
        }
        defaultEndValue = new BigInteger(s);
    }

    /**
     * Constructor with the start seed and end value.
     * @param seed
     * @param endValue
     */
    public LookAndSayIterator(BigInteger seed, BigInteger endValue) {
        if (seed.signum() <= 0) {
            throw new IllegalArgumentException();
        }
        if (seed.compareTo(endValue) >= 0) {
            throw new IllegalArgumentException();
        }
        String seedStr = seed.toString();
        if (seedStr.contains("0")) {
            throw new IllegalArgumentException();
        }
        this.currentValue = seed;
        this.endValue = endValue;
    }

    /**
     * Constructor with start seed and default end value.
     * @param seed
     */
    public LookAndSayIterator(BigInteger seed) {
        this(seed, defaultEndValue);
    }

    /**
     * Constructor with seed 1 and default end value.
     */
    public LookAndSayIterator() {
        this(new BigInteger("1"), defaultEndValue);
    }

    /**
     * return the current value and iterate to previous.
     * @return
     */
    @Override
    public BigInteger prev() {
        BigInteger prev = getPrev();
        BigInteger curValue = this.currentValue;
        this.currentValue = prev;
        return curValue;
    }

    private BigInteger getPrev() {
        char[] currentChars = this.currentValue.toString().toCharArray();
        if (currentChars.length == 1) {
            return this.currentValue;
        }
        String prevStr = "";
        for (int i = 0; i < currentChars.length - 1; i += 2) {
            int len = currentChars[i] - '0';
            if (currentChars.length%2 == 1 && i == currentChars.length - 2) {
                i++;
                int len2 = currentChars[i] - '0';
                len = len * 10 + len2;
            }
            for (int j = 0; j < len; j++) {
                prevStr += currentChars[i + 1];
            }
        }
        BigInteger prev = new BigInteger(prevStr);
        return prev;
    }

    /**
     * check whether previous value is valid.
     * @return
     */
    @Override
    public boolean hasPrevious() {
        return this.currentValue.toString().length() > 1 && this.currentValue.compareTo(this.endValue) <= 0;
    }

    /**
     * check whether next value is valid.
     * @return
     */
    @Override
    public boolean hasNext() {
        return this.currentValue.compareTo(this.endValue) <= 0;
    }

    /**
     * return current value and iterate to the next.
     * @return
     */
    @Override
    public BigInteger next() {
        BigInteger next = getNext();
        BigInteger curValue = this.currentValue;
        this.currentValue = next;
        return curValue;
    }

    private BigInteger getNext() {
        char[] currentChars = this.currentValue.toString().toCharArray();
        String nextStr = "";
        for (int i = 0; i < currentChars.length; i++) {
            int j = i;
            while (j < currentChars.length - 1 && currentChars[j] == currentChars[j + 1]) {
                j++;
            }
            int length = j - i + 1;
            nextStr += Integer.toString(length) + currentChars[i];
            i = j;
        }
        BigInteger next = new BigInteger(nextStr);
        return next;
    }

    /**
     * get current value
     * @return
     */
    public BigInteger getCurrentValue() {
        return currentValue;
    }

    /**
     * get end value
     * @return
     */
    public BigInteger getEndValue() {
        return endValue;
    }
}
