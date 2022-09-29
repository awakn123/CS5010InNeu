package weather;

/**
 * class: WeatherReading;
 * Formula:
 * Relative Humidity: D = T - (100 - R)/5; D: dew point(Celsius), T: temperature(Celsius).
 * HeatIndex: HI = c1 + c2 * T + c3 * R + c4 * TR + c5 * T^2 + c6 * R^2 + c7 * T^2 * R + c8 * T * R^2 + c9 * T^2 * R^2
 * T: temperature(Celsius), R: relative Humidity(percent), c1 ~ c9 is constant variable.
 * WindChill: WC = 35.74 + 0.6215 * T - 35.75 * v^(0.16) + 0.4275 * T * v^(0.16)
 * T: temperature(Fahrenheit), v: wind speed.
 */
public class WeatherReading {
    private int temperature;
    private int dewPoint;
    private int windSpeed;
    private int totalRain;
    private int relativeHumidity;
    private double heatIndex;
    private double windChill;

    // The coefficients for calculating heatIndex;
    private static double c1 = -8.78469475556, c2 = 1.61139411, c3 = 2.33854883889, c4 = -0.14611605, c5 = -0.012308094,
            c6 = -0.0164248277778, c7 = 0.002211732, c8 = 0.00072546, c9 = -0.000003582;

    public WeatherReading(int airTemperature, int dewPoint, int windSpeed, int rainReceived) {
        if (dewPoint - airTemperature > 0) {
            throw new IllegalArgumentException("The dew point temperature should not be bigger than air temperature.");
        }
        if (windSpeed < 0) {
            throw new IllegalArgumentException("The wind speed should not be negative.");
        }
        if (rainReceived < 0) {
            throw new IllegalArgumentException("The received rain should not be negative.");
        }
        this.temperature = airTemperature;
        this.dewPoint = dewPoint;
        this.windSpeed = windSpeed;
        this.totalRain = rainReceived;

        this.relativeHumidity = 5 * this.dewPoint - 5 * temperature + 100;

        int temperatureSquare = this.temperature * this.temperature;
        double relativeHumidityDouble = this.relativeHumidity;
        double relativeHumiditySquare = relativeHumidityDouble * relativeHumidityDouble;
        this.heatIndex = c1 + c2 * this.temperature + c3 * relativeHumidityDouble +
                c4 * this.temperature * relativeHumidityDouble + c5 * temperatureSquare + c6 * relativeHumiditySquare +
                c7 * temperatureSquare * relativeHumidityDouble + c8 * this.temperature * relativeHumiditySquare +
                c9 * temperatureSquare * relativeHumiditySquare;

        double fahrenheit = ((double) this.temperature) * 9 / 5 + 32;
        double vPow = Math.pow(this.windSpeed, 0.16);
        this.windChill = 35.74 + 0.6215 * fahrenheit - 35.75 * vPow + 0.4275 * fahrenheit * vPow;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getDewPoint() {
        return dewPoint;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getTotalRain() {
        return totalRain;
    }

    public int getRelativeHumidity() {
        return relativeHumidity;
    }

    public double getHeatIndex() {
        return heatIndex;
    }

    public double getWindChill() {
        return windChill;
    }

    public String toString() {
        return String.format("Reading: T = %d, D = %d, v = %d, rain = %d", temperature, dewPoint, windSpeed, totalRain);
    }
}
