ps:以下为特别要注意的规范

## 编程规约

### 命名风格

1. 常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长。
2. 抽象类命名使用Abstract或Base开头；异常类命名使用Exception结尾；测试类命名以它要测试的类的名称开始，以Test结尾。
3. 数组定义方式：String[] args; 中括号是数组类型的一部分。
4. 【强制】POJO 类中的任何布尔类型的变量，都不要加 is 前缀，否则部分框架解析会引起序列
   化错误。
   说明：在本文 MySQL 规约中的建表约定第一条，表达是与否的变量采用 is_xxx 的命名方式，所以，需要在<resultMap>设置从 is_xxx 到 xxx 的映射关系。
   反例：定义为基本数据类型 Boolean isDeleted 的属性，它的方法也是 isDeleted()，框架在反向解析的时
   候，“误以为”对应的属性名称是 deleted，导致属性获取不到，进而抛出异常。。
5. 包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用单数形式，但是类名如果有复数含义，类名可以使用复数形式。 
   正例： 应用工具类包名为 com.alibaba.open.util、类名为 MessageUtils（ 此规则参考
   spring 的框架结构）
6. 【强制】避免在子父类的成员变量之间、或者不同代码块的局部变量之间采用完全相同的命名，使可理解性降低。
   说明：子类、父类成员变量名相同，即使是 public 类型的变量也能够通过编译，另外，局部变量在同一方法内的不同代码块中同名也是合法的（如两个for循环代码块中定义变量），这些情况都要避免。对于非 setter/getter 的参数名称也要避免与成员变量名称相同。
7. 杜绝完全不规范的缩写， 避免望文不知义。
8. 【推荐】在常量与变量的命名时，表示类型的名词放在词尾，以提升辨识度。
     正例：startTime / workQueue / nameList / TERMINATED_THREAD_COUNT
     反例：startedAt / QueueOfWork / listName / COUNT_TERMINATED_THREAD
9. 如果使用到了设计模式，建议在类名中体现出具体模式。
   说明： 将设计模式体现在名字中，有利于阅读者快速理解架构设计思想。
   正例： 
   	public class OrderFactory;
   	public class LoginProxy;
   	public class ResourceObserver;
10. 接口类中的方法和属性不要加任何修饰符号（ public 也不要加） ，保持代码的简洁性，并加上有效的 Javadoc 注释。尽量不要在接口里定义变量，如果一定要定义变量，肯定是与接口方法相关，并且是整个应用的基础常量。
     正例： 接口方法签名： void f();
       接口基础常量表示： String COMPANY = "alibaba";
       反例： 接口方法定义： public abstract void f();
       说明： JDK8 中接口允许有默认实现，那么这个 default 方法，是对所有实现类都有价值的默
       认实现。
11. 接口和实现类的命名有两套规则：
      1） 【强制】对于 Service 和 DAO 类，基于 SOA （Service-Oriented Architecture ，面向服务的架构）的理念，暴露出来的服务一定是接口，内部
        的实现类用 Impl 的后缀与接口区别。
        正例： CacheServiceImpl 实现 CacheService 接口。
        2）【推荐】 如果是形容能力的接口名称，取对应的形容词做接口名 （ 通常是–able 的形式）。
        正例： AbstractTranslator 实现
12. 枚举类名建议带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。
        说明： 枚举其实就是特殊的常量类，且构造方法被默认强制是私有。
        正例： 枚举名字： DealStatusEnum， 成员名称： SUCCESS / UNKOWN_REASON。
13. 各层命名规约：
         A) Service/DAO 层方法命名规约
         1） 获取单个对象的方法用 get 做前缀。
         2） 获取多个对象的方法用 list 做前缀。
         3） 获取统计值的方法用 count 做前缀。
         4） 插入的方法用 save（ 推荐） 或 insert 做前缀。
         5） 删除的方法用 remove（ 推荐） 或 delete 做前缀。
         6） 修改的方法用 update 做前缀。
         B) 领域模型命名规约
         1） 数据对象： xxxDO， xxx 即为数据表名。
         2） 数据传输对象： xxxDTO， xxx 为业务领域相关的名称。
         3） 展示对象： xxxVO， xxx 一般为网页名称。
         4） POJO 是 DO/DTO/BO/VO 的统称，禁止命名成 xxxPOJO。

### 常量定义

