package com.barryyang.code_refactor;

/**
 * 电影
 *
 * @author barryyang
 */
public class Movie {

    /**
     * 普通电影
     */
    public static final int REGULAR = 0;

    /**
     * 电影新片
     */
    public static final int NEW_RELEASE = 1;

    /**
     * 儿童电影
     */
    public static final int CHILDRENS = 2;

    /**
     * 电影名称
     */
    private String title;

    /**
     * 费用
     */
    private int priceCode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

}
