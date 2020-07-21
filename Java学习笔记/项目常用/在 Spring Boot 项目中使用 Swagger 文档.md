## 在 Spring Boot 项目中使用 Swagger 文档

> 参考IBM Developer文档 [《在 Spring Boot 项目中使用 Swagger 文档》](https://www.ibm.com/developerworks/cn/java/j-using-swagger-in-a-spring-boot-project/index.html)

1. pom增加依赖

   ```
     <properties>
           <springfox.swagger.version>2.9.2</springfox.swagger.version>
     </properties>
     <dependencies>
   		<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
           <dependency>
               <groupId>io.springfox</groupId>
               <artifactId>springfox-swagger2</artifactId>
               <version>${springfox.swagger.version}</version>
           </dependency>
   
           <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
           <dependency>
               <groupId>io.springfox</groupId>
               <artifactId>springfox-swagger-ui</artifactId>
               <version>${springfox.swagger.version}</version>
           </dependency>
     </dependencies>
   ```

2. 项目增加swagger配置

   ```
   //SwaggerConfig.java
   @Configuration
   @EnableSwagger2
   public class SwaggerConfig {
       @Bean
       public Docket api() {
           return new Docket(DocumentationType.SWAGGER_2)
                   .select()
                   .apis(RequestHandlerSelectors.any())
                   .paths(PathSelectors.any())
                   .build()
                   .apiInfo(apiInfo());
       }
   
       private ApiInfo apiInfo() {
           return new ApiInfo(
                   "权限助手接口文档",
                   "权限助手接口文档。",
                   "API V1.0",
                   "Terms of service",
                   new Contact("吴蜀威", "https://doyd.cn", "wushuwei@doyd.cn"),
                   "Apache", "http://www.apache.org/", Collections.emptyList());
       }
   }
   ```

3. 接口增加swagger注解，提供接口描述

   * Controller类 @Api

   ```
   @RestController
   @RequestMapping("/tool")
   @Api(tags = "节点枚举相关操作接口")
   public class OperateToolController {
   }
   ```

   * `具体接口@ApiOperation

   ```
   @ApiOperation("新增节点枚举接口")
   @PostMapping("/operateEnum")
   public ResponseVo addOperateEnum(@RequestBody OperateEnumVo operateEnumVo) {
   }
   ```

   * Vo层（参数）

   ```
   @Data
   @ApiModel("节点枚举")
   public class OperateEnumVo {
       private ProjectEnumVo projectEnumVo; // 项目枚举
       private MenuBarsEnumVo menuBarsEnumVo; // 菜单枚举
       private String key; // 节点关键字
       private String name; // 节点名称
       @ApiModelProperty("节点枚举名")
       private String operateEnumName;
   }
   ```

4. 打开接口文档：http://localhost:8080/swagger-ui.html

其他参考

> [Swagger接口分类与各元素排序问题详解](http://blog.didispace.com/spring-boot-learning-21-2-4/)

