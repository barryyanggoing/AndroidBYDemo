package com.barryyang.barryyangdemo.designmodel

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.barryyang.barryyangdemo.R
import com.barryyang.barryyangdemo.designmodel.factory.abstract_factory.MaleFactory
import com.barryyang.barryyangdemo.designmodel.factory.method_factory.AbstractHumanFactory
import com.barryyang.barryyangdemo.designmodel.factory.method_factory.HumanFactory
import com.barryyang.barryyangdemo.designmodel.factory.method_factory.YellowHuman
import com.barryyang.barryyangdemo.designmodel.model.Car1
import com.barryyang.barryyangdemo.designmodel.singleton.Singleton

/**
 * @author : BarryYang
 * @date : 2020/8/22 4:16 PM
 * @desc :设计模式
 */
class DesignModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design_model)
    }

    /**
     * 单例模式
     */
    fun singletonModel(view: View) {
        Singleton.getInstance().singleMethod()
    }

    /**
     * 工厂方法模式
     */
    fun factoryModel(view: View) {
        val yellowHuman: YellowHuman = HumanFactory().createHuman(YellowHuman().javaClass)
        yellowHuman.getHumanColor()
    }

    /**
     * 抽象工厂模式
     */
    fun abstractFactoryModel(view: View) {
        val createWhiteHuman = MaleFactory().createWhiteHuman()
        createWhiteHuman.getSex()
    }

    /**
     * 模板方法模式
     */
    fun modelMethodModel(view: View) {
        val car = Car1()
        car.run()
    }

}