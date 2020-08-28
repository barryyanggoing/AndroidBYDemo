package com.barryyang.barryyangdemo.designmodel.command

/**
 * @author : BarryYang
 * @date : 2020/8/28 4:29 PM
 * @desc :
 */
abstract class Command {

    val requirementGroup = AddRequirementGroup()
    val codeGroup = CodeGroup()
    val pageGroup = PageGroup()

    abstract fun execute();
}