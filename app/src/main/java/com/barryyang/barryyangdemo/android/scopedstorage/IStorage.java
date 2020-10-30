package com.barryyang.barryyangdemo.android.scopedstorage;

/**
 * @author : BarryYang
 * @date : 2020/10/30 11:39 AM
 * @desc :
 */
public interface IStorage {

    String readFile();

    void createFile();

    void writeFile();

}
