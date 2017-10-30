package com.wushuwei.core.model;

import java.util.Calendar;

/**
 * Created by wushu on 2017/10/23.
 */
public class TimeOfDay {
    private int hour; // 小时
    private int minute; // 分钟
    private int second; // 秒

    public TimeOfDay(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /**
     * 当前时间
     */
    public TimeOfDay() {
        this.hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        this.minute = Calendar.getInstance().get(Calendar.MINUTE);
        this.second = Calendar.getInstance().get(Calendar.SECOND);
    }

    /**
     * 输出格式 00:00:00
     * @return
     */
    @Override
    public String toString() {
        return (hour < 10 ? "0" : "") + hour
                + ":" + (minute < 10 ? "0" : "") + minute
                + ":" + (second < 10 ? "0" : "") + second;
    }

    /**
     * 是否在timeOfDay时间之后（包含timeOfDay）
     * @param timeOfDay 时间
     * @return
     */
    public boolean isAfter(TimeOfDay timeOfDay) {
        if (this.hour == timeOfDay.getHour()) {
            if (this.minute == timeOfDay.getMinute()) {
                return this.second >= timeOfDay.getSecond();
            }
            return this.minute > timeOfDay.getMinute();
        }
        return this.hour > timeOfDay.getHour();
    }

    /**
     * 是否在timeOfDay时间之前
     * @param timeOfDay 时间
     * @return
     */
    public boolean isBefore(TimeOfDay timeOfDay) {
        if (this.equals(timeOfDay)) {
            return true;
        }
        return !this.isAfter(timeOfDay);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        TimeOfDay timeOfDay = (TimeOfDay) object;
        return this.hour == timeOfDay.getHour()
                && this.minute == timeOfDay.getMinute()
                && this.second == timeOfDay.getSecond();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = hash * 31 + hour;
        hash = hash * 31 + minute;
        hash = hash * 31 + second;
        return hash;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public static void main(String[] args) {
//        TimeOfDay timeOfDay = new TimeOfDay();
//        System.out.println(timeOfDay.getHour() + ":" + timeOfDay.getMinute() + ":" + timeOfDay.getSecond());
//        TimeOfDay time2 = new TimeOfDay(10, 12, 13);
//        TimeOfDay time3 = new TimeOfDay(10, 12, 14);
//        System.out.println(new TimeOfDay().equals(new TimeOfDay()));
//        System.out.println(time2.isAfter(time3));
//        System.out.println(time2.isBefore(time3));
        TimeOfDay timeOfDay = new TimeOfDay();
        TimeOfDay myTimeOfDay = new TimeOfDay(timeOfDay.getHour(), timeOfDay.getMinute(), timeOfDay.getSecond());
        System.out.println(timeOfDay.equals(timeOfDay));
        System.out.println(timeOfDay.equals("a"));

        //hash code
        System.out.println("a".hashCode());
        System.out.println("a".hashCode());

        System.out.println(new Integer(300).hashCode());

        System.out.println(timeOfDay + " hash code : " + timeOfDay.hashCode());
        System.out.println(myTimeOfDay + " hash code : " + myTimeOfDay.hashCode());
    }
}
