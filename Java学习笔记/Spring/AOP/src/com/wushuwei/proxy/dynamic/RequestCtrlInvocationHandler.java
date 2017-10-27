package com.wushuwei.proxy.dynamic;

import com.wushuwei.biz.IRequestable;
import com.wushuwei.biz.ISubject;
import com.wushuwei.biz.impl.RequestableImpl;
import com.wushuwei.biz.impl.SubjectImpl;
import com.wushuwei.core.model.TimeOfDay;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wushu on 2017/10/24.
 */
public class RequestCtrlInvocationHandler implements InvocationHandler{

    private Object target;

    public RequestCtrlInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("request")) {
            TimeOfDay startTime = new TimeOfDay(0, 0, 0);
            TimeOfDay endTime = new TimeOfDay(5, 59, 59);
            TimeOfDay currentTime = new TimeOfDay();
            if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
                return null;
            }
            return method.invoke(target, args);
        }
        return null;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public static void main(String[] args) {
        ISubject subject = new SubjectImpl();
        ISubject subjectProxy = (ISubject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces()
                , new RequestCtrlInvocationHandler(subject));
        System.out.println(subjectProxy.request());

        IRequestable requestable = new RequestableImpl();
        IRequestable requestableProxy = (IRequestable) Proxy.newProxyInstance(requestable.getClass().getClassLoader(),
                requestable.getClass().getInterfaces(), new RequestCtrlInvocationHandler(requestable));
        requestableProxy.request();
    }
}
