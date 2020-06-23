package com.barryyang.designmode.kaibi;

public class NovelBook implements IBook {

    private int bookPrice;
    private String bookName;
    private String bookAuthor;

    public NovelBook(String bookName, int bookPrice, String bookAuthor) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String getBookName() {
        return bookName;
    }

    @Override
    public int getBookPrice() {
        return bookPrice;
    }

    @Override
    public String getBookAuthor() {
        return bookAuthor;
    }
}
