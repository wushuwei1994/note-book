package com.carrywei.basiclearn.lang.inheritance.reflection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wushuwei on 2020/7/13.
 * 描述：
 */
public class ReflectionTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Double d = 1.2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter class name (eg.java.lang.Double):");
        String className = scanner.next();
        try {
            Class clazz = Class.forName(className);
            StringBuilder sb = new StringBuilder();
            // 类修饰符
            sb.append(getModifierString(clazz.getModifiers()));
            sb.append(" ");
            sb.append(clazz.getName());
            if (clazz.getSuperclass() != null) {
                sb.append(" extends ");
                sb.append(clazz.getSuperclass().getName());
            }
            Class[] interfaceClazz = clazz.getInterfaces();
            if (interfaceClazz != null && interfaceClazz.length > 0) {
                sb.append(" implements ");
                for (int i = 0; i < interfaceClazz.length; i++) {
                    sb.append(interfaceClazz[i].getName());
                    if (i != interfaceClazz.length - 1) {
                        sb.append(", ");
                    }
                }
            }
            sb.append("\n");
            sb.append("{\n");

            // 获取各成员变量
            Field[] fields = clazz.getFields();
            for (int i = 0; i < fields.length; i++) {
                sb.append("\t");
                sb.append(fieldString(fields[i]));
                sb.append(";\n");
            }

            // 获取构造函数
            Constructor[] constructors = clazz.getConstructors();

            for (int i = 0; i < constructors.length; i++) {
                sb.append("\t");
                sb.append(constructorString(constructors[i]));
                sb.append(";\n");
            }

            // 获取方法
            Method[] methods = clazz.getMethods();
            for (int i = 0; i < methods.length; i++) {
                sb.append("\t");
                sb.append(methodString(methods[i]));
                sb.append(";\n");
            }

            sb.append("}");


            System.out.println(sb.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getModifierString(int mod) throws InvocationTargetException, IllegalAccessException {
        Modifier.toString(mod);
        ArrayList<String> modifiers = new ArrayList<>();
        Class modifierClass = Modifier.class;
        Method[] methods = modifierClass.getMethods();
        for (Method method : methods) {
            // 判断该方法是为「判断是否为修饰」的方法，如isPublic
            String methodName = method.getName();
            if (methodName.startsWith("is")) {
                boolean isModifier = (boolean)method.invoke(null, mod);
                if (isModifier) {
                    modifiers.add(methodName.replace("is", "").toLowerCase());
                }
            }
        }
        return String.join(" ", modifiers);
    }

    public static String fieldString(Field field) throws InvocationTargetException, IllegalAccessException {
        String modifierStr = getModifierString(field.getModifiers());
        String declaringClassName = field.getDeclaringClass().getName();
        return modifierStr + " " + declaringClassName + " " + field.getName();
    }

    public static String constructorString(Constructor constructor) throws InvocationTargetException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        String modifierStr = getModifierString(constructor.getModifiers());
        sb.append(modifierStr).append(" ").append(constructor.getName());
        sb.append("(");
        Class[] parameterTypes = constructor.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            sb.append(parameterTypes[i].getName());
            sb.append(" arg" + i);
            if(i != parameterTypes.length - 1)
            {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
    public static String methodString(Method method) throws InvocationTargetException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        String modifierStr = getModifierString(method.getModifiers());
        sb.append(modifierStr).append(" ")
                .append(method.getReturnType().getName())
                .append(method.getName());
        sb.append("(");
        Class[] parameterTypes = method.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            sb.append(parameterTypes[i].getName());
            sb.append(" arg" + i);
            if(i != parameterTypes.length - 1)
            {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
