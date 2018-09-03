# spring-boot-starter-framework使用说明





spring-boot-starter-framework是一个核心框架包，springboot整合了很多依赖包，像spring-boot-starter-web、<br/>
spring-boot-starter-data-redis等等。<br/>
spring-boot-starter-framework在基础上又做了一次整合，里面包含上面的所有start依赖。<br/>
这样当我们开发项目的时候就只需要在pom.xml文件中添加一个spring-boot-starter-framework依赖即可，配置如下:<br/>

```
    <dependency>
        <groupId>cn.cebest</groupId>
        <artifactId>spring-boot-starter-framework</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    
```

## 该框架包含哪些功能

1、工具类<br/>
2、自定义注解<br/>
3、参数验证<br/>
4、防xss注入<br/>
5、log日志<br/>
6、核心配置及实现(redis、mail、json、mybatis、quartz、shiro、solr、enjoy模板引擎、webmvc等等)<br/>

下面我们来简单说明一下如何使用

### 工具类的使用

工具类在cn.cebest.framework.util包下，我们可以直接通过 类名.方法名去调用

### 自定义注解

我们自定义了@Mobile注解 和 @SysLog注解<br/>

@Mobile注解应用在数据模型的变量上，用于验证手机号格式，用法如下：

    @Mobile
    private String phone;
    
@SysLog应用在Controller类中的方法上，用于记录请求日志(包括请求参数、url、ip地址、返回结果等等),用法如下:

    @SysLog
	@GetMapping("index")
	public String index(){
		// TODO
	}

### 参数验证

参数验证和上面@Mobile注解的用法一样，只是@Mobile是自定义注解(验证是自己实现的)，内置的注解如下:

    
    @Null 限制只能为null
    @NotNull 限制必须不为null
    @AssertFalse 限制必须为false
    @AssertTrue 限制必须为true
    @DecimalMax(value) 限制必须为一个不大于指定值的数字
    @DecimalMin(value) 限制必须为一个不小于指定值的数字
    @Digits(integer,fraction) 限制必须为一个小数，且整数部分的位数不能超过integer，小数部分的位数不能超过fraction
    @Future 限制必须是一个将来的日期
    @Max(value) 限制必须为一个不大于指定值的数字
    @Min(value) 限制必须为一个不小于指定值的数字
    @Past 限制必须是一个过去的日期
    @Pattern(value) 限制必须符合指定的正则表达式
    @Size(max,min) 限制字符长度必须在min到max之间
    @Past 验证注解的元素值（日期类型）比当前时间早
    @NotEmpty 验证注解的元素值不为null且不为空（字符串长度不为0、集合大小不为0）
    @NotBlank 验证注解的元素值不为空（不为null、去除首位空格后长度为0），不同于@NotEmpty，@NotBlank只应用于字符串且在比较时会去除字符串的空格
    @Email 验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式
    
    
