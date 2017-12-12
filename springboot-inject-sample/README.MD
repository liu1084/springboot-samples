#inject keys to controller from properties file or application.yml
 
## 如果想从application.yml中读取属性值到controller或者server
1）编写一个配置类加@components和@ConfigurationProperties注解
2）ConfigurationProperties会读取prefix，并找到你需要注入的变量名

如果想把ConfigurationProperties修饰的类注入到Configuration配置类中，可以使用@EnableConfigrationProperties注解修饰该类，
并指定要注入的ConfigurationProperties的类名

## 如果想从自定义的properties文件中获取key并注入controller
1）编写一个配置类加@Configration和@PropertySource注解
    `PropertySource`可以支持spring的profiles，
    例如：@PropertySource(value = "classpath:config/${spring.profiles.active}.properties", encoding="utf-8")
2）通过@Value注解注入


## spring容器初始化bean和销毁前所做的操作
@PostConstruct和@PreDestroy

## 一个Configuration中得Bean需要另外一个Configuration构造的bean，可以通过
@Import来导入，如果需要导入的是以XML形式存在的，用@ImportResource导入。