1. 不允许任何魔法值（ 即未经定义的常量） 直接出现在代码中
2. long 或者 Long 初始赋值时，必须使用大写的 L，不能是小写的 l，小写容易跟数字1 混淆，造成误解。
3. 不要使用一个常量类维护所有常量，应该按常量功能进行归类，分开维护。如：缓存相关的常量放在类： CacheConsts 下； 系统配置相关的常量放在类： ConfigConsts 下。
    说明： 大而全的常量类，非得使用查找功能才能定位到修改的常量，不利于理解和维护。
4. 常量的复用层次有五层：跨应用共享常量、应用内共享常量、子工程内共享常量、包内共享常量、类内共享常量。
    1） 跨应用共享常量：放置在二方库中，通常是 client.jar 中的 constant 目录下。
    2） 应用内共享常量：放置在一方库的 modules 中的 constant 目录下。
    反例： 易懂变量也要统一定义成应用内共享常量，两位攻城师在两个类中分别定义 了
    表示“是”的变量：
    类 A 中： public static final String YES = "yes";
    类 B 中： public static final String YES = "y";
    A.YES.equals(B.YES)，预期是 true，但实际返回为 false，导致产生线上问题。
    3） 子工程内部共享常量：即在当前子工程的 constant 目录下。
    4） 包内共享常量：即在当前包下单独的 constant 目录下。
    5） 类内共享常量：直接在类内部 private static final 定义。
    ps:
    一方库：本工程中的各模块的相互依赖
    二方库：公司内部的依赖库，一般指公司内部的其他项目发布的jar包
    三方库：公司之外的开源库， 比如apache、ibm、google等发布的依赖
5. 如果变量值仅在一个范围内变化用 Enum 类。如果还带有名称之外的延伸属性，必须使用 Enum 类，下面正例中的数字就是延伸信息，表示星期几。
    正例： public Enum{ MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5),
    SATURDAY(6), SUNDAY(7);}

### 代码格式

1. 【强制】大括号的使用约定。如果是大括号内为空，则简洁地写成{}即可，不需要换行 ； 如果

是非空代码块则：
1 ） 左大括号前不换行。
2 ） 左大括号后换行。
3 ） 右大括号前换行。
4 ） 右大括号后还有 else 等代码则不换行 ； 表示终止的右大括号后必须换行。

2. 【强制】 左小括号和字符之间不出现空格 ； 同样，右小括号和字符之间也不出现空格。详见
    第 5 条下方正例提示
3. 【强制】 if / for / while / switch / do 等保留字与括号之间都必须加空格。
4. 【强制】任何二目、三目运算符的左右两边都需要加一个空格。
    说明：运算符包括赋值运算符=、逻辑运算符&&、加减乘除符号等。
5. 【强制】采用 4 个空格缩进，禁止使用 tab 字符。
    说明：如果使用 tab 缩进，必须设置 1 个 tab 为 4 个空格。
6. 【强制】注释的双斜线与注释内容之间有且仅有一个空格。
    正例： // 注释内容，注意在 // 和注释内容之间有一个空格。
7. 【强制】单行字符数限制不超过 120 个，超出需要换行，换行时遵循如下原则：
    1） 第二行相对第一行缩进 4 个空格，从第三行开始，不再继续缩进，参考示例。
    2 ） **运算符与下文一起换行**。
    3 ） 方法调用的点符号与下文一起换行。
    4 ） 方法调用时，多个参数，需要换行时，在逗号后进行。
    5 ） 在括号前不要换行，见反例。
8. 【推荐】没有必要增加若干空格来使某一行的字符与上一行对应位置的字符对齐。
9. 【推荐】方法体内的执行语句组、变量的定义语句组、不同的业务逻辑之间或者不同的语义
    之间插入一个空行。相同业务逻辑和语义之间不需要插入空行。
    说明：没有必要插入多个空行进行隔开

### OOP规约

1. 【强制】避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成本，直接用类名来访问即可

2. 【强制】所有的覆写方法，必须加@ Override 注解。

3. 【强制】相同参数类型，相同业务含义，才可以使用 Java 的可变参数，避免使用 Object 。
   说明：可变参数必须放置在参数列表的最后。（建议开发者尽量不用可变参数编程）
   正例：public List<User> listUsers(String type, Long... ids) {...}

4. 【强制】外部正在调用或者二方库依赖的接口，不允许修改方法签名，避免对接口调用方产生影响。接口过时必须加@ Deprecated 注解，并清晰地说明采用的新接口或者新服务是什么。

5. 【强制】不能使用过时的类或方法。
   说明：java.net.URLDecoder 中的方法 decode(String encodeStr) 这个方法已经过时，应该使用双参数decode(String source, String encode)。接口提供方既然明确是过时接口，那么有义务同时提供新的接口；作为调用方来说，有义务去考证过时方法的新实现是什么。

