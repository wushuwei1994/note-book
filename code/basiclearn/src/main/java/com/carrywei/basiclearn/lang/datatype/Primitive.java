package com.carrywei.basiclearn.lang.datatype;

/**
 * Created by wushuwei on 2020/7/10.
 * 描述：
 */
public class Primitive {
    public static void method(long num) {

    }
    public static void main(String[] args) {
        // 整形基本类型
        int intNum = 1_1;

        byte byteNum = 011;

        short shortNum = 1;

        long longNum = 1L;

        // 十六进制表示

        intNum = 0xA;
        System.out.println(intNum); //输出 10

        // 八进制
        intNum = 012;
        System.out.println(intNum); //输出 10

        // 二进制
        intNum = 0b10;
        System.out.println(intNum); //输出2

        // 浮点数

        //单精度浮点数，精度为6-7位，下面情况数据会丢失精度
        float floatNum = 1.212345678741F;
        System.out.println(floatNum); // 输出：1.2123457

        //双精度浮点数，精度为15位，超过也会丢失精度
        double doubleNum = 1.24564578987987123121231;
        System.out.println(doubleNum); // 输出：1.2456457898798712

        // 浮点数采用二进制系统表示，下面示例会出现不能精确计算
        System.out.println(2 - 1.1); // 结果：0.8999999999999999

        // 字符类型 char
        // 《java核心技术》强烈建议不要在程序中使用 char 类型 ， 除非确实需要处理 UTF - 16 代码单元最好将字符串作为抽象数据类型处理
        char c = 'A';
        System.out.println(c);
        // Unicode字符也可以用一个char值描述
        c = '\u2122';
        System.out.println(c); // 输出：™

        System.out.println("\u2122"); // 输出：™

        /**
         * unicode注意事项：
         * Unicode 转义序列会在解析代码之前得到处理 。 例如
         * ， " \u0022 + \u0022 ”
         * 并不是一
         * 个由引号 （ U + 0022 ) 包围加号构成的字符串 。 实际上 ， \ u 0022 会在解析之前转换为 " ， 这
         * 会 得 到 也 就 是 一 个 空 串 。
         * 更隐秘地 ， 一定要当心注释中的 \ u
         * 。 注释
         * / / \ u 00 A 0 is a newline
         * 会产生一个语法错误 ， 因为读程序时 \ u 00 A 0 会替换为一个换行符类似地 ， 下面这
         * 个注释
         * // Look inside c : \ users
         * 也会产生一个语法错误 ， 因为 \ u 后面并未跟着 4 个十六进制数 , ,
         */

        System.out.println("\u0022 + \u0022 "); // 结果为：

        // 注释 \u00A0 is a newline
        System.out.println("报错了");

        // 基本数据类型，可以互相转换,但是可能出现精度丢失问题
        char ch1 = (char) 1231212123;
        System.out.println(ch1); //输出：칛
        int num1 = (int) '칛';
        System.out.println(num1); // 输出：52827

        int k = 0;
        System.out.print("k = ");
        System.out.println(++k + k++ + ++k +k); // 1 + 1 + 3 + 3 = 8

        int n = 1;
        int m = n++ + (++n) + n; // 1 + 3 + 3 = 7
        System.out.println(m); // 7
        n = 1;
        System.out.println(n++ + ++n); // 1 + 3 = 4
        System.out.println(n); // 3

        int i = 3;
        System.out.println(--i - ++i + i++); // 2 - 3 + 3 = 2

        i = 3;
        System.out.println(i++ + --i - ++i); // 3 + 3 - 4 = 2
        //

        i = 3;
        System.out.println(i++ + --i - ++i + i++); // 3 + 3 - 4 + 4 = 6

        i = 3;
        System.out.println(i++ + i++); // 3 + 4 = 7
        System.out.println(i); // 5

        i = 3;
        System.out.println(i++ + ++i); // 3 + 5 = 8
        System.out.println(i); // 5

        i = 3;
        System.out.println(++i + ++i); // 4 + 5 = 9
        System.out.println(i); // 5

        i = 3;
        System.out.println(i + i++ + --i); // 3 + 3 + 3 = 9
        System.out.println(i); // 2

        int j = 6;
        k = (j++)- (--j) + (j++)  +j - (--j)   ; // 6 - 6 + 6 + 7 - 6 =7
        System.out.println(k);

        j = 6;
        k = j++  +j   ; //  6 + 7 = 13
        System.out.println(k); //13

    }
}
