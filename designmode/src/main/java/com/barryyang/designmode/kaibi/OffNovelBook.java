package com.barryyang.designmode.kaibi;

public class OffNovelBook extends NovelBook {

    public OffNovelBook(String bookName, int bookPrice, String bookAuthor) {
        super(bookName, bookPrice, bookAuthor);
    }

    @Override
    public int getBookPrice() {
        int bookPrice = super.getBookPrice();
        if (bookPrice > 3000) {
            return bookPrice * 90 / 100;
        }
        return bookPrice * 80 / 100;
    }
}