6. 【强制】 Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals 
   正例："test".equals(object);
   反例：object.equals("test");
   说明：推荐使用 JDK7 引入的工具类 java.util.Objects#equals(Object a, Object b)

7. 【强制】所有整型包装类对象之间值的比较，全部使用 equals 方法比较。

8. 【强制】任何货币金额，均以最小货币单位且整型类型来进行存储。

9. 【强制】浮点数之间的等值判断，基本数据类型不能用==来比较，包装数据类型不能用 equals来判断。
   说明：浮点数采用“尾数+阶码”的编码方式，类似于科学计数法的“有效数字+指数”的表示方式。二进制无法精确表示大部分的十进制小数，具体原理参考《码出高效》。

   ```
   反例：
   float a = 1.0F - 0.9F;
   float b = 0.9F - 0.8F;
   if (a == b) {
   // 预期进入此代码块，执行其它业务逻辑
   // 但事实上 a==b 的结果为 false
   }
   Float x = Float.valueOf(a);
   Float y = Float.valueOf(b);
   if (x.equals(y)) {
   // 预期进入此代码块，执行其它业务逻辑
   // 但事实上 equals 的结果为 false
   }
   正例：
   (1) 指定一个误差范围，两个浮点数的差值在此范围之内，则认为是相等的。
   float a = 1.0F - 0.9F;
   float b = 0.9F - 0.8F;
   float diff = 1e-6F;
   if (Math.abs(a - b) < diff) {
   System.out.println("true");
   }
   (2) 使用 BigDecimal 来定义值，再进行浮点数的运算操作。
   BigDecimal a = new BigDecimal("1.0");
   BigDecimal b = new BigDecimal("0.9");
   BigDecimal c = new BigDecimal("0.8");
   BigDecimal x = a.subtract(b);
   BigDecimal y = b.subtract(c);
   if (x.compareTo(y) == 0) {
   System.out.println("true");
   }
   ```

10. 【强制】如上所示 BigDecimal 的等值比较应使用 compareTo()方法，而不是 equals()方法。
    说明：equals()方法会比较值和精度 （1.0 与 1.00 返回结果为 false） ，而 compareTo()则会忽略精度。

11. 【强制】定义数据对象 DO 类时，属性类型要与数据库字段类型相匹配。
    正例：数据库字段的 bigint 必须与类属性的 Long 类型相对应。
    反例：某个案例的数据库表 id 字段定义类型 bigint unsigned，实际类对象属性为 Integer，随着 id 越来越大，超过 Integer 的表示范围而溢出成为负数。

12. 【强制】禁止使用构造方法 BigDecimal(double) 的方式把 double 值转化为 BigDecimal 对象。
    说明：BigDecimal(double)存在精度损失风险，在精确计算或值比较的场景中可能会导致业务逻辑异常。
    如：BigDecimal g = new BigDecimal(0.1F); 实际的存储值为：0.10000000149
    正例：优先推荐入参为 String 的构造方法，或使用 BigDecimal 的 valueOf 方法，此方法内部其实执行了
    Double 的 toString，而 Double 的 toString 按 double 的实际能表达的精度对尾数进行了截断。
    BigDecimal recommend1 = new BigDecimal("0.1");
    BigDecimal recommend2 = BigDecimal.valueOf(0.1);

13. 关于基本数据类型与包装数据类型的使用标准如下：
    1） 【强制】所有的 POJO 类属性必须使用包装数据类型。
    2） 【强制】RPC 方法的返回值和参数必须使用包装数据类型。
    3） 【推荐】所有的局部变量使用基本数据类型。
    说明：POJO 类属性没有初值是提醒使用者在需要使用时，必须自己显式地进行赋值，任何 NPE 问题，或
    者入库检查，都由使用者来保证。
    正例：数据库的查询结果可能是 null，因为自动拆箱，用基本数据类型接收有 NPE 风险。
    反例：某业务的交易报表上显示成交总额涨跌情况，即正负 x%，x 为基本数据类型，调用的 RPC 服务，调
    用不成功时，返回的是默认值，页面显示为 0%，这是不合理的，应该显示成中划线-。所以包装数据类型
    的 null 值，能够表示额外的信息，如：远程调用失败，异常退出。

14. 【强制】定义 DO/DTO/VO 等 POJO 类时，不要设定任何属性默认值。
    反例：POJO 类的 createTime 默认值为 new Date()，但是这个属性在数据提取时并没有置入具体值，在
    更新其它字段时又附带更新了此字段，导致创建时间被修改成当前时间。

