#  springboot-mybatis

sprintboot是一个微服务框架，它内置Tomcat；本项目以1.3.x版本的spring boot为运行环境建立了一个微服务模板，并集成了mybatis作为ORM层数据访问源

---
## 一、首先去官网新建一个spring-boot项目
dependencies选择自己所需依赖也可在第二步修改


## 二、更改pom.xml文件(maven管理，选择自己需要使用的依赖jar)

```
<!-- mybatis jar -->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.2.1</version>
</dependency> 
 
<!-- velocity jar -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-velocity</artifactId>
</dependency>
 
<!-- mysql jar -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
 
<!-- spring boot1.4.X之后log4j引入会失败需用log4j2 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j</artifactId>
</dependency>
 
<!-- jdbc jar  -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
 
<!-- 阿里巴巴Json处理  -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.4</version>
</dependency>
 
<!-- Google guava 新集合类的使用 -->
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>18.0</version>
</dependency>

```
等等。。。。。

## 三、application.properties配置文件修改
（个人理解下面的3.2~3.5小节配置或者其他配置均可以通过.java文件加@Configuration进行java注入配置）

application.properties：
可直接在其application.properties中进行配置；

```
* 推荐如下配置：spring.profiles.active=pro或dev或test
【
application-dev.properties：开发环境
application-test.properties：测试环境
application-prod.properties：生产环境
】
```
### 3.1、端口，服务名配置
```
server.port=8133
server.tomcat.maxThreads=16
server.context-path=/harbor
spring.jmx.enabled=false
```
### 3.2、日志配置

```
#log Configuration way 1 
logging.config=classpath:log4j-dev.properties
 
#log Configuration way 2 以java配置方式注入日志
log4j.path=log4j-dev.properties
```

日志祥情  可查看上一篇文章；

### 3.3、velocity模板引擎配置
```
#veloctity Configuration
spring.velocity.cache=false
spring.velocity.check-template-location=true
spring.velocity.charset=UTF-8
spring.velocity.properties.input.encoding=UTF-8
spring.velocity.properties.output.encoding=UTF-8
spring.velocity.content-type=text/html;charset=UTF-8
spring.velocity.requestContextAttribute=rc
```
### 3.4、数据库配置
```
tomcat.datasource.username=root
tomcat.datasource.password=witsSQL2016
tomcat.datasource.driverClassName=com.mysql.jdbc.Driver
tomcat.datasource.url=jdbc:mysql://127.0.0.1:3306/YanHuiMap?useUnicode\=true&characterEncoding\=utf8
tomcat.datasource.maxActive=100
tomcat.datasource.maxIdle=8
tomcat.datasource.minIdle=8
tomcat.datasource.initialSize=10
tomcat.datasource.testOnBorrow=true
tomcat.datasource.testOnReturn=true
tomcat.datasource.validationQuery=SELECT 1
```
### 3.5、mybatis配置

```
mybatis.config-locations=classpath:mybatis-config.xml
mybatis.mapper-locations=classpath:mapper/*.xml

注：这种方式声明只有在spring-boot 1.4.*后才可以进行使用
```
联系方式：
<a target="_blank" href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=PQ8KCwkJCwsKCH1MTBNeUlA" style="text-decoration:none;">
<img src="http://rescdn.qqmail.com/zh_CN/htmledition/images/function/qm_open/ico_mailme_02.png"/></a>
