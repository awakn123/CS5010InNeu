package bignumber;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BigNumberTest {

    @Test
    public void testConstructor() {
        BigNumber bigNumber = new BigNumberImpl();
        Assert.assertNotNull(bigNumber);
        Assert.assertEquals("0", bigNumber.toString());
        BigNumber bigNumber2 = new BigNumberImpl("88221");
        Assert.assertNotNull(bigNumber2);
        Assert.assertThrows(IllegalArgumentException.class, () -> new BigNumberImpl("a"));
    }

    @Test
    public void length() {
        BigNumber bigNumber = new BigNumberImpl();
        Assert.assertEquals(1, bigNumber.length());
        bigNumber.addDigit(10);
        Assert.assertEquals(2, bigNumber.length());
        BigNumber bigNumber2 = new BigNumberImpl("299290000088443");
        Assert.assertEquals(15, bigNumber2.length());
    }

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

    @Test
    public void addDigit() {
        BigNumber bigNumber = new BigNumberImpl("9999");
        bigNumber.addDigit(1);
        Assert.assertEquals("10000", bigNumber.toString());
    }

    @Test
    public void getDigitAt() {
        BigNumber bigNumber = new BigNumberImpl("299290000088443");
        Assert.assertEquals(3, bigNumber.getDigitAt(0));
        Assert.assertEquals(2, bigNumber.getDigitAt(14));
        Assert.assertThrows(IllegalArgumentException.class, () -> bigNumber.getDigitAt(15));
        Assert.assertThrows(IllegalArgumentException.class, () -> bigNumber.getDigitAt(-1));
    }

    @Test
    public void copy() {
        BigNumber bigNumber = new BigNumberImpl("3456");
        BigNumber bigNumber1 = bigNumber.copy();
        Assert.assertNotSame(bigNumber, bigNumber1);
        Assert.assertEquals("3456", bigNumber1.toString());
    }

    @Test
    public void add() {
        BigNumber bigNumber1 = new BigNumberImpl("3456");
        BigNumber bigNumber2 = new BigNumberImpl("1111");
        BigNumber bigNumber3 = bigNumber1.add(bigNumber2);
        Assert.assertEquals("4567", bigNumber3.toString());
        BigNumber bigNumber4 = bigNumber1.add(new BigNumberImpl("7000"));
        Assert.assertEquals("10456", bigNumber4.toString());
    }

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