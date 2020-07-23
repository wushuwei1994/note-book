package com.carrywei.basiclearn.lang.log;

import java.util.logging.Logger;

/**
 * Created by wushuwei on 2020/7/23.
 * 描述：
 */
public class LoggerDemo {
    private static Logger logger = Logger.getLogger("com.carrywei.basiclearn.lang.log.LoggerDemo");
    public static void main(String[] args) {
        System.out.println("sout");
        Logger.getGlobal().info("全局日志");
        logger.info("日志记录器日志");
    }
}
