package com.wushuwei.biz.impl;

import com.wushuwei.biz.ISubject;

/**
 * Created by wushu on 2017/10/23.
 */
public class SubjectImpl implements ISubject {
    @Override
    public String request() {
        return "Subject do request";
    }
}
