package jugistanbul.pattern.observer.station;

import java.util.Random;

public class WeatherForecast {

    private static final Random random = new Random();

    private final double temperature;
    private final double pressure;
    private final double wind;

    public WeatherForecast(double temperature, double pressure, double wind) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.wind = wind;
    }

    public static WeatherForecast randomly() {
        WeatherForecast condition = new WeatherForecast(random.nextDouble() * 10,
                random.nextDouble() * 10,
                random.nextDouble() * 10);
        return condition;
    }

    public double getPressure() {
        return pressure;
    }

    public double getWind() {
        return wind;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", wind=" + wind +
                '}';
    }
}