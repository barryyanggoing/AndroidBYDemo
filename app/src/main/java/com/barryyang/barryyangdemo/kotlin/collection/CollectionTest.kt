package com.barryyang.barryyangdemo.kotlin.collection

/**
 * @author : BarryYang
 * @date : 2020/9/10 10:52 AM
 * @desc :集合测试
 */

fun main() {
//    collection(listOf("one", "two", "three"))
//    collection(setOf("one", "two", "three"))
//    val words = "A long time ago in a galaxy far far away".split(" ")
//    val shortWords = mutableListOf<String>()
//    words.getShortWordsTo(shortWords, 3)
//    println(shortWords)
//    removeList()
//    map()
//    addList
//    filterto()
//    mapto()
//    sort()
//    associateWith()
//    joinToString()
//    elementAt()
}

fun elementAt(){
//    val numbers = linkedSetOf("one", "two", "three", "four", "five")
//    println(numbers.elementAt(3))
//    //元素以升序存储
//    val numbersSortedSet = sortedSetOf("aaa","one", "two", "three", "four")
//    numbersSortedSet.forEach{
//        println(it)
//    }
//    println(numbersSortedSet.elementAt(0))

    val numbers1 = listOf("one", "two", "three", "four", "five")
    //当指定位置超出集合范围时，elementAtOrNull() 返回 null。
    println(numbers1.elementAtOrNull(5))
    println(numbers1.elementAtOrElse(5) { index -> "The value for index $index is undefined"})
}

fun joinToString() {
    val numbers = listOf("one", "two", "three", "four")
    val joinToString = numbers.joinToString(separator = "|", limit = 3, truncated = "...")
    println(joinToString)
}

/**
 * 基本的关联函数 associateWith() 创建一个 Map，其中原始集合的元素是键，并通过给定的转换函数从中产生值。 如果两个元素相等，则仅最后一个保留在 Map 中。
 */
fun associateWith() {
    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateWith { it.length })
}

fun unzip() {
    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    val unzip = numberPairs.unzip()
    val first = unzip.first
    val second = unzip.second
    println(unzip)
}

fun zip() {
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    val list = animals zip colors
//    animals.zip(colors)
    println(list)
}

/**
 *  sort() 就地对可变集合进行排序，因此其状态发生了变化； sorted() 创建一个新集合，该集合包含按排序顺序相同的元素。
 */
fun sort() {
    val numbers = mutableListOf("one", "two", "three", "four")
    val sortedNumbers = numbers.sorted()
    println(numbers == sortedNumbers)
    numbers.sort()
    println(numbers == sortedNumbers)
}

/**
 * 3,4,5
 */
fun mapto() {
    val numbers = listOf("one", "two", "three", "four")
    // 将数字直接过滤到新的哈希集中，
    // 从而消除结果中的重复项
    val result = numbers.mapTo(HashSet()) { it.length }
    println("distinct item lengths are $result")
}

fun filterto() {
    val numbers = listOf("one", "two", "three", "four")
    val filterResults = mutableListOf<String>()
    numbers.filterTo(filterResults) { it.length > 3 }
    numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
    println(filterResults)
}

/**
 * Collection集合:只读集合,继承者List,Set
 */
fun collection(s: Collection<String>) {
    s.forEach { params ->
        println("Collection集合:${params}")
    }
}

/**
 * MutableCollection 是一个具有写操作的 Collection 接口,例如 add 以及 remove
 */
fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {
    //将长度小于等于3的字符串添加到shortWords集合中
    this.filterTo(shortWords) {
        it.length <= maxLength
    }
    //去除掉articles中元素
    val articles = setOf("a", "A", "an", "An", "the", "The")
    shortWords -= articles
}

/**
 * mutableListOf
 */
fun removeList() {
    val numberList = mutableListOf(1, 2, 3, 4)
    numberList.add(5)
    numberList.removeAt(1)
    numberList[0] = 0
    //numberList随机排序
    numberList.shuffle()
    numberList.forEach {
        println("mutableListOf:${it}")
    }
}

/**
 * map
 * 注意:to 符号创建了一个短时存活的 Pair 对象，因此建议仅在性能不重要时才使用它。
 * 为避免过多的内存使用，请使用其他方法。
 */
fun map() {
    val numberMap = mapOf("key1" to 1)
    val numberMap1 = mutableMapOf<String, String>().apply {
        this["key1"] = "1"
        this["key2"] = "2"
    }
}

/**
 * 如果你想操作这个集合，应使用 MutableList
 */
fun addList() {
    val doubled = List(3) { it * 2 }
    println(doubled)
}

fun iterator() {
    val number = listOf(1, 2, 3, 4, 5)
    val iterator = number.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }
}

/**
 * 序列
 */
fun generateSequence() {
    val oddNumbersLessThan10 = generateSequence(1) { if (it < 10) it + 2 else null }
    oddNumbersLessThan10.forEach {
        println(it)
    }
}
