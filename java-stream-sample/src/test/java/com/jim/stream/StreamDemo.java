package com.jim.stream;


import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Test
@Slf4j
public class StreamDemo {
    private GsonBuilder gsonBuilder;

    @BeforeTest
    public void setup() {

    }

    /**
     * 构造一个stream，并排序
     */
    @Test
    public void test1() {
        Stream stream = Stream.of("C", "w", "2");
        Stream stream2 = stream.sorted();
        log.debug(stream2.findFirst().get().toString());
    }

    /**
     *
     */
    @Test
    public void test2() {
        String[] strArray = new String[]{"a", "b", "c"};
        String stream = Arrays.stream(strArray).skip(2).findFirst().get();
        log.debug(stream);
    }

    /**
     * 使用list构建一个stream
     */
    @Test
    public void test3() {
        List<String> list = Arrays.asList("a", "c");
        list.stream().forEach(ele -> log.debug(ele));
    }

    /**
     * 构建一个整数类型的stream，去除重复并且打印
     */
    @Test
    public void test4() {
        IntStream intStream = IntStream.builder()
                .add(1)
                .add(5)
                .add(6)
                .add(1)
                .build();

        intStream.filter(e -> e > 3)
                .distinct()
                .forEach(e -> log.debug(String.valueOf(e)));

        IntStream.range(1, 3).forEach(System.out::println);

    }


    /**
     * 将stream转换为array
     */
    @Test
    public void test5() {
        Stream<Object> stringStream = Stream.builder()
                .add("hello")
                .add("world")
                .build();

        String[] strings = stringStream.toArray(String[]::new);

        Stream.of(strings).forEach(e -> log.debug(e));

    }

    /**
     * 将stream转换为list
     */
    @Test
    public void test6() {
        Stream<String> stringStream = Stream.of("1", "2");

        List<String> strings = stringStream.collect(Collectors.toList());

        strings.forEach(e -> log.debug(e));
    }

    /*------------------流的操作------------------*/

    /**
     * map操作，实际上就是对数组中的每个元素进行操作
     * 此例中将字符串转换为大写
     */
    @Test
    public void test7() {
        String[] wordList = new String[]{"hello", "world"};
        Stream<String> stringStream = Stream.of(wordList)
                .map(String::toUpperCase);
        List<String> list = stringStream.collect(Collectors.toList());

        list.forEach(e -> log.debug(e));
    }

    /**
     * 对list中的每个数求平方
     */
    @Test
    public void test8() {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        List<Integer> squareNums = nums.stream()
                .filter(n -> n > 1)
                .map(n -> n * n)
                .collect(Collectors.toList());
        squareNums.forEach(e -> log.debug(String.valueOf(e)));
    }

    /**
     * 使用IntStream生成1～500的整数流
     * 然后使用filter对整数进行偶数过滤
     */
    @Test
    public void test9() {
        IntStream intStream = IntStream.range(1, 500);

        intStream
                .filter(n -> n % 2 == 0)
                .forEach(e -> log.debug(String.valueOf(e)));
    }


    /**
     * 通过flatMap把intList中的层级结构扁平化，最后将最底层的元素抽出来放到一起，
     * 最终childList中已经没有list了，都是数字
     */
    @Test
    public void test10(){
        Stream<List<Integer>> intLists = Stream.of(
                Arrays.asList(1, 2),
                Arrays.asList(5, 8),
                Arrays.asList(20, 23)
        );

        List<Integer> list = intLists.flatMap(childList -> childList.stream())
                .collect(Collectors.toList());

        list.forEach(e->log.debug(String.valueOf(e)));
    }

    /**
     * 通过读取文件流，将文件中的每一行凡是以空白字符货主逗号分割的单词扁平化
     * 如果单词的长度大于0，将单词集中起来放到一个list中，并打印
     */
    @Test
    public void test11(){
        File file = new File("/Users/jim.liu/Work/github/springboot-samples/java-stream-sample/src/test/java/com/jim/stream/StreamDemo.java");
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> words = bufferedReader.lines()
                    .flatMap(line -> Stream.of(line.split("[\\s|,]")))
                    .filter(word -> word.length() > 0 )
                    .collect(Collectors.toList());

            words.forEach(e->log.debug(e));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
