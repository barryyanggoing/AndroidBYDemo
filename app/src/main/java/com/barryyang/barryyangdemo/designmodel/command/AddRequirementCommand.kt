package com.barryyang.barryyangdemo.designmodel.command

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:31 PM
 * @desc :
 */
class AddRequirementCommand : Command() {

    override fun execute() {
        super.requirementGroup.find()
        super.requirementGroup.add()
        super.requirementGroup.plan()
    }
}