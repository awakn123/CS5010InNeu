package bignumber;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BigNumberTest {

    /**
     * test big number constructor
     * allow empty parameter, should be 0.
     * allow string parameter, should be same with string.
     * If contains a non-digit character, will throw exception.
     */
    @Test
    public void testConstructor() {
        BigNumber bigNumber = new BigNumberImpl();
        Assert.assertNotNull(bigNumber);
        Assert.assertEquals("0", bigNumber.toString());
        BigNumber bigNumber2 = new BigNumberImpl("88221");
        Assert.assertNotNull(bigNumber2);
        Assert.assertThrows(IllegalArgumentException.class, () -> new BigNumberImpl("a"));
    }

    /**
     * test the length of big number
     * empty is 0, so length is 1.
     * add 10, comes to 11, so length is 2.
     * Use string to create a long big number, test length is right.
     */
    @Test
    public void length() {
        BigNumber bigNumber = new BigNumberImpl();
        Assert.assertEquals(1, bigNumber.length());
        bigNumber.addDigit(10);
        Assert.assertEquals(2, bigNumber.length());
        BigNumber bigNumber2 = new BigNumberImpl("299290000088443");
        Assert.assertEquals(15, bigNumber2.length());
    }

    /**
     * test shift left -10, means shift right 10.
     * test shift left 5, means *10^5.
     * test shift left 0, means nothing changes.
     */
    @Test
    public void shiftLeft() {
        BigNumber bigNumber = new BigNumberImpl("299290000088443");
        bigNumber.shiftLeft(-10);
        Assert.assertEquals("29929", bigNumber.toString());
        bigNumber.shiftLeft(5);
        Assert.assertEquals("2992900000", bigNumber.toString());
        bigNumber.shiftLeft(0);
        Assert.assertEquals("2992900000", bigNumber.toString());
    }

    /**
     * test shift right 10, means divide 10^10, floor the result.
     * test shift right -5, means *10^5.
     * test shift right 0, means nothing changes.
     */
    @Test
    public void shiftRight() {
        BigNumber bigNumber = new BigNumberImpl("299290000088443");
        bigNumber.shiftRight(10);
        Assert.assertEquals("29929", bigNumber.toString());
        bigNumber.shiftRight(-5);
        Assert.assertEquals("2992900000", bigNumber.toString());
        bigNumber.shiftRight(0);
        Assert.assertEquals("2992900000", bigNumber.toString());
        bigNumber.shiftRight(20);
        Assert.assertEquals("0", bigNumber.toString());
    }

    /**
     * 9999 add 1 to 10000
     */
    @Test
    public void addDigit() {
        BigNumber bigNumber = new BigNumberImpl("9999");
        bigNumber.addDigit(1);
        Assert.assertEquals("10000", bigNumber.toString());
    }

    /**
     * create a 15 length number, get digit at 0, should be the rightest one.
     * get digit at 14, should be the leftest one.
     * get digit at 15 and -1, should be exception.
     */
    @Test
    public void getDigitAt() {
        BigNumber bigNumber = new BigNumberImpl("299290000088443");
        Assert.assertEquals(3, bigNumber.getDigitAt(0));
        Assert.assertEquals(2, bigNumber.getDigitAt(14));
        Assert.assertThrows(IllegalArgumentException.class, () -> bigNumber.getDigitAt(15));
        Assert.assertThrows(IllegalArgumentException.class, () -> bigNumber.getDigitAt(-1));
    }

    /**
     * copy a 3456 bignumber.
     * should get a 3456 big number, but not the same one.
     */
    @Test
    public void copy() {
        BigNumber bigNumber = new BigNumberImpl("3456");
        BigNumber bigNumber1 = bigNumber.copy();
        Assert.assertNotSame(bigNumber, bigNumber1);
        Assert.assertEquals("3456", bigNumber1.toString());
    }

    /**
     * 3456 add 1111, should get 4567, and 3456 not changed.
     * 3456 add 7000, should get 10456.
     */
    @Test
    public void add() {
        BigNumber bigNumber1 = new BigNumberImpl("3456");
        BigNumber bigNumber2 = new BigNumberImpl("1111");
        BigNumber bigNumber3 = bigNumber1.add(bigNumber2);
        Assert.assertEquals("4567", bigNumber3.toString());
        BigNumber bigNumber4 = bigNumber1.add(new BigNumberImpl("7000"));
        Assert.assertEquals("10456", bigNumber4.toString());
    }

    /**
     * compare 3456 with 1111, same length different value.
     * compare 3456 with 789, different length.
     * compare 3456 with a new 3456, different object same value, should be 0.
     */
    @Test
    public void compare() {
        BigNumber bigNumber1 = new BigNumberImpl("3456");
        BigNumber bigNumber2 = new BigNumberImpl("1111");
        BigNumber bigNumber3  = new BigNumberImpl("789");
        Assert.assertEquals(1, bigNumber1.compareTo(bigNumber2));
        Assert.assertEquals(-1, bigNumber2.compareTo(bigNumber1));
        Assert.assertEquals(0, bigNumber1.compareTo(new BigNumberImpl("3456")));
        Assert.assertEquals(1, bigNumber1.compareTo(bigNumber3));
        Assert.assertEquals(-1, bigNumber3.compareTo(bigNumber1));
    }
}