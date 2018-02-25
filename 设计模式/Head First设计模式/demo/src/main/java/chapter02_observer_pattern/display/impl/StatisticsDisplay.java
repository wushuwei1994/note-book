package chapter02_observer_pattern.display.impl;

import chapter02_observer_pattern.display.DisplayElement;
import chapter02_observer_pattern.observer.Observer;

/**
 * 气象统计展示板
 */
public class StatisticsDisplay  implements Observer,DisplayElement {
    private float temp; // 温度
    private float humidity; // 湿度
    private float pressure; // 压强

    /**
     * 气象站监测值改变
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure 压强
     */
    public void update(float temp, float humidity, float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        // 其他实现逻辑
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
        System.out.println("暂时不做显示...");
    }
}