15. 【强制】序列化类新增属性时，请不要修改 serialVersionUID 字段，避免反序列失败；如果
    完全不兼容升级，避免反序列化混乱，那么请修改 serialVersionUID 值。
    说明：注意 serialVersionUID 不一致会抛出序列化运行时异常。

16. 【强制】构造方法里面禁止加入任何业务逻辑，如果有初始化逻辑，请放在 init 方法中。

17. 【强制】POJO 类必须写 toString 方法。使用 IDE 中的工具：source> generate toString
    时，如果继承了另一个 POJO 类，注意在前面加一下 super.toString。
    说明：在方法执行抛出异常时，可以直接调用 POJO 的 toString()方法打印其属性值，便于排查问题。

18. 【强制】禁止在 POJO 类中，同时存在对应属性 xxx 的 isXxx()和 getXxx()方法。
    说明：框架在调用属性 xxx 的提取方法时，并不能确定哪个方法一定是被优先调用到的。

19. 【推荐】使用索引访问用 String 的 split 方法得到的数组时，需做最后一个分隔符后有无内容
    的检查，否则会有抛 IndexOutOfBoundsException 的风险。

20. 【推荐】当一个类有多个构造方法，或者多个同名方法，这些方法应该按顺序放置在一起，便
    于阅读，此条规则优先于下一条。

21. 【推荐】 类内方法定义的顺序依次是：公有方法或保护方法 > 私有方法 > getter / setter
    方法。
    说明：公有方法是类的调用者和维护者最关心的方法，首屏展示最好；保护方法虽然只是子类关心，也可
    能是“模板设计模式”下的核心方法；而私有方法外部一般不需要特别关心，是一个黑盒实现；因为承载
    的信息价值较低，所有 Service 和 DAO 的 getter/setter 方法放在类体最后。

22. 【推荐】setter 方法中，参数名称与类成员变量名称一致，this.成员名 = 参数名。在
    getter/setter 方法中，不要增加业务逻辑，增加排查问题的难度。
    反例：

    ```
    public Integer getData () {
        if (condition) {
        	return this.data + 100;
        } else {
        	return this.data - 100;
        }
    }
    ```

23. 【推荐】循环体内，字符串的连接方式，使用 StringBuilder 的 append 方法进行扩展。
    说明：下例中，反编译出的字节码文件显示每次循环都会 new 出一个 StringBuilder 对象，然后进行 append
    操作，最后通过 toString 方法返回 String 对象，造成内存资源浪费。
    反例：

    ```
    String str = "start";
    for (int i = 0; i < 100; i++) {
    	str = str + "hello";
    }
    ```

24. 【推荐】 final 可以声明类、成员变量、方法、以及本地变量，下列情况使用 final 关键字：
    1） 不允许被继承的类，如：String 类。
    2） 不允许修改引用的域对象，如：POJO 类的域变量。
    3） 不允许被覆写的方法，如：POJO 类的 setter 方法。
    4） 不允许运行过程中重新赋值的局部变量。
    5） 避免上下文重复使用一个变量，使用 final 关键字可以强制重新定义一个变量，方便更好地进行重构。
25. 【推荐】慎用 Object 的 clone 方法来拷贝对象。
    说明：对象 clone 方法默认是浅拷贝，若想实现深拷贝，需覆写 clone 方法实现域对象的深度遍历式拷贝。
26. 【推荐】类成员与方法访问控制从严：
    1） 如果不允许外部直接通过 new 来创建对象，那么构造方法必须是 private。
    2） 工具类不允许有 public 或 default 构造方法。
    3） 类非 static 成员变量并且与子类共享，必须是 protected。
    4） 类非 static 成员变量并且仅在本类使用，必须是 private。
    5） 类 static 成员变量如果仅在本类使用，必须是 private。
    6） 若是 static 成员变量，考虑是否为 final。
    7） 类成员方法只供类内部调用，必须是 private。
    8） 类成员方法只对继承类公开，那么限制为 protected。
    说明：任何类、方法、参数、变量，严控访问范围。过于宽泛的访问范围，不利于模块解耦。思考：如果
    是一个 private 的方法，想删除就删除，可是一个 public 的 service 成员方法或成员变量，删除一下，不
    得手心冒点汗吗？变量像自己的小孩，尽量在自己的视线内，变量作用域太大，无限制的到处跑，那么你
    会担心的。

###集合处理

###并发处理

###控制语句

###注释规约


###其它 




