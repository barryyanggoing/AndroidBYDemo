package com.barryyang.barryyangdemo.designmodel.zerenlian;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : BarryYang
 * @date : 4/7/21 6:20 PM
 * @desc :
 */
public class MsgProcessChain {

    //private List<Handler> chains = new ArrayList<>();

    /**
     * 添加责任链
     *
     * @param process
     * @return
     */
    public MsgProcessChain addChain(Handler process) {
        //chains.add(process);
        Handler nextHandler = process.nextHandler();
        if (nextHandler != null) {
            process.setNext(nextHandler);
           // chains.add(nextHandler);
        }
        return this;
    }

}
