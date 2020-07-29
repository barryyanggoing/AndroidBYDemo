package com.barryyang.barryyangdemo.designmodel.factory;

public class PeopleFactory {

    public static IHuman getPeople(String type) {
        if ("white".equals(type)) {
            return new WhiteHuman();
        } else if ("black".equals(type)) {
            return new BlackHuman();
        }
        return new YellowHuman();
    }
}
