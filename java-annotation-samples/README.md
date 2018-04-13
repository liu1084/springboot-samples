## Spring AOP expression language

### 切面是以切点为基础
#### 先定义若干切点，以@Pointcut(切点表达式)为注解的若干空的方法，这种类似的方法声明被称为：pointcut signature
```java
class PointcutDemo{
    @Pointcut("within(@注解类型模式)")
    private void methodName1(){
        
    }
    
    @org.aspectj.lang.annotation.Pointcut("execution(修饰符模式 返回类型模式 包名模式 方法名模式(参数模式) 异常模式)")
    private void methodName2(){
        
    }
}
```
#### 然后在方法上放置切点，执行
@Before("methodName1()")
@Round("methodName1()")
@After("methodName1()")
@AfterReturning("methodName2()")
@AfterThrowing("methodName1()")


#### 切点表达式可以作为@Pointcut注解的value，可以通过以下方式定义切点

- execution

execution是Spring切点表达式的主要方式，用来匹配执行了某个类下的某个方法
例如：
```java
public class PointcutDemo{
    @org.aspectj.lang.annotation.Pointcut("execution(public String com.jim.FooDAO.findUserById(Long))")
    public void pay(){
        //只要pay方法中调用了`public String com.jim.FooDao.findUserById(Long)`就匹配了这个切点
        //那么这个切点镶嵌的位置，如果@Before("pay()")修饰的方法就会被执行
    }
    
    //但是，上面的切点定义的不灵活，如果想在这个类下调用所有的方法，不论其方法签名如何，都匹配此切点，那么就应该这样写切点
    @org.aspectj.lang.annotation.Pointcut("execution(* com.jim.FooDAO.*(..))")
    public void pay(){}
}
```

- within

within 是...之内的就匹配，例如上面的例子可以这样写：
```java
public class PointcutDemo{
    @org.aspectj.lang.annotation.Pointcut("execution(* com.jim.FooDAO.*(..))")
    public void pay(){}
    
    @org.aspectj.lang.annotation.Pointcut("within(com.jim.FooDAO)")
    public void pay(){
        //within表示只要是com.jim.FooDAO类之内的方法，都匹配切点
    }
}
```
- this & target

this 是在CGLIB-based代理模式下，
target 是在JDK-based代理模式下，
匹配

基于JDK的代理模式需要实现一个接口，而基于CGLIB的代理模式不需要，那么代理所引用的bean的类型是给定的类型，那么就匹配了。
例如：

```java
public class FooDAO implements BarDAO{
    //如果代理的类型实现了接口，并且代理的bean是FooDAO，那么属于JDK模式，这个时候切点应该是：
    //@Pointcut("this(com.jim.FooDAO)")
    
    //如果代理模式是基于CGLIB，那么切点应该是
    //@Pointcut("target(com.jim.BarDAO)")
}
```

- args

匹配某个方法的参数为某种特定类型，例如：
```java
public class PointcutDemo{
    @org.aspectj.lang.annotation.Pointcut("execution(* *(Long))")
    public void pay(){
        //不论方法的签名，只要方法的参数只有一个Long类型，那么就匹配此切点
    }
    
    @org.aspectj.lang.annotation.Pointcut("execution(* *(Long,..))")
    public void pay(){
        //如果方法的参数很多，但是只要第一个参数是Long类型，应该这样写匹配的切点
    }
}
```
- @target

匹配被JDK代理模式的bean，它本身的类带有某个特定类型的注解

- @args

匹配方法参数带有某个特定类型的注解

- @within

匹配的切点带有某种注解

- @annotation
匹配的切点带有某种注解，而这种注解的名称必须匹配@anntation()的标题

- 以上切点表达式的合并集
每定义一个切点，都有一个切点表达式和一个空方法，
如果需要匹配多个切点表达式，需要重新定义一个空方法，把两个切点的空方法联合起来
组成一个新的切点，可以使用`&&`符合

```java
public class PointcutDemo{
    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void repositoryMethods() {}
     
    @Pointcut("execution(* *..create*(Long,..))")
    public void firstLongParamMethods() {}
     
    @Pointcut("repositoryMethods() && firstLongParamMethods()")
    public void entityCreationMethods() {}
}
```

#### 切点定义好以后，在执行方法上放置，放置的生命周期不同，那么执行的时机也不同

