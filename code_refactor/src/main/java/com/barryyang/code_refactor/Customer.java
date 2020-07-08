package com.barryyang.code_refactor;

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
            double thisAmount = 0;
            Rental rental = elements.nextElement();
            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRental() > 2) {
                        thisAmount += (rental.getDaysRental() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRental() * 3;
                    break;
                default:
                    thisAmount += 1.5;
                    if (rental.getDaysRental() > 3) {
                        thisAmount += (rental.getDaysRental() - 3) * 1.5;
                    }
                    break;
            }
            frequentRenterPoints++;
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRental() > 1) {
                frequentRenterPoints++;
            }
            result += "书籍名称：" + rental.getMovie().getTitle() + "\n" + "单价："+thisAmount + "\n";
            totalAmount += thisAmount;
        }
        result += "总金额是：" + totalAmount + "\n";
        result += "积分：" + frequentRenterPoints;
        return result;
    }

}
