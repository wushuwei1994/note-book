package com.java.effective.method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wushuwei on 2017/4/6.
 * 第43条:返回零长度的数组或者集合
 */
public class Store {
    private final List<Cheese> chesesInStock = new ArrayList<>();
    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
    /**
     * 返回零长度数组的标准做法
     */
    public Cheese[] getCheeses(){
        return chesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }

    /**
     * 返回零长度的空集合标准做法:Collections.emptyList、emptySet、emptyMap
     */
    public List<Cheese> getCheeseList(){
        if(chesesInStock.isEmpty()){
            return Collections.emptyList();
        }else{
            return new ArrayList<Cheese>(chesesInStock);
        }
    }
}
