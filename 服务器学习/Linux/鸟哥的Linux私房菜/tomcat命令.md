

查看Tomcat是否以关闭

```
ps -ef|grep java
```

使用Tomcat关闭命令

```
./shutdown.sh
```

如果你想直接干掉Tomcat，你可以使用kill命令，直接杀死Tomcat进程

```
 kill -9 7010
```

启动Tomcat

```
 ./startup.sh 
```

查看tomcat运行日志

```
tail -f catalina.out
```

