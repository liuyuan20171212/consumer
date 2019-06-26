package com.ityuan.dubbo.steam;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author ityuan
 * @Date 2019-06-25 11:37
 */
public class StreamTest {
    private final static List<Person> list = new LinkedList<Person>();
    private final static List<Integer> list2 = new LinkedList<Integer>();

    static {
        list.add(new Person("女孩1号", false));
        list.add(new Person("女孩2号", false));
        list.add(new Person("女孩3号", false));
        list.add(new Person("女孩4号", false));
        list.add(new Person("女孩5号", false));
        list.add(new Person("男孩1号", true));
        list.add(new Person("男孩2号", true));
        list.add(new Person("男孩3号", true));
        list.add(new Person("男孩4号", true));
        list.add(new Person("男孩5号", true));
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(8);
        list2.add(10);
        list2.add(11);
        list2.add(12);
    }

    public static void main(String[] args) {
        //过滤
        List<Person> filterList = list.stream().filter(Person::getIsMale).collect(Collectors.toList());
        //映射
        List<String> mapList = list.stream().filter(Person::getIsMale).map(Person::getName).collect(Collectors.toList());
        //过滤遍历
        list2.stream().filter(a -> a > 7).skip(2).forEach(StreamTest::getAge);
        //集合中所有都匹配
        Boolean hasAllMale = list.stream().allMatch(Person::getIsMale);
        //集合中有任意一个匹配
        Boolean hasAnyMale = list.stream().anyMatch(Person::getIsMale);
        //集合中都匹配
        Boolean errorMale = list.stream().noneMatch(Person::getIsMale);
        //过滤查找集合中任意一个| 值存在的时候执行给定的代码块
        list.stream().filter(Person::getIsMale).findFirst().ifPresent(StreamTest::getName);
        //元素操作 0为初始值
        Integer result1 = list2.stream().reduce(0, StreamTest::add);
        //先映射再求值
        Optional<String> optional = list.stream().map(Person::getName).reduce(StreamTest::getNames);
        //求最大值
        Optional<Integer> max = list2.stream().reduce(Integer::max);
        //求最小值
        Optional<Integer> min = list2.stream().reduce(Integer::min);
        //查询集合数量
        long count = list2.stream().filter(integer -> integer > 10).count();
        //排序
        List<Integer> sortList = list2.stream().sorted(StreamTest::sort).collect(Collectors.toList());
        System.out.println(sortList);

    }

    public static int sort(Integer o1,Integer o2){
        return o1 > o2 ? -1 : 1;
    }

    public static String getNames(String s1, String s2) {
        return s1.concat("|").concat(s2);
    }

    public static Integer multi(Integer integer, Integer integer2) {
        return integer * integer2;
    }

    public static Integer add(Integer integer, Integer integer2) {
        return integer + integer2;
    }


    public static String getAge(Integer age) {
        String str = "当前用户年龄：" + age;
        return str;
    }

    public static String getName(Person person) {
        String str = "当前用户名称：" + person.getName();
        return str;
    }

}
