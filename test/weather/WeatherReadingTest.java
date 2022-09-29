package weather;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class WeatherReadingTest {

    private WeatherReading weatherReading;

    @Before
    public void setUp() throws Exception {
        weatherReading = new WeatherReading(20, 10, 30, 40);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testTooHighDewPoint() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("The dew point temperature should not be bigger than air temperature.");
        new WeatherReading(10, 20, 30, 40);
    }
    @Test
    public void testNegativeWindSpeed() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("The wind speed should not be negative.");
        new WeatherReading(20, 10, -5, 40);
    }
    @Test
    public void testNegativeReceivedRain() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("The received rain should not be negative.");
        new WeatherReading(20, 10, 30, -10);
    }

    @Test
    public void getTemperature() {
        Assert.assertEquals(20, weatherReading.getTemperature());
    }

    @Test
    public void getDewPoint() {
        Assert.assertEquals(10, weatherReading.getDewPoint());
    }

    @Test
    public void getWindSpeed() {
        Assert.assertEquals(30, weatherReading.getWindSpeed());
    }

    @Test
    public void getTotalRain() {
        Assert.assertEquals(40, weatherReading.getTotalRain());
    }

    @Test
    public void getRelativeHumidity() {
        int dewPoint = 10;
        int temperature = 20;
        int relativeHumidity = 5 * dewPoint - 5 * temperature + 100;
        Assert.assertEquals(relativeHumidity, weatherReading.getRelativeHumidity());
    }

    @Test
    public void getHeatIndex() {
        double c1 = -8.78469475556, c2 = 1.61139411, c3 = 2.33854883889, c4 = -0.14611605, c5 = -0.012308094,
                c6 = -0.0164248277778, c7 = 0.002211732, c8 = 0.00072546, c9 = -0.000003582;
        int temperature = 20;
        double relativeHumidityDouble = 50;
        double heatIndex = c1 + c2 * temperature + c3 * relativeHumidityDouble +
                c4 * temperature * relativeHumidityDouble + c5 * temperature * temperature +
                c6 * relativeHumidityDouble * relativeHumidityDouble +
                c7 * temperature * temperature * relativeHumidityDouble +
                c8 * temperature * relativeHumidityDouble * relativeHumidityDouble +
                c9 * temperature * temperature * relativeHumidityDouble * relativeHumidityDouble;
        Assert.assertEquals(heatIndex, weatherReading.getHeatIndex(), 0.001);
    }

    @Test
    public void getWindChill() {
        int fahrenheit = 68, windSpeed = 30;
        double windChill = 35.74 + 0.6215 * fahrenheit - 35.75 * Math.pow(windSpeed, 0.16) +
                0.4275 * fahrenheit * Math.pow(windSpeed, 0.16);
        Assert.assertEquals(windChill, weatherReading.getWindChill(), 0.001);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("Reading: T = 20, D = 10, v = 30, rain = 40", weatherReading.toString());
    }
}