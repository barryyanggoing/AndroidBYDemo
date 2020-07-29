package com.barryyang.barryyangdemo.codeoptimize;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 用户取租赁电影
 *
 * @author barryyang
 */
public class Customer {

    /**
     * 租赁人姓名
     */
    private String name;

    /**
     * 租赁电影集合
     */
    private Vector<Rental> vector = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        vector.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> elements = vector.elements();
        String result = name + "租赁记录：" + "\n";
        while (elements.hasMoreElements()) {
            Rental rental = elements.nextElement();
            result += "书籍名称：" + rental.getMovie().getTitle() + "\n" + "单价：" + rental.getCharge() + "\n";
            frequentRenterPoints += rental.getFrequentRenterPoints();
            totalAmount += rental.getCharge();
        }
        result += "总金额是：" + totalAmount + "\n";
        result += "积分：" + frequentRenterPoints;
        return result;
    }

}
