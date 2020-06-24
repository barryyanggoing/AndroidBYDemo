package com.barryyang.designmode.factory;

/**
 * 造人工厂
 *
 * @author barryyang
 */
public abstract class AbstractHumanFactory {

    /**
     * 造人
     *
     * @param <T>
     * @param t
     * @return
     */
    public abstract <T extends IHuman> Object createHuman(Class<T> t);
}
