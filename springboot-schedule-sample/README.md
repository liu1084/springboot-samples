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


    * "0 0 * * * *" = 每天00:00.
    * "*/10 * * * * *" = 每隔10秒.
    * "0 0 8-10 * * *" = 每天的08:00,09:00,10:00执行.
    * "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
    * "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
    * "0 0 0 25 12 ?" = every Christmas Day at midnight
    Cron expression is represented by six fields:
    
    second, minute, hour, day of month, month, day(s) of week
    (*) means match any
    
    */X means "every X"
    
    ? ("no specific value") - useful when you need to specify something in one of the two fields in which the character is allowed, but not the other. For example, if I want my trigger to fire on a particular day of the month (say, the 10th), but I don't care what day of the week that happens to be, I would put "10" in the day-of-month field and "?" in the day-of-week field.