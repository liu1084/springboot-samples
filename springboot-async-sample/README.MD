## spring boot 异步

### 配置异步
AsyncConfig
1. 在配置类上添加Configuration注解
2. 添加bean，返回一个ThreadPoolExecutor类型的线程池执行器
3. 在配置类上添加EnableAsync注解

### 用Future接收异步返回结果
1. 在service中需要异步的方法添加Async注解
2. 使用AsyncResult返回Future结果
3. 添加Service注解


### 用get方法接收Future对象
1. 在Controller中注入Service对象
2. 使用Future接收service中使用Async注解标注的结果
3. 使用isDone判断future的结果，返回后添加到map中显示