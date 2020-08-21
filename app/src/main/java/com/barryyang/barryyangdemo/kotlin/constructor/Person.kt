package com.barryyang.barryyangdemo.kotlin.constructor

/**
 * @author : BarryYang
 * @date : 2020/8/20 3:36 PM
 * @desc :
 */
class Person(val name: String) {

    val children = mutableListOf<Person>();

    /**
     * 如果类有一个主构造函数，每个次构造函数需要委托主构造函数，可以直接委托或者通过别的次构造函数间接
     * 委托，委托到同一个类的另一个构造函数用this关键字即可。
     */
    constructor(name: String, person: Person) : this(name) {
        person.children.add(this)
    }
}