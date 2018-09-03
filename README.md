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
2、通用注解<br/>
3、参数验证<br/>
4、防xss注入<br/>
5、log日志<br/>
6、核心配置及实现(redis、mail、json、mybatis、quartz、shiro、solr、enjoy模板引擎、webmvc等等)<br/>
    
    
