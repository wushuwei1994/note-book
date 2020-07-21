### 快速入门

#### 项目构建与解析

##### 构建Maven项目

通过官方的Spring Initializr工具来产生基础项目。访问地址：http://start.spring.io

##### 工程结构解析

src/main/java：java源代码；主程序入口 HelloApplication 

src/main/resources：配置目录

src/test：单元测试目录

##### Maven配置分析

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<!--  父项目配置，定义Spring Boot 版本的基础依赖以及一些默认配置内容，如：配置文件application.properties的位置等  -->
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.4.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<!-- 项目基础信息 -->
	<groupId>org.andme.learn</groupId>
	<artifactId>microservice</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>microservice</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<!-- 以spring-boot-starter-*方式命名的依赖为Spring Boot生态的Starter POMs。
		其为一系列轻便的依赖包，是一套一站式的Spring相关技术的解决方案。常用的有:
		web、test、aop、jdbc、redis等-->

		<!-- Spring Boot Web依赖 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<!-- Spring Boot test依赖 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

#### 实现 RESTful API

新建 Controller 类，并在相应的类加注解「@RestController」，具体方法加上注解「@RequestMapping」

```
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello world!!!";
    }
}
```

##### 启动 Spring Boot 应用

* 运行 Application 类中的 main 方法
* 利用 spring-boot-maven-plugin 插件，执行 `mvn spring-boot:run` 命令 
* 在服务器上部署运行，先使用 `mvn install` 命令打包成 jar 包，再通过 `java -jar xxx.jar` 命令来启动应用

##### 参数校验（标准JSR-303规范）
* 在要校验的字段上添加 @NotEmpty等注解。更多注解参考：[JSR303定义的校验类型](JSR303定义的校验类型.md)
```
@Data
@ApiModel("节点枚举")
public class OperateEnumVo {
    private ProjectEnumVo projectEnumVo; // 项目枚举
    private MenuBarsEnumVo menuBarsEnumVo; // 菜单枚举
    private String key; // 节点关键字
    private String name; // 节点名称
    @ApiModelProperty("节点枚举名")
    @NotEmpty(message = "节点名称不能为空")
    private String operateEnumName;
}
```
*  在需要校验的参数实体前添加@Valid或@Validated注解
```
    @ApiOperation("新增节点枚举接口")
    @PostMapping("/operateEnum")
    public ResponseVo addOperateEnum(@RequestBody @Validated OperateEnumVo operateEnumVo) {
        return null;
    }
```


#### 编写单元测试

1. 引入依赖：spring-boot-starter-web 

2. 在test文件，创建test类。在Idea 可以通过 「Ctrl + Shift + T」快捷键，快速创建单元测试类。也可通过操作栏的Navigate -> Test窗口

   ```
   //ShellServiceTest.java
   @RunWith(SpringRunner.class)
   @SpringBootTest
   public class ShellServiceTest {
   
       @Autowired
       private IShellService shellService;
   
       @Test
       public void mvnDeploy() {
           shellService.mvnDeploy("/D:/code/java/power-tool");
       }
   }
   ```

3. 直接运行@Test方法

### 配置详解

#### 配置文件

Spring Boot默认的配置文件为src/main/resources/application.properties 。也可以使用YAML（application.yml）文件替换传统properties文件。

常用配置

```
### 服务端口号
server.port=8881
### 服务名
spring.application.name=microservice
### 指定生效配置环境
spring.profiles.active=test
# 加载所有的端点/默认只加载了 info / health
management.endpoints.web.exposure.include=*
```

#### 自定义参数

可以在配置文件自定义需要的参数，代码中可以通过 @Value注解来加载这些自定义参数。自定义参数名避免与系统变量相同，否则加载的参数为系统变量。

```
@Component
public class Application {
    @Value("${author}")
    private String author;
    @Value("${desc}")
    private String desc;
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
```

##### 引入新的配置文件

resources下的配置文件 gitconfig.properties

```
#gitconfig.properties
git.localRepoPath=/D:/code/java/frameworkdemo
git.localRepogitConfig=/D:/code/java/frameworkdemo/.git
git.remoteRepoUri=git@github.com:xxx/project.git
git.initLocalCodeDir=/D:/code/java/
```

通过 @PropertySource @ConfigurationProperties 注解加载配置：

```
@Component
@PropertySource(value = {"classpath:gitconfig.properties"})
@ConfigurationProperties(prefix = "git")
@Data
public class GitConfig {
    private String localRepoPath;
    private String localRepogitConfig;
    private String remoteRepoUri;
    private String initLocalCodeDir;
    private String branchName;
    private String username;
    private String password;
}
```

其中ConfigurationProperties的prefix必填

#### 参数引用

配置文件中的参数可以通过PlaceHolder方式引用

```
book.desc=${book.author} is writing
```

#### 命令行参数

启动应用时，可以在命令行中指定应用的参数 ``` java -jar xxx.jar --spring.profiles.active=test ``` 

#### 多环境配置

对于多环境的配置，各种项目构建工具或是框架的基本思路都是通过配置多份不同环境的配置文件，再通过打包命令指定需要打包的内容之后区分打包。

在 Spring Boot 中，多环境配置的文件名需要满足 application-{profile}.properties 的格式，其中{profile}为你不同环境的标识。如

* application-dev.properties 开发环境
* application-test.properties 测试环境
* application-pro.properties 生产环境

用 spring.profiles.active=${profile} 参数设置具体环境

多环境的配置思路：

* 在 application-{profile}.properties 中配置各个环境不同的内容
* 在 application.properties 文件中配置通用的内容，并设置spring.profiles.activce=dev，以开发环境为配置环境。
* 通过命令方式激活不同环境的配置  ``` java -jar xxx.jar --spring.profiles.active=test ``` 

#### 配置加载顺序

可参考：<https://www.jianshu.com/p/3c615bd42799>

 配置文件的生效顺序，会对值进行覆盖

1. @TestPropertySource 注解
2. 命令行参数
3. Java系统属性（System.getProperties()）
4. 操作系统环境变量
5. 只有在random.*里包含的属性会产生一个RandomValuePropertySource
6. 在打包的jar外的应用程序配置文件（application.properties，包含YAML和profile变量）
7. 在打包的jar内的应用程序配置文件（application.properties，包含YAML和profile变量）
8. 在@Configuration类上的@PropertySource注解
9. 默认属性（使用SpringApplication.setDefaultProperties指定）

### 监控与管理