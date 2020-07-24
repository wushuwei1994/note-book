### Java核心技术知识点

##### Java的基本程序设计结构

1. JDK 5.0 中引入 StringBuilder 类 。 这个类的前身是 StringBuffer ,其效率稍有些低，但允许采用多线程的方式执行添加或删除字符的操作。 如果所有字符串在一个单线程中编辑 （ 通常都是这样 )，则应该用 StringBuilder 替代它 。 这两个类的 AP 丨是相同的 。

> String 字符串常量
> StringBuffer 字符串变量（线程安全）
> StringBuilder 字符串变量（非线程安全）

2. 优先级最高的两个运算符及结合性

   ​	1）[ ] . () （方法调用）       从左向右
   
   ​	2）！~ ++ -- +（一元运算）-（一元运算）()（强制类型转换 ）new   从右向左

##### 对象与类

1. 类之 最常见的关系有

   * 依赖 （ “uses - a ” ），B对象方法操作了A对象，则B依赖A
   * 聚合 （“ has - a ” ）, 类 A 的对象包含类 B 的对象，则为聚合关系
   * 继承 （“is - a ” ），类B继承了类A，则可以说B 是 A

2. 有些类有多个构造器或多个相同名的方法，这种特征叫做**重载（overloading）**

3. 调用构造器的具体处理步骤 ：

   ​	0 ）静态化初始块先执行

   ​	1 ) 所有数据域被初始化为默认值 （ 0、 false 或null )。

   ​	2 ) 按照在类声明中出现的次序 ， 依次执行所有域初始化语句和初始化块 。

   ​	3 ) 如果构造器第一行调用了第二个构造器， 则执行第二个构造器主体
   
   ​	4 ) 执行这个构造器的主体 

4. 可以访问同一个包（不包括子包和父包）下面用default修饰（等于不写修饰）的方法。这也从侧面说明，子包、父包，当前包，这是三个不同的包
5. 类设计的一些常用技巧：
   *  一定要保证数据私有
   * 一定要对数据初始化
   * 不要在类中使用过多的基本类型， 用其他的类代替多个相关的基本类型的使用。
   * 不是所有的域都需要独立的域访问器和域更改器（域，表示字段；域访问器，即getter方法；域更改器，即setter方法）
   *  将职责过多的类进行分解
   * 类名和方法名要能够体现它们的职责
   * 优先使用不可变的类

##### 继承（inheritance）

1. 专业描述：已存在的类称为超类( superclass )、基类 （ base class ) 或父类 （ parent class ) ; 新类称为子类 （ subclass )、派生类( derived class ) 或孩子类 （ child class )。通常使用超类和子类描述继承关系。

2. 子类不能直接访问父类的私有域

3. 如果子类的构造器没有显式地调用超类的构造器 ， 则将自动地调用超类默认 （ 没有参数 )的构造器。如果超类没有不带参数的构造器 ， 并且在子类的构造器中又没有显式地调用超类的其他构造器 ， 则 Java 编译器将报告错误。

4. 多态。有一个用来判断是否应该设计为继承关系的简单规则 ， 这就是 “ is - a ” 规则 ， 它表明子类的每个对象也是超类的对象 。 例每个经理都是雇员 ， 因此 ， 将 Manager 类设计为 Employee 类的子类是显而易见的 ， 反之不然 ， 并不是每一名雇员都是经理。

5. ArrayStoreException异常

   ```
   Manager[] staffs = new Manager[10];
   Employee[] employees = staffs;
   employees[0] = new Employee(); // 运行时抛出异常
   ```

6. 在覆盖一个方法的时候， 子类方法不能低于超类方法的可见性 。 特别是 ，如果超类方法是public , 子类方法一定要声明为 public，否则编译报错。试想一下，如果是多态的情况下，在调用父类的public方法时，并不能实际调用子类的方法。

7. instanceof使用方法

   ```
   Employee employee = new Manager();
   System.out.println(employee instanceof Employee); // true
   System.out.println(employee instanceof Manager); // true
   
   Employee employee1 = new Employee();
   System.out.println(employee1 instanceof Employee); // true
   System.out.println(employee1 instanceof Manager); //false
   ```

8. 强制类型转换：只能在继承层次内进行类型转换 。 在将超类转换成子类之前 ， 应该使用instanceof 进行检查。但是都不推荐使用。

9. Java 用于控制可见性的 4 个访问修饰符 ：

   1 ) 仅对本类可见——private
   2 ) 对所有类可见—— public ：
   3 ) 对本包和所有子类可见——protected。
   4 ) 对本包可见——默认 

