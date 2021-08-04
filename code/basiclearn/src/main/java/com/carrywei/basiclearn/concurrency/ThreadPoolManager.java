package com.carrywei.basiclearn.concurrency;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wushuwei on 2020/8/18.
 * 描述：
 */
public class ThreadPoolManager {
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
            10, 10, TimeUnit.HOURS, null);

    private static final ThreadPoolManager instance = new ThreadPoolManager();
    private ThreadPoolManager() {

    }

    public static ThreadPoolManager getInstance() {
        return instance;
    }

    public ThreadPoolExecutor getThreadPoolExecutor(){
        return this.threadPoolExecutor;
    }

    public static void main(String[] args) {
        ThreadPoolManager.getInstance().threadPoolExecutor.execute(null);
    }
}
