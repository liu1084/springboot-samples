###Java 8 Stream

1. Stream 顾名思义，就是流，但是不同于之前定义的InputStream和OutputStream；
2. 一个管道中的数据流，可以经过若干转换，然后最终得到想要的结果；
3. 流的源可以是：
* Collection
* Array
* BufferedReader
* java.util.stream.IntStream.range()
* java.nio.file.Files.walk()
* java.util.Spliterator
* Random.ints()
* BitSet.stream()
* Pattern.splitAsStream
* JarFile.stream

4. 流的操作分为2类
* Intermediate 数据的映射、过滤，每次转换操作都返回一个新对象
* Terminal 一个流只能有一个terminal操作，Intermediate的所有操作会被集中起来，在terminal中一次完成