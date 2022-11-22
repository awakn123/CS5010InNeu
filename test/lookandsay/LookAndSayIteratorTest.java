package lookandsay;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * The test class for look and say iterator.
 */
public class LookAndSayIteratorTest {

    /**
     * test 3 constructor methods and the exception case.
     */
    @Test
    public void testConstructor() {
        LookAndSayIterator one = new LookAndSayIterator();
        Assert.assertEquals("1", one.getCurrentValue().toString());
        Assert.assertEquals(LookAndSayIterator.defaultEndValue, one.getEndValue());
        LookAndSayIterator seed = new LookAndSayIterator(new BigInteger("3333"));
        Assert.assertEquals("3333", seed.getCurrentValue().toString());
        Assert.assertEquals(LookAndSayIterator.defaultEndValue, seed.getEndValue());
        LookAndSayIterator all = new LookAndSayIterator(new BigInteger("3333"), new BigInteger("5555"));
        Assert.assertEquals("3333", all.getCurrentValue().toString());
        Assert.assertEquals("5555", all.getEndValue().toString());
        Assert.assertThrows(IllegalArgumentException.class, () -> new LookAndSayIterator(new BigInteger("3333"), new BigInteger("3333")));
    }

    /**
     * test Previous function
     */
    @Test
    public void prev() {
        LookAndSayIterator one = new LookAndSayIterator();
        Assert.assertFalse(one.hasPrevious());
        one.next();
        Assert.assertTrue(one.hasPrevious());
        Assert.assertEquals("11", one.prev().toString());
    }

    /**
     * test next function
     */
    @Test
    public void next() {
        LookAndSayIterator one = new LookAndSayIterator();
        Assert.assertTrue(one.hasNext());
        Assert.assertEquals("1", one.next().toString());
        Assert.assertTrue(one.hasNext());
        Assert.assertEquals("11", one.next().toString());
        LookAndSayIterator maxTest = new LookAndSayIterator(new BigInteger("12"), new BigInteger("100"));
        maxTest.next();
        Assert.assertFalse(maxTest.hasNext());
        Assert.assertTrue(maxTest.next().compareTo(new BigInteger("100")) > 0);
    }

    /**
     * test function provided by teacher.
     */
    @Test(timeout = 1000)
    public void testDefaultSeed() {
        Iterator<BigInteger> iterator = new LookAndSayIterator();
        BigInteger previous = new BigInteger("1");
        iterator.next(); // burn off the first one
        while (iterator.hasNext()) {
            BigInteger b = iterator.next();
            assertTrue("Number " + previous.toString() + " cannot be read as " + b.toString(),
                    decode(previous, b));
            previous = b;
        }
        previous = iterator.next();
        assertTrue("The iterator ended but the last number was not more than " + "100 digits long",
                previous.toString().length() > 100);
    }

    /**
     * test function provided by teacher.
     */
    @Test(timeout = 1000)
    public void testBasicReverse() {
        BigInteger seed = new BigInteger("123");
        RIterator<BigInteger> iterator = new LookAndSayIterator(seed);
        BigInteger num1 = iterator.next();
        BigInteger num2 = iterator.next();
        BigInteger num3 = iterator.next();
        BigInteger num4 = iterator.next();
        iterator.prev();
        assertEquals("2nd call to prev() should return same as last call to next()",
                num4, iterator.prev());
        assertEquals("prev() not as expected", num3, iterator.prev());
        assertEquals("prev() not as expected", num2, iterator.prev());
        assertEquals("prev() not as expected", num1, iterator.prev());
        assertFalse("hasPrevious() should return false", iterator.hasPrevious());
    }

    /**
     * test function provided by teacher.
     */
    @Test(timeout = 3000)
    public void testCustomValidSeed() {
        Random r = new Random(10);
        for (int j = 0; j < 200; j++) {
            int seed = r.nextInt(20000);
            if (Integer.toString(seed).indexOf('0') == -1) {
                Iterator<BigInteger> iterator = new LookAndSayIterator(new BigInteger("" + seed));
                BigInteger previous = new BigInteger("" + seed);
                iterator.next(); // burn off the first one
                while (iterator.hasNext()) {
                    BigInteger b = iterator.next();
                    assertTrue("Number " + previous.toString() + " cannot be read as " + b.toString(),
                            decode(previous, b));
                    previous = b;
                }
                previous = iterator.next();
                assertTrue("The iterator ended but the last number was not more than " + "100 digits long",
                        previous.toString().length() > 100);
            }
        }
    }

    private boolean decode(BigInteger previous, BigInteger current) {
        String currentString = current.toString();
        StringBuilder soln = new StringBuilder();

        for (int i = 0; i < currentString.length(); i += 2) {
            int freq = Character.digit(currentString.charAt(i), 10);
            int num = Character.digit(currentString.charAt(i + 1), 10);
            for (int j = 0; j < freq; j++) {
                soln.append(num);
            }
        }
        return soln.toString().equals(previous.toString());
    }
}