package com.barryyang.barryyangdemo.designmodel

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.barryyang.barryyangdemo.R
import com.barryyang.barryyangdemo.designmodel.builder.BenzCarBuilder
import com.barryyang.barryyangdemo.designmodel.command.DeletePageCommand
import com.barryyang.barryyangdemo.designmodel.command.Invoker
import com.barryyang.barryyangdemo.designmodel.factory.abstract_factory.MaleFactory
import com.barryyang.barryyangdemo.designmodel.factory.method_factory.HumanFactory
import com.barryyang.barryyangdemo.designmodel.factory.method_factory.YellowHuman
import com.barryyang.barryyangdemo.designmodel.model.Car1
import com.barryyang.barryyangdemo.designmodel.proxy.GamePlayIH
import com.barryyang.barryyangdemo.designmodel.proxy.GamePlayerImpl
import com.barryyang.barryyangdemo.designmodel.proxy.IGamePlayer
import com.barryyang.barryyangdemo.designmodel.singleton.Singleton
import com.barryyang.barryyangdemo.designmodel.yuanxing.AdvTemplate
import com.barryyang.barryyangdemo.designmodel.yuanxing.Mail
import com.barryyang.barryyangdemo.designmodel.zhongjiezhe.AbstractMediator
import com.barryyang.barryyangdemo.designmodel.zhongjiezhe.Mediator
import com.barryyang.barryyangdemo.designmodel.zhongjiezhe.Purchase
import com.barryyang.barryyangdemo.utils.LogUtil
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy

/**
 * @author : BarryYang
 * @date : 2020/8/22 4:16 PM
 * @desc :设计模式
 */
class DesignModelActivity : AppCompatActivity() {

    companion object {
        private const val MAX_COUNT = 6
        private const val TAG = "DesignModelActivity"
    }

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

    /**
     * 建造者模式
     */
    fun builderModel(view: View) {
        // TODO: 2020/8/25 这里还可以优化，将add不对外公开
        val benzCarBuilder = BenzCarBuilder()
        val list = ArrayList<String>()
        list.add("start")
        list.add("stop")
        list.add("alarm")
        list.add("engineBoom")
        benzCarBuilder.setSequence(list)
        val benzModel = benzCarBuilder.getCarModel()
        benzModel.run()

    }

    /**
     * 代理模式
     */
    fun proxyModel(view: View) {
//        自己玩
//        val iGamePlayer = GamePlayerImpl("张三")
//        iGamePlayer.login("zhangshan","123456")
//        iGamePlayer.killBoss()
//        iGamePlayer.upgrade()
//        代练
//        val gamePlayerProxyImpl = GamePlayerProxyImpl("张三")
//        gamePlayerProxyImpl.login("zhangshan", "123456")
//        gamePlayerProxyImpl.killBoss()
//        gamePlayerProxyImpl.upgrade()
//      动态代理
        val gamePlayerImpl = GamePlayerImpl("张三")
        val handler: InvocationHandler = GamePlayIH(gamePlayerImpl)
        val classLoader = gamePlayerImpl.javaClass.classLoader
        val gamePlayer = Proxy.newProxyInstance(classLoader, arrayOf<Class<*>>(IGamePlayer::class.java), handler) as IGamePlayer
        gamePlayer.login("zhangsan", "123456")
        gamePlayer.killBoss()
        gamePlayer.upgrade()
    }

    /**
     * 原型模式:这种不通过new关键字来产生一个对象，而是通过对象复制来实现的模式就叫做原型模式。
     */
    fun yuanxingModel(view: View) {
        var i = 0
        val mail = Mail(AdvTemplate())
        mail.tail = "版权归我所有。。。。"
        while (i < MAX_COUNT) {
            val copyMail = mail.clone()
            copyMail.receiver = "614994859@qq.com"
            copyMail.appellation = "ssss"
            LogUtil.printLogDebug(TAG, "${copyMail.receiver}，${copyMail.tail},发送成功")
            i++
        }
    }

    /**
     * 中介者模式
     */
    fun zhongjieModel(view: View) {
        val mediator: AbstractMediator = Mediator()
        val purchase = Purchase(mediator)
        purchase.buyIBMCompute(100)
    }

    /**
     * 命令模式
     */
    fun commandModel(view: View) {
        val invoker = Invoker()
        val deletePageCommand = DeletePageCommand()
        invoker.setCommand(deletePageCommand)
        invoker.action()
    }

}