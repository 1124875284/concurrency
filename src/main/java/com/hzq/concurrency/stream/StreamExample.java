package com.hzq.concurrency.stream;


import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        //testForeach();
        //testFilter();
        //testDistinct();
        //testSorted();
        testMap();
    }

    /**
     * 普通遍历  foreach
     */
    public static void testForeach() {
        Stream<String> stream = Stream.of("huang", "zhi", "qiang");
        stream.forEach(str -> System.out.println(str));
    }

    /**
     * 过滤条件 filter
     */
    public static void testFilter() {
        Stream<String> stream = Stream.of("huang", "zhi", "qiang", "hho");
        stream.filter(s -> s.length() == 3).forEach(s -> System.out.println("s = " + s));
    }

    /**
     * 去除重复  distinct
     */
    public static void testDistinct() {
        Stream<String> stream = Stream.of("huang", "zhi", "qiang", "hho", "qiang");
        stream.distinct().forEach(s -> System.out.println("s = " + s));
    }

    /**
     * 按照指定条件（长度也可以不添加规则）排序  sorted()
     */
    public static void testSorted() {
        Stream<String> stream = Stream.of("huangg", "zhi", "qiangooo");
        stream.sorted((str1, str2) -> str1.length() - str2.length())
                .forEach(s -> System.out.println("s = " + s));
    }

    /**
     * 按照指定条件 进行转换  map()
     */
    public static void testMap() {
        Stream<String> stream = Stream.of("huangg", "zhi", "qiangooo");
        stream.map(s -> s.toUpperCase()).forEach(s -> System.out.println("s = " + s));
    }

    /**
     * 把多个List组装成一个  FaltMap()
     */
    @Test
    public void testFaltMap() {
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2, 3, 4), Arrays.asList(8, 9));
        stream.flatMap(list -> list.stream()).forEach(integer -> System.out.println("integer = " + integer));
    }

    /**
     * Reduce()  { max() }
     */
    @Test
    public void testReduceMax() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        //Optional<String> longest=stream.reduce((s1, s2) -> s1.length()>=s2.length() ?s1:s2);
        Optional<String> max = stream.max((s1, s2) -> s1.length() - s2.length());
        System.out.println("longest = " + max.get());
    }

    /**
     * Reduce()  { sum() /mapToInt()}  求个
     *
     * @Retern Interger/int
     */
    @Test
    public void testReduceSum() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        //Integer reduce = stream.reduce(0, (sum, str) -> sum + str.length(), (a, b) -> a + b);
        int sum = stream.mapToInt(str -> str.length()).sum();
        System.out.println("sum = " + sum);
    }

    /**
     * collect()  转化成Map Set等
     */
    @Test
    public void testCollect() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
//        List<String> list = stream.collect(Collectors.toList());
//        Set<String> set = stream.collect(Collectors.toSet());
        //Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));
        HashSet<String> collect = stream.collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect);
    }

    /**
     * *
     * collect()  join
     */
    @Test
    public void testCollectJoin() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        String collect = stream.collect(Collectors.joining());
        System.out.println("collect = " + collect);
    }


}
