package com.ityuan.dubbo.steam;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * 流实践
 *
 * @Author ityuan
 * @Date 2019-06-25 18:02
 */
public class StreamPracticeImpl {

    private static List<Transaction> transactions = new ArrayList<>();

    static {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions.add(new Transaction(raoul, 2011, 400));
        transactions.add(new Transaction(brian, 2011, 300));
        transactions.add(new Transaction(raoul, 2012, 1000));
        transactions.add(new Transaction(mario, 2012, 710));
        transactions.add(new Transaction(mario, 2012, 700));
        transactions.add(new Transaction(alan, 2012, 950));

    }

    public static void main(String[] args) {
        //找出2011年的所有交易并按交易额排序(从低到高)
        List<Transaction> t1 = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted((o1, o2) -> o1.getValue() > o2.getValue() ? 1 : -1).collect(toList());
        //交易员都在哪些不同的城市工作过
        List<String> t2 = transactions.stream().map(transaction -> transaction.trader.getCity()).distinct().collect(toList());
        //查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> t3 = transactions.stream().map(transaction -> transaction.getTrader())
                .filter(trader -> StringUtils.equals("Cambridge", trader.getCity())).sorted(comparing(Trader::getName)).collect(toList());
        //返回所有交易员的姓名字符串，按字母顺序排序
        Optional<String> optional = transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted()
                .reduce((s, s2) -> s.concat("|").concat(s2));
        //有没有交易员是在米兰工作的
        Boolean t4 = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        //打印生活在剑桥的交易员的所有交易额
        Optional<Integer> t5 = transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getValue()).reduce((v1, v2) -> v1 + v2);
        //所有交易中，最高的交易额是多少
        Optional<Integer> t6 = transactions.stream().map(transaction -> transaction.getValue()).reduce(Integer::max);
        //找到交易额最小的交易
        Optional<Transaction> t7 = transactions.stream().min((o1, o2) -> o1.getValue() > o2.getValue() ? 1 : -1);
        //映射到数值流
        OptionalInt sum = transactions.stream().mapToInt(Transaction::getValue).max();
        //数值范围
        IntStream.rangeClosed(0, 100).forEach(value -> value++);
        //交易按照年度分组2
        Map<Integer, List<Transaction>> group = transactions.stream().collect(groupingBy(Transaction::getYear));
        System.out.println(group.get(2011));
    }


    /**
     * 交易员
     */
    @Data
    @AllArgsConstructor
    public static class Trader {
        private final String name;
        private final String city;
    }

    /**
     * 交易
     */
    @Data
    @AllArgsConstructor
    public static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;
    }

}
