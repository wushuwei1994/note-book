package chapter02_observer_pattern.jdk;

import chapter02_observer_pattern.*;
import chapter02_observer_pattern.display.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by 吴蜀威 on 2018/2/26.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temp; // 温度
    private float humidity; // 湿度
    private float pressure; // 压强

    @Override
    public void display() {
        System.out.println("当前天气");
        System.out.println("温度:" + temp);
        System.out.println("湿度:" + humidity);
        System.out.println("气压:" + pressure);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temp = weatherData.getTemp();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
        }
        this.display();
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
