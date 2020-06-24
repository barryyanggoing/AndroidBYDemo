package com.barryyang.designmode.factory;

public class HumanFactory extends AbstractHumanFactory {

    @Override
    public <T extends IHuman> T createHuman(Class<T> t) {
        try {
            return (T) Class.forName(t.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
