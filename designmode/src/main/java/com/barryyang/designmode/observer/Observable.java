package com.barryyang.designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 */
public class Observable {

    private List<Observer> list = new ArrayList<>();

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObserver();
    }

    public Observable addObserver(Observer observer) {
        list.add(observer);
        return this;
    }

    private void notifyAllObserver() {
        for (Observer observer : list) {
            observer.update();
        }
    }
}
