package com.barryyang.barryyangdemo.designmodel.command

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:31 PM
 * @desc :
 */
class DeletePageCommand:Command() {

    override fun execute() {
        super.pageGroup.find()
        super.pageGroup.delete()
        super.pageGroup.plan()
    }
}