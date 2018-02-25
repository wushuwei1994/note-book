package chapter02_observer_pattern;

import chapter02_observer_pattern.display.impl.CurrentConditionDisplay;
import chapter02_observer_pattern.display.impl.ForecastDisplay;
import chapter02_observer_pattern.display.impl.StatisticsDisplay;
import chapter02_observer_pattern.observer.Observer;
import chapter02_observer_pattern.subject.Subject;

import java.util.ArrayList;

/**
 * 气象数据
 */
public class WeatherData implements Subject{

    private ArrayList observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList();
    }

    /**
     * 测量值改变将调用的方法
     */
    public void measurementsChanged(){
        notifyObservers();
    }
    /**
     * 获取实时温度
     * @return
     */
    public float getTemperature(){
        return 0.0f;
    }

    /**
     * 获取实时湿度
     * @return
     */
    public float getHumidity(){
        return 0.0f;
    }

    /**
     * 获取实时气压
     * @return
     */
    public float getPressure(){
        return 0.0f;
    }

    @Override
    public boolean registerObserver(Observer observer) {
        return observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            return observers.remove(observer);
        }
        return false;
    }

    @Override
    public void notifyObservers() {
        for (Object observer : observers) {
            ((Observer) observer).update(temp, humidity, pressure);
        }
    }

    /**
     * 模拟获取气象站数据,并实时更新数据
     * @param temp  温度
     * @param humidity  湿度
     * @param pressure 压强
     */
    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
