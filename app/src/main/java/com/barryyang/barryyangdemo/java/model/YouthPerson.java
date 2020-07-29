package com.barryyang.barryyangdemo.java.model;

/**
 * @author : BarryYang
 * @date : 2020/7/29 11:20 AM
 * @desc :
 */
public class YouthPerson extends Person{

    private int sex;

    public YouthPerson(long userId, String username,int sex ) {
        super(userId,username);
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof YouthPerson) {
            YouthPerson person = (YouthPerson) object;
            return super.equals(person) && sex == person.sex;
        }
        return false;
    }
}
