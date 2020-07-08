package com.barryyang.code_refactor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Customer customer = new Customer("张三");
        Movie movie = new Movie();
        movie.setTitle("改善既有代码设计");
        movie.setPriceCode(Movie.CHILDRENS);
        Rental rental = new Rental(3, movie);
        customer.addRental(rental);
        String statement = customer.statement();
        System.out.println(statement);
    }
}