package com.barryyang.designmode.dimite;

import java.util.List;

public class GrounpLeader {

    private List<Gril> mGrilList;

    public GrounpLeader(List<Gril> pGrilList) {
        this.mGrilList = pGrilList;
    }

    public void countGrils() {
        System.out.println("女孩的人数为：" + mGrilList.size());
    }
}
