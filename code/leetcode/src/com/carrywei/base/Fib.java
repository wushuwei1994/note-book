package com.carrywei.base;

/**
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列，因数学家莱昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”，
 * 指的是这样一个数列：0、1、1、2、3、5、8、13、21、34、……在数学上，斐波那契数列以如下被以递推的方法定义：
 * F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）
 **/
public class Fib {
    /**
     * 递归方式
     * @param n
     * @return
     */
    public long fibRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    public static Long[] buff = new Long[51];

    /**
     * 递归缓存方式
     * @param n
     */
    public long fibRecursionWithBuff(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (buff[n] != null) {
            return buff[n];
        }
        buff[n] = fibRecursionWithBuff(n - 1) + fibRecursionWithBuff(n - 2);
        return buff[n];
    }

    /**
     * 动态规划方式
     * @param n
     * @return
     */
    public long fib(int n) {
        long[] fibNum = new long[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        fibNum[0] = 0;
        fibNum[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibNum[i] = fibNum[i - 1] + fibNum[i - 2];
        }
        return fibNum[n];
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
//        System.out.println(fib.fibRecursion(50));
        System.out.println(fib.fibRecursionWithBuff(50));
        System.out.println(fib.fib(50));
    }
}
