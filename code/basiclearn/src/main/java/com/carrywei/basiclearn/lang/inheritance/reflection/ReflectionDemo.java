package com.carrywei.basiclearn.lang.inheritance.reflection;

import com.carrywei.basiclearn.lang.inheritance.Employee;
import com.carrywei.basiclearn.lang.inheritance.Manager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wushuwei on 2020/7/13.
 * 描述：
 */
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Employee e = new Employee();
        System.out.println(e.getClass().getName()); // com.carrywei.basiclearn.lang.inheritance.Employee
        e = new Manager();
        System.out.println(e.getClass().getName()); // com.carrywei.basiclearn.lang.inheritance.Manager

        // 虚拟机为每个类型管理一个Class对象 。因此 ，可以利用 = 运算符实现两个类对象比较的操作
        Employee e1 = new Manager();
        System.out.println(e.getClass() == e1.getClass()); // true

        e1 = new Employee();
        System.out.println(e.getClass() == e1.getClass()); // false

        Class employeeClass = Class.forName("com.carrywei.basiclearn.lang.inheritance.Employee");
        System.out.println(employeeClass == e1.getClass()); // true

        System.out.println(e1.getClass() == Employee.class); // true

        Employee newEmployee = (Employee)employeeClass.newInstance();
        System.out.println(newEmployee.getSalary()); // 0

        // 通过class对象创建实例，只能调用无参构造函数，即默认的方法
        Employee employee = (Employee)employeeClass.newInstance();

        /**
         * 会抛异常：java.lang.NoSuchFieldException。因为name为Employee的私有变量，
         * 不能直接通过getField方法获取
         */
//        Field field = Employee.class.getField("name");
        Field field = Employee.class.getDeclaredField("name");

        /**
         * 会抛异常：in thread "main" java.lang.IllegalAccessException: Class ReflectionDemo
         * can not access a member of Employee with modifiers "private"
         */
//        System.out.println(field.get(employee));
        field.setAccessible(true);
        System.out.println(field.get(employee)); // null

        // 基本数据类型int,可用 int.class 或 Integer.TYPE
        Constructor constructor = Employee.class.getConstructor(String.class, Integer.TYPE);
        Employee e2 = (Employee) constructor.newInstance("Bob", 5000);
        System.out.println(e2.getName()); // Bob

        Method method = Employee.class.getMethod("getName", null);
        System.out.println(method.getDeclaringClass().getName()); // com.carrywei.basiclearn.lang.inheritance.Employee
        // 如果是调用静态方法，则invoke第一个参数obj传null
        System.out.println(method.invoke(e2)); // Bob
    }
}
