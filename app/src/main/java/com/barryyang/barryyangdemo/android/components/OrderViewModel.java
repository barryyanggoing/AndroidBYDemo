package com.barryyang.barryyangdemo.android.components;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Random;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author : BarryYang
 * @date : 2020/7/31 1:58 PM
 * @desc :
 */
public class OrderViewModel extends ViewModel {

    private MutableLiveData<Order> mMutableLiveData;

    public MutableLiveData<Order> getData(Context context) {
        if (mMutableLiveData == null) {
            this.mMutableLiveData = new MutableLiveData<>();
        }
        mMutableLiveData.setValue(loadData(context));
        return mMutableLiveData;
    }

    public MutableLiveData<Order> getDataUseRxJava(Context context) {
        if (mMutableLiveData == null) {
            this.mMutableLiveData = new MutableLiveData<>();
        }
        loadDataUseRxJava(context);
        return mMutableLiveData;
    }

    public void changeData(Context context) {
        if (mMutableLiveData != null) {
            insertOrder(context);
            mMutableLiveData.setValue(loadData(context));
        }
    }

    public Order loadData(Context context) {
        OrderDao orderDao = AbstractAppDatabase.getInstance(context).getOrderDao();
        List<Order> orders = orderDao.loadAllOrders();
//      LiveData<List<Order>> listLiveData = orderDao.loadAllOrdersUseLiveData();
//      List<Order> orders = listLiveData.getValue();
        if (orders != null && orders.size() > 0) {
            return orderDao.loadAllOrders().get(new Random().nextInt(orders.size()));
        }
        return new Order();
    }

    public void loadDataUseRxJava(Context context) {
        OrderDao orderDao = AbstractAppDatabase.getInstance(context).getOrderDao();
        Flowable<Order> orderFlowable = orderDao.queryOrderUseRxJava();
        Disposable disposable = orderFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Order>() {
                    @Override
                    public void accept(@NonNull Order order) throws Exception {
                        mMutableLiveData.setValue(order);
                    }
                });
    }

    public void insertOrder(Context context) {
        OrderDao orderDao = AbstractAppDatabase.getInstance(context).getOrderDao();
        Order order = new Order();
        order.orderId = new Random().nextInt(10000);
        order.ownerName = "barryyang";
        order.ownerPhone = "18718524725";
        orderDao.insertAll(order);
    }

    public void clearData() {

    }
}
