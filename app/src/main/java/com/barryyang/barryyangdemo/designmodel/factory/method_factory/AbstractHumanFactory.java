package com.barryyang.barryyangdemo.designmodel.factory.method_factory;

/**
 * @author : BarryYang
 * @date : 2020/8/22 4:05 PM
 * @desc :
 */
public abstract class AbstractHumanFactory {

    public abstract <T extends IHuman> T createHuman(Class<T> classs);

}
