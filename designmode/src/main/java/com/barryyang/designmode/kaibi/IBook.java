package com.barryyang.designmode.kaibi;

/**
 * @author barryyang
 */
public interface IBook {

    /**
     * 获取书籍的名称
     *
     * @return
     */
    String getBookName();

    /**
     * 获取书籍的价格
     *
     * @return
     */
    int getBookPrice();

    /**
     * 获取书籍的作者
     *
     * @return
     */
    String getBookAuthor();
}
