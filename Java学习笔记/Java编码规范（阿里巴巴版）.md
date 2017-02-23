ps:以下为特别要注意的规范
##编程规范
###命名规范
1. 常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长。
2. 抽象类命名使用Abstract或Base开头；异常类命名使用Exception结尾；测试类命名以它要测试的类的名称开始，以Test结尾。
3. 数组定义方式：String[] args; 中括号是数组类型的一部分。
4. POJO 类中布尔类型的变量，都不要加 is，否则部分框架解析会引起序列化错误。 
   反例： 定义为基本数据类型 boolean isSuccess； 的属性，它的方法也是 isSuccess()， RPC框架在反向解析的时候， “以为”对应的属性名称是 success，导致属性获取不到，进而抛出异常。
5. 包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用单数形式，但是类名如果有复数含义，类名可以使用复数形式。 
   正例： 应用工具类包名为 com.alibaba.open.util、类名为 MessageUtils（ 此规则参考
spring 的框架结构）
6. 杜绝完全不规范的缩写， 避免望文不知义。
7. 如果使用到了设计模式，建议在类名中体现出具体模式。
   说明： 将设计模式体现在名字中，有利于阅读者快速理解架构设计思想。
   正例： 
		public class OrderFactory;
		public class LoginProxy;
		public class ResourceObserver;
8. 接口类中的方法和属性不要加任何修饰符号（ public 也不要加） ，保持代码的简洁性，并加上有效的 Javadoc 注释。尽量不要在接口里定义变量，如果一定要定义变量，肯定是与接口方法相关，并且是整个应用的基础常量。
正例： 接口方法签名： void f();
接口基础常量表示： String COMPANY = "alibaba";
反例： 接口方法定义： public abstract void f();
说明： JDK8 中接口允许有默认实现，那么这个 default 方法，是对所有实现类都有价值的默
认实现。
9. 接口和实现类的命名有两套规则：
1） 【强制】对于 Service 和 DAO 类，基于 SOA （Service-Oriented Architecture ，面向服务的架构）的理念，暴露出来的服务一定是接口，内部
的实现类用 Impl 的后缀与接口区别。
正例： CacheServiceImpl 实现 CacheService 接口。
2）【推荐】 如果是形容能力的接口名称，取对应的形容词做接口名 （ 通常是–able 的形式）。
正例： AbstractTranslator 实现
10. 枚举类名建议带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。
说明： 枚举其实就是特殊的常量类，且构造方法被默认强制是私有。
正例： 枚举名字： DealStatusEnum， 成员名称： SUCCESS / UNKOWN_REASON。
11. 各层命名规约：
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

###常量定义
1. 不允许任何魔法值（ 即未经定义的常量） 直接出现在代码中
2.  long 或者 Long 初始赋值时，必须使用大写的 L，不能是小写的 l，小写容易跟数字1 混淆，造成误解。
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
阿里巴巴 Java 开发手册
——禁止用于商业用途，违者必究—— 4 / 34
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

###格式规约
1.

###OOP规约

###集合处理

###并发处理

###控制语句

###注释规约


###其它 




