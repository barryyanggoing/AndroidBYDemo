package com.barryyang.code_refactor;

/**
 * 租赁电影，租赁的天数
 *
 * @author barryyang
 */
public class Rental {

    /**
     * 租赁的天数
     */
    private int daysRental;

    /**
     * 租赁的影片
     */
    private Movie movie;

    public Rental(int daysRental, Movie movie) {
        this.daysRental = daysRental;
        this.movie = movie;
    }

    public int getDaysRental() {
        return daysRental;
    }

    public void setDaysRental(int daysRental) {
        this.daysRental = daysRental;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
