## 使用Ajax+FormData上传文件

1. 配置参数
* maxSize - 上传文件的最大大小
* path - 上传文件后，写到服务器的目录

2. 写一个controller，
* get 用来显示form表单
* post 提交文件

3. 后台使用MultipartFile 接收@RequestParam参数 file

4. 使用path = Paths.get()取得文件路径和文件名

5. 参数可以getBytes，然后定义一个BufferedOutputStream(FileOutputStream(new File(file)))

6. 最后注意flush，close因为 使用了try-resource方式，可以不显式关闭