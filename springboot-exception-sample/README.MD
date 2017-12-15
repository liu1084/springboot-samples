## spring boot exception 处理

### 方法1：定义一个继承自RuntimeException得自定义的Exception
一般常用在返回json；

### 方法2：使用基于Controller的@ExceptionHandler，结合@ResponseStatus
可以在controller中定义，ExceptionHandler可以处理多种类型的exception。
还可以将结果发送到ModelAndView中，输出到页面

### 方法3：定义全局的Exception处理器
1. 把抛出的异常信息错误输出到页面的<!-- -->内，给用户保留友好的内容
建立一个全局的异常处理类GlobalExceptionHandler，用ControllerAdvice注解修饰
按照不同的异常处理，建立不同的方法，并用ExceptionHandler(value=ExceptionXXX.class)注解修饰
建立一个ModelAndView对象，把需要的信息放到页面中显示。

2. 返回json
在ExceptionHandler修饰的方法上，添加@ResponseBody即可。
