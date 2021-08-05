package com.carrywei.understanding.jvm.outofmemory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wushuwei
 * @Description 堆内存溢出测试，jvm参数配置为：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError，执行程序将会抛出内存溢出错误：java.lang.OutOfMemoryError: Java heap space
 * -Xms20m 堆最小值20m
 * -Xmx20m 堆最大值20m
 * +HeapDumpOnOutOf-MemoryError可以让虚拟机在出现内存溢出异常的时候Dump出当前的内存堆转储快照以便进行事后分析
 * 用法: java [-options] class [args...]
 *            (执行类)
 *    或  java [-options] -jar jarfile [args...]
 *            (执行 jar 文件)
 * @Date 2020/11/4
 **/
public class HeapOOM {
    static class OOMObject {
    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
