package com.barryyang.designmode.kaibi;

import java.text.NumberFormat;
import java.util.ArrayList;

public class BookStore {

    private static final ArrayList<IBook> BOOK_LIST = new ArrayList<>();

    public BookStore(){
        System.out.println("构造方法");
    }

    static {
        System.out.println("添加数据");
        BOOK_LIST.add(new NovelBook("天龙八部", 3200, "金庸"));
    }

    public void showBookInfo() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        numberFormat.setMaximumFractionDigits(2);
        for (IBook iBook : BOOK_LIST) {
            System.out.println("书籍名称：" + iBook.getBookName() + ",书籍价格：" + numberFormat.format(iBook.getBookPrice() / 100.0));
        }
    }
}