10. 枚举 enum

    * 枚举可以没有构造函数；如果声明构造函数，构造函数必为私有的（可以不写，默认为私有）

    ```
    enum Size{
        SMALL, MEDIUM, LARGE, EXTRA_LAGER;
    }
    ```

    * 枚举常用方法

      * static Enum valueOf ( Class enumClass , String name )
        返回指定名字 、 给定类的枚举常量

      * String toString ()

        返回枚举常量名

      * int ordinal ( )
        返回枚举常量在 enum 声明中的位置， 位置从0 开始计数
        
      *  int compareTo ( E other )
        如果枚举常量出现在 Other 之前， 则返回一个负值 ； 如果 this = other ， 则返回0 ; 否则 ，
        返回正值。 枚举常量的出现次序在enum 声明中给出
      
      ```
      public class EnumTest {
          public static void main(String[] args) {
              System.out.println(Size.SMALL.getAbbreviation()); // S
              System.out.println(Size.valueOf("LARGE")); // LARGE
              System.out.println(Enum.valueOf(Size.class, "SMALL")); // SMALL
              System.out.println(Size.SMALL.compareTo(Size.LARGE)); // -2
      
              System.out.println(Size.getByAbbreviation("M")); // MEDIUM
      
              System.out.println(Size.SMALL.ordinal()); // 0
      
              System.out.println(Size.EXTRA_LAGER == Size.getByAbbreviation("XL")); // true
      
          }
      }
      enum Size{
          SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LAGER("XL");
      
          private String abbreviation;
      
          Size(String abbreviation) {
              this.abbreviation = abbreviation;
          }
      
          public String getAbbreviation() {
              return this.abbreviation;
          }
      
          public static Size getByAbbreviation(String abbreviation) throws RuntimeException{
              for (Size e : Size.values()) {
                  if (e.getAbbreviation().equals(abbreviation)) {
                      return e;
                  }
              }
              throw new RuntimeException("Not Found Enum");
          }
      
      }
      ```
    
11. 反射

    * 基本用法

    ```
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
    ```

    * 获取class对象相关属性

    ```
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
    ```

    * 通过反射获取对象成员变量内容或调用指定方法

    ```
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
    ```

##### 接口、lambda表达式和内部类

1. 常用函数式接口

| 参数类型 | 返回类型 | 抽象方法名 | 描述                         | 其他方法                     | 函数式接口               |
| -------- | -------- | ---------- | ---------------------------- | ---------------------------- | ------------------------ |
| 无       | void     | run        | 作为无参数或返回值的动作运行 |                              | Runnable                 |
| 无       | T        | get        | 提供一个 T 类型的值          |                              | Supplier < T >           |
| T        | void     | accept     | 处理 一个 T 类铟的值         | andThen                      | Consumer < T >           |
| T, U     | void     | accept     | 处理 T 和 U 类型的值         | andThen                      | BiConsumer < T , U >     |
| T        | R        | appley     | 有一个 T 类 型参数的函数     | compose , andThen , identity | Function < T , R >       |
| T, U     | R        | appley     | 有 T 和 U 类型参数的函数     | andThen                      | BiFunction < T , U , R > |
| T        | T        | appley     | 类型 T 上的一元操作符        | compose , andThen , identity | UnaryOperator < T >      |
| T, T     | T        | appley     | 类型 T 上的二元操作符        | andThen , max By , minBy     | BinaryOperator < T >     |
| T        | boolean  | test       | 布尔值函数                   | and , or , negate , isEqual  | Predicate < T >          |
| T,U      | boolean  | test       | 有两个参数的布尔值函数       | and , or , negate            | BiPredicate < T , U >    |

2. 内部类既可以访问自身的数据域 ， 也可以访问创建它的外围类对象的数据域 (包括私有域)。 内部类的对象总有一个隐式引用， 它指向了创建它的外部类对象。
3. 只有内部类可以是私有类 ， 而常规类只可以具有包可见性 ， 或公有可见性 。

4. 内部类的特殊语法规则

   ```
   // 1.内部类引用外部类成员变量：OuterClass.this.field
   OuterClass.this.num;
   // 2.外部类引用内部类对象：outerObj.new InnerClass();
   this.new InnerClass();
   new OuterClass().new InnerClass();
   ```

5. 内部类中声明的所有静态域都必须是 final 。 原因很简单 。 我们希望一个静态域只有一个实例 ， 不过对于每个外部对象 ， 会分别有一个单独的内部类实例 。 如果这个域不是 final , 它可能就不是唯一的。