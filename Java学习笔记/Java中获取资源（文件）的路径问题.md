##Java中获取资源（文件）的路径问题
Java中获取资源可以分为两种方式，基于文件系统的和基于classpath的。
* 基于文件系统
  1. 相对路径。如 `File f = new File("text.txt")`，文件text.txt就是相对路径。一般相对路径的是`System.getProperties("user.dir")`，即执行Java程序的所在路径。比如你用window中的cmd通过调用java命令来执行java程序，那么cmd中的当前路径就是Java程序中的相对路径；在eclipse执行Java程序时，项目路径即为相对路径。注意，根路径为当前盘符路径。如：`"/text.txt" = "D:/text.txt"`

  2. 绝对路径。如`new File("C:/text.txt")`

* 基于classpath  

  我们知道,java 命令执行的时候可以指定一个classpath,系统默认在这个classpath目录下面查找各种class.文件,jar包,配置文件等。基于classpath 获取资源有以下三种方式:
  ```
  URL url = this.getClass().getResource("resource_name");  //当前class目录
  URL url = this.getClass().getClassLoader().getResource("resource_name");  //当前工程目录，eclipse下为bin目录
  URL url = Thread.currentThread().getContextClassLoader().getResource("resource_name");  //（推荐使用）该线程的上下文 ClassLoader，Tomcat这类的容器,可能使用了自定义的ClassLoader产生了特殊的classpath,这样就需要遵循特殊的方式。
  ```
  Demo：使用eclipse在D:\eclipseLuna64\myworkspace路径下创建名为Learning的Java Project
  ```
  FilePath.java

  package my.learning;

  import java.io.File;
  import java.io.FileOutputStream;
  import java.net.URL;

  public class FilePath {
  	public static void main(String[] args){
  		System.out.println("基于文件系统的相对路径：" + System.getProperty("user.dir"));
  		System.out.println("基于当前Class的classpath路径：" + FilePath.class.getResource(""));
  		System.out.println("基于当前Class的classpath的根路径：" + FilePath.class.getResource("/"));
  		System.out.println("基于当前ClassLoader的classpath路径：" + FilePath.class.getClassLoader().getResource(""));
  		System.out.println("基于Thread.currentThread().getContextClassLoader()的classpath路径："
  			+ Thread.currentThread().getContextClassLoader().getResource(""));
  	}
  }

  ```
  输出结果为：  
  基于文件系统的相对路径：D:\eclipseLuna64\myworkspace\Learning 
  基于当前Class的classpath路径：file:/D:/eclipseLuna64/myworkspace/Learning/bin/my/learning/ 
  基于当前Class的classpath的跟路径：file:/D:/eclipseLuna64/myworkspace/Learning/bin/ 
  基于当前ClassLoader的classpath路径：file:/D:/eclipseLuna64/myworkspace/Learning/bin/ 
  基于Thread.currentThread().getContextClassLoader()的classpath路径：file:/D:/eclipseLuna64/myworkspace/Learning/bin/ 

  **特别说明：Tomcat下的web项目根路径为：WEB-INF\classes**

