package bignumber;

public interface BigNumber extends Comparable<BigNumber>{
    /**
     * Return the number of digits in this number.
     * @return the number of digits
     */
    int length();

    /**
     * Shift this number to the left by the shiftNum.
     * A negative shiftNum will correspond to some right shifts.
     * @param shiftNum
     */
    void shiftLeft(int shiftNum);

    /**
     * Shift this number to the right by the shiftNum.
     * The number 0 can be right-shifted any positive number of times, yielding the same number 0.
     * A negative number of right-shifts will correspond to left shifts.
     * @param shiftNum
     */
    void shiftRight(int shiftNum);

    /**
     * Add the single digit to this number
     * Throw IllegalArgumentException if digit is not a single non-negative digit.
     * @param digit
     */
    void addDigit(int digit);

    /**
     * Return the digit at the position.
     * Positions start at 0 (rightmost digit).
     * This method throws an IllegalArgumentException if an invalid position is passed.
     * @param position
     */
    int getDigitAt(int position);

    /**
     * @return An identical and independent copy of this number
     */
    BigNumber copy();

    /**
     * Add. This operation does not change either number.
     * @param bigNumber
     * @return the sum of current number and the parameter.
     */
    BigNumber add(BigNumber bigNumber);

}
