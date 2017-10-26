package com.wushuwei.proxy;

import com.wushuwei.biz.ISubject;
import com.wushuwei.biz.impl.SubjectImpl;
import com.wushuwei.core.model.TimeOfDay;

/** ISubject 代理类，限制时间访问
 * Created by wushu on 2017/10/23.
 */
public class ServiceControlSubjectProxy implements ISubject {
    private ISubject subject;

    public ServiceControlSubjectProxy(ISubject subject) {
        this.subject = subject;

    }
    @Override
    public String request() {
        TimeOfDay startTime = new TimeOfDay(0, 0, 0);
        TimeOfDay endTime = new TimeOfDay(5, 59, 59);
        TimeOfDay currentTime = new TimeOfDay();
        if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
            return null;
        }
        String originalResult = this.subject.request();
        return "proxy:" + originalResult;
    }

    public static void main(String[] args) {
        ISubject target = new SubjectImpl();
        ISubject finalSubject = new ServiceControlSubjectProxy(target);
        System.out.println(finalSubject.request());
    }
}
