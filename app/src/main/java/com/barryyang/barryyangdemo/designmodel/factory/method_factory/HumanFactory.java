package com.barryyang.barryyangdemo.designmodel.factory.method_factory;

/**
 * @author barryyang
 * @desc:工厂方法模式
 */
public class HumanFactory extends AbstractHumanFactory {

    @Override
    public <T extends IHuman> T createHuman(Class<T> classs) {
        try {
            return (T) Class.forName(classs.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
