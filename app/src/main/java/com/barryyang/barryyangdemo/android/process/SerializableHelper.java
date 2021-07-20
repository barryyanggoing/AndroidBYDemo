package com.barryyang.barryyangdemo.android.process;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author : BarryYang
 * @date : 2021/7/17 2:57 下午
 * @desc :
 */
public class SerializableHelper {

    public void wirteSerializable(){
        try {
            User user = new User(11,"xiaoming");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("cache.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readSeralizable(){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("cache.txt"));
            User newUser = (User) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
