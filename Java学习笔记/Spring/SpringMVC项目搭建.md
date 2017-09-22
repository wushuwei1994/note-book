## SpringMVC基本配置 ##

#### 一、maven项目 ####

1、创建maven web项目

2、在pom.xml文件增加Spring MVC相关的jar依赖

```
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>4.3.5.RELEASE</version>
    </dependency>

    <dependency>
      <groupId>commons-lang</groupId>
      <artifactId>commons-lang</artifactId>
      <version>${commons-lang.version}</version>
    </dependency>
    
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
      <version>${slf4j.version}</version>
      <exclusions>
        <exclusion>
          <artifactId>slf4j-api</artifactId>
          <groupId>org.slf4j</groupId>
        </exclusion>
      </exclusions>
    </dependency>

    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>${slf4j.version}</version>
    </dependency>

    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
    </dependency>
  </dependencies>
  <build>
    <finalName>autoTest</finalName>
  </build>
  <properties>
    <slf4j.version>1.5.6</slf4j.version>
    <commons-lang.version>2.6</commons-lang.version>
  </properties>
```

3、配置web.xml文件，指定servlet-dispatcher

```
    <servlet>
        <servlet-name>spring-mvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring-mvc-servlet.xml</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>spring-mvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```

其中，init-param的contextConfigLocation默认路径为：```/WEB-INF/spring-mvc-servlet.xml``，也可以自定义路径（相对路径为war包根路径；若配置在resources文件下，则可以通过classpath:方式指定）

ps:

classpath：只会到你的class路径中查找找文件;

classpath*：不仅包含class路径，还包括jar文件中(class路径)进行查找

"**/" 表示的是任意目录； 

"**/applicationContext-*.xml"  表示任意目录下的以"applicationContext-"开头的XML文件。



4、新建spring-mvc-servlet.xml配置文件，指定controller扫描路径

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:util="http://www.springframework.org/schema/util" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
		http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd
    	http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd
    	http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-4.0.xsd
    	http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.0.xsd">
    <!-- 启动扫描所有的controller -->
    <context:component-scan base-package="com.wushuwei.autotest.controller" />
</beans>
```






