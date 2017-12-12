## spring boot exception 处理

### 方法1：定义一个继承自RuntimeException得自定义的Exception，结合@ResponseStatus注解
可以在ResponseStatus中定义状态值和原因
一般常用在返回json；

### 方法2：使用基于Controller的@ExceptionHandler，结合@ResponseStatus
可以在controller中定义，ExceptionHandler可以处理多种类型的exception，结合@ResponseStatus可以指定状态码和原因。
还可以将结果发送到ModelAndView中，输出到页面