package com.java.effective.method;

import java.math.BigInteger;

/**
 * Created by wushu on 2017/5/14.
 */
public class CheckArgumentValid {
    /**
     * Returns a BigInteger
     * @param m the modules, which must be positive
     * @return this mod m
     * @throws ArithmeticException if m is less than or equal to 0
     */
    public BigInteger mod(BigInteger m) {
        if (m.signum() <= 0) {
            throw new ArithmeticException("Modulus <= 0:" + m);
        }
        //Do the computation
        return null;
    }

    public void test() {
        this.mod(new BigInteger("1"));
    }
}
