package transmission;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransmissionTest {

    /**
     * Test Constructor with unsorted one, same thresholds, negative one -- exception;
     * Test with sort one -- can generate successfully.
     */
    @Test
    public void testConstructor() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new AutomaticTransmission(10, 20, 4, 30, 50));
        Assert.assertThrows(IllegalArgumentException.class, () -> new AutomaticTransmission(10, 20, 30, 30, 50));
        Assert.assertThrows(IllegalArgumentException.class, () -> new AutomaticTransmission(-10, 20, 30, 40, 50));
        new AutomaticTransmission(10, 20, 30, 40, 50);
    }

    /**
     * Test 10,20,30,40,50.
     * Increase 4 times, test gear, should be 0, speed should be 8;
     * 1 more time, gear should be 1, speed should be 10;
     * 5 more times, gear should be 2, speed should be 20;
     * 25 more times, gear should be 5, speed should be 70
     * Test transmission with 1,2,3,4,5
     * Increase one time, gear should be 2, speed should be 2.
     */
    @Test
    public void increaseSpeed() {
        Transmission transmission = new AutomaticTransmission(10, 20, 30, 40, 50);
        for (int i = 0; i < 4; i++)
            transmission.increaseSpeed();
        Assert.assertEquals(0, transmission.getGear());
        Assert.assertEquals(8, transmission.getSpeed());
        transmission.increaseSpeed();
        Assert.assertEquals(1, transmission.getGear());
        Assert.assertEquals(10, transmission.getSpeed());
        for (int i = 0; i < 5; i++)
            transmission.increaseSpeed();
        Assert.assertEquals("Transmission (speed = 20, gear = 2)", transmission.toString());
        for (int i = 0; i < 25; i++)
            transmission.increaseSpeed();
        Assert.assertEquals("Transmission (speed = 70, gear = 5)", transmission.toString());
        transmission = new AutomaticTransmission(1, 2, 3, 4, 5);
        transmission.increaseSpeed();
        Assert.assertEquals("Transmission (speed = 2, gear = 2)", transmission.toString());
    }

    /**
     * Test transmission with 10,20,30,40,50
     * Decrease 1 time, should get Illegal state exception.
     * Increase 30 times, should get speed: 60, gear:5;
     * Decrease 5 times: should get speed: 50, gear: 5;
     * Decrease 1 time: should get speed: 48, gear:4;
     */
    @Test
    public void decreaseSpeed() {
        Transmission transmission = new AutomaticTransmission(10, 20, 30, 40, 50);
        Assert.assertThrows(IllegalStateException.class, () -> transmission.decreaseSpeed());
        for (int i = 0; i < 30; i++) {
            transmission.increaseSpeed();
        }
        Assert.assertEquals("Transmission (speed = 60, gear = 5)", transmission.toString());
        for (int i = 0; i < 5; i++) {
            transmission.decreaseSpeed();
        }
        Assert.assertEquals("Transmission (speed = 50, gear = 5)", transmission.toString());
        transmission.decreaseSpeed();
        Assert.assertEquals("Transmission (speed = 48, gear = 4)", transmission.toString());
    }

}