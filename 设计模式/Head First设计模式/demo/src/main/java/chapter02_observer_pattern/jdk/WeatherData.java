package chapter02_observer_pattern.jdk;

import java.util.Observable;

/**
 * 观察者模式JDK实现
 */
public class WeatherData extends Observable {
    private float temp;
    private float humidity;
    private float pressure;

    /**
     * 测量值改变将调用的方法
     */
    public void measurementsChanged(){
        super.setChanged();
        notifyObservers();
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
