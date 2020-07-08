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

    public double getCharge() {
        double result = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDaysRental() > 2) {
                    result += (getDaysRental() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRental() * 3;
                break;
            default:
                result += 1.5;
                if (getDaysRental() > 3) {
                    result += (getDaysRental() - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRental() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

}
