### 利用AOP的方式处理自定义注解
1. 定义注解RedisCache
2. 写一个AOP，环绕拦截
3. 定义用户领域对象User，并使用@Document(collection="users")&&@Data进行注解
4. 定义Service接口和实现类
5. 定义Controller

### 重点
1. AOP的切点拦截的是注解名称，并把ProceedingJoinPoint作为环绕方法的参数
