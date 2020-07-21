package com.carrywei.basiclearn.lang.obj;

/**
 * Created by wushuwei on 2020/7/12.
 * 描述：
 */
class Super {
    String name ;
    public Super(String name)
    {
        this.name = name ;
    }
    public void fun1()
    {
        System.out.println("this is class super !"+name);
    }
}
 class Sub extends Super{
    public Sub() {
        super("abc");
    }

   public void fun1() {
        System.out.println("this is class sub !" + name);
    }
}
class Test {
    public static void main(String args[]) {
        Super s = new Sub();
        s.fun1();
    }
}

