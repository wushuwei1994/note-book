package chapter02_observer_pattern;

import chapter02_observer_pattern.display.impl.CurrentConditionDisplay;
import chapter02_observer_pattern.display.impl.StatisticsDisplay;
import chapter02_observer_pattern.observer.Observer;

/**
 * 气象站
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Observer currentConditionDisplay = new CurrentConditionDisplay();
        Observer staticsDisplay = new StatisticsDisplay();
        weatherData.registerObserver(currentConditionDisplay);
        weatherData.registerObserver(staticsDisplay);
        weatherData.setMeasurements(25.2f, 124.2f, 101.0f);
        weatherData.setMeasurements(-25.2f, 124.2f, 101.0f);
    }
}
