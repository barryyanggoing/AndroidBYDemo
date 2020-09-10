package com.barryyang.barryyangdemo.android.components;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author : BarryYang
 * @date : 2020/7/31 2:34 PM
 * @desc :
 */
@Dao
public interface OrderDao {

    @Query("SELECT * FROM ORDERS")
    List<Order> loadAllOrders();

    @Query("SELECT * FROM ORDERS")
    LiveData<List<Order>> loadAllOrdersUseLiveData();

    @Query("select * from orders where order_id in (:orderIds)")
    List<Order> queryOrderById(long[] orderIds);

    @Insert
    void insertAll(Order... orders);

    @Delete
    void deleteOrder(Order... orders);

    @Update
    void updateOrder(Order... orders);

    @Query("SELECT * from orders")
    Flowable<Order> queryOrderUseRxJava();
}
