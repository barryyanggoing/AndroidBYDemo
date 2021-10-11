package com.barryyang.barryyangdemo.designmodel.iterator;

/**
 * @author : BarryYang
 * @date : 2021/9/16 5:53 下午
 * @desc :
 */
public class Test {

    public static void main(String[] args) {
        Aggregate<String> aggregate = new ConAggregate<>();
        aggregate.add("1111111");
        aggregate.add("22222222");
        Iterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println("Test = " + iterator.next());
        }
    }
}
