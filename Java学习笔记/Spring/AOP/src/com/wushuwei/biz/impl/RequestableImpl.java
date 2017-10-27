package com.wushuwei.biz.impl;

import com.wushuwei.biz.IRequestable;

/**
 * Created by wushu on 2017/10/24.
 */
public class RequestableImpl implements IRequestable {
    @Override
    public void request() {
        System.out.println("request processed in RequestableImpl");
    }
}
