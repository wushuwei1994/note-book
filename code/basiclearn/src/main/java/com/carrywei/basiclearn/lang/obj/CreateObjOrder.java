package com.carrywei.basiclearn.lang.obj;

/**
 * 类创建顺序
 * 描述：
 */
public class CreateObjOrder {

    {
        System.out.println("初始化块");
    }

    static {
        System.out.println("静态化初始快");
    }

    private AnotherObj anotherObj = new AnotherObj();
    private int len = anotherObj.getInt();

    public CreateObjOrder() {
        System.out.println("CreateObjOrder 构造器");
        System.out.println(len);
    }

    public static void main(String[] args) {
        new CreateObjOrder();
    }
}

class AnotherObj {
    public int getInt(){
        System.out.println("AnotherObj method");
        double d = Math.random();
        int result = (int) (d * 10);
        return result;
    }

    public AnotherObj(){
        System.out.println("AnotherObj 构造器");
    }
}
