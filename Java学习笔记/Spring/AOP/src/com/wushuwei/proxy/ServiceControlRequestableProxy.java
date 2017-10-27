package com.wushuwei.proxy;

import com.wushuwei.biz.IRequestable;
import com.wushuwei.biz.impl.RequestableImpl;
import com.wushuwei.core.model.TimeOfDay;

/**
 * Created by wushu on 2017/10/24.
 */
public class ServiceControlRequestableProxy implements IRequestable {

    private IRequestable requestable;

    public ServiceControlRequestableProxy(IRequestable requestable) {
        this.requestable = requestable;
    }

    @Override
    public void request() {
        TimeOfDay startTime = new TimeOfDay(0, 0, 0);
        TimeOfDay endTime = new TimeOfDay(5, 59, 59);
        TimeOfDay currentTime = new TimeOfDay();
        if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
            return ;
        }
        requestable.request();
    }

    public IRequestable getRequestable() {
        return requestable;
    }

    public void setRequestable(IRequestable requestable) {
        this.requestable = requestable;
    }

    public static void main(String[] args) {
        IRequestable target = new RequestableImpl();
        IRequestable proxy = new ServiceControlRequestableProxy(target);
        proxy.request();
    }
}
