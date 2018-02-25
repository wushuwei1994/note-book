package chapter02_observer_pattern.subject;

import chapter02_observer_pattern.observer.Observer;

/**
 * 主题接口，对象使用此接口注册为观察者，或者把自己从观察中删除
 */
public interface Subject {
    /**
     * 将潜在的观察者注册为观察者
     * @param observer 潜在观察者
     * @return
     */
    boolean registerObserver(Observer observer);

    /**
     * 将观察者从主题移除
     * @param observer 移除相应的观察者
     * @return
     */
    boolean removeObserver(Observer observer);

    /**
     * 状态改变时更新所有当前观察者
     */
    void notifyObservers();
}
