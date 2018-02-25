package chapter02_observer_pattern.jdk;


import java.util.Observer;

/**
 * 气象站
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Observer currentConditionDisplay = new CurrentConditionDisplay();
        weatherData.addObserver(currentConditionDisplay);
        weatherData.setMeasurements(25.2f, 124.2f, 101.0f);
        weatherData.setMeasurements(-25.2f, 124.2f, 101.0f);
    }
}
