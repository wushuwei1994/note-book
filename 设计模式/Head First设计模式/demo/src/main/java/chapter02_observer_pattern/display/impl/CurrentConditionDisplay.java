package chapter02_observer_pattern.display.impl;

import chapter02_observer_pattern.display.DisplayElement;
import chapter02_observer_pattern.observer.Observer;

/**
 * 目前状况展示板
 */
public class CurrentConditionDisplay implements Observer,DisplayElement{
    private float temp; // 温度
    private float humidity; // 湿度
    private float pressure; // 压强

    /**
     * 气象站监测值改变
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure 压强
     */
    @Override
    public void update(float temp, float humidity, float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
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

    @Override
    public void display() {
        System.out.println("当前天气");
        System.out.println("温度:" + temp);
        System.out.println("湿度:" + humidity);
        System.out.println("气压:" + pressure);
    }
}
