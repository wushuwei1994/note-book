package com.carrywei.basiclearn.lang.obj;

import com.carrywei.basiclearn.lang.PackageScopeTest2;
import com.carrywei.basiclearn.lang.obj.subpackage.PackageScopeTest1;

/**
 * Created by wushuwei on 2020/7/12.
 * 描述：
 */
public class PackageScope {
    public void test() {
        // 可以访问同一个包（不包括子包和父包）下面用default修饰（等于不写修饰）的方法。这也从侧面说明，子包、父包，当前包，这是三个不同的包
        new PackageScopeTest().test();
//        new PackageScopeTest1().test(); //不能这样访问,编译错误
//        new PackageScopeTest2().test(); // 不能这样访问,编译错误
    }
}
