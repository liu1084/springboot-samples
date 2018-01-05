## spring schedule

### 建立一个配置类，EnableScheduling注解修饰

### 建立Service

* 用Scheduled注解对应的方法，不应该返回值（void），也不应该有参数；
* fixedDelay计划任务
在前一个任务完成后和下一个任务开始之前，有个固定的延迟时间（单位：毫秒）

* fixRate计划任务
固定速率计划任务。每个任务独立，不管前面的任务是否完成，在指定的毫秒后开启下一个任务。

* initialDelay计划任务
任务第一次执行的时候延迟毫秒。

* cron计划任务
* cron的表达式含义如下：

>>>
/* 
 * 第1列秒（0～59）  
 * 第2列分钟0～59  
 * 第3列小时0～23（0表示子夜）  
 * 第4列日1～31  
 * 第5列月1-12 或者 JAN-DEC  
 * 第6列星期1-7 或者 SUN-SAT（1表示星期天）  
 *  
 * spring文档cron解释：  
 * A cron-like expression, extending the usual UN*X definition to include  
 * triggers on the second as well as minute, hour, day of month, month  
 * and day of week.  e.g. {@code "0 * * * * MON-FRI"} means once per minute on  
 * weekdays (at the top of the minute - the 0th second).  
 *  
*/