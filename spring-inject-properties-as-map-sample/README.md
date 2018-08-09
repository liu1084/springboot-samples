### Spring注入properties文件的KV，生成一个Map

1. 使用PropertiesFactoryBean生成一个bean，通过@Resource注入

2. 在property文件中，将value写成JSON格式，通过@Value("#{${key}})的方式注入