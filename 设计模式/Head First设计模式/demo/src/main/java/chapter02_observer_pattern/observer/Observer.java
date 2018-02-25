package chapter02_observer_pattern.observer;

/**
 * 观察者（展示板）接口，所有潜在的观察者都需要实现观察者接口。这个接口只有update方法，当主题状态改变时它被调用
 */
public interface Observer {
    /**
     * 气象站监测值改变
     * @param temp  温度
     * @param humidity  湿度
     * @param pressure 压强
     */
    void update(float temp, float humidity, float pressure);
}
