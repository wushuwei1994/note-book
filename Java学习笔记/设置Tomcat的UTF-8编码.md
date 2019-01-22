## 设置Tomcat的UTF-8编码

利用request.setCharacterEncoding("UTF-8");来设置Tomcat接收请求的编码格式，只对POST方式提交的数据有效，对GET方式提交的数据无效!

要设置GET的编码，可以修改server.xml文件中，相应的端口的Connector的属性：URIEncoding="UTF-8"，这样，GET方式提交的数据才会被正确解码。

  <Connector port="8080" protocol="HTTP/1.1" 
​               connectionTimeout="20000" 
​               redirectPort="8443" URIEncoding="UTF-8" />

参考（照搬）：https://blog.csdn.net/hongqishi/article/details/7428380