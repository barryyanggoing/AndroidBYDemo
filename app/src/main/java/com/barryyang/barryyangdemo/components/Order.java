package com.barryyang.barryyangdemo.components;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * @author : BarryYang
 * @date : 2020/7/31 2:30 PM
 * @desc :
 */
@Entity(tableName = "orders")
public class Order implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "order_id")
    public long orderId;

    @ColumnInfo(name = "owner_name")
    public String ownerName;

    @ColumnInfo(name = "owner_phone")
    public String ownerPhone;

    @Ignore
    public String ignoreText;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", ownerName='" + ownerName + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                '}';
    }
}
