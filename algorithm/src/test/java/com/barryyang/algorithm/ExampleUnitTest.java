package com.barryyang.algorithm;

import com.barryyang.algorithm.erfen_query.ErFenQuery;
import com.barryyang.algorithm.letcode.LetCode_01;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
       //erfenquery();
        //normalquery();
        //SelectionSort.sort();
       // MaoPaoSort.sort(new int[]{1,4,3});
        LetCode_01.subTarget2(new int[]{1,4,3,5,7,8},4);
    }

    private void normalquery() {
        long start1 = System.currentTimeMillis();
        int query1 = ErFenQuery.query1(19);
        long end1 = System.currentTimeMillis();
        System.out.println("普通查找，猜对了：" + query1 + "，执行时间" + (end1 - start1));
    }

    /**
     * 34052
     */
    private void erfenquery() {
        long start = System.currentTimeMillis();
        int query = ErFenQuery.query(19);
        long end = System.currentTimeMillis();
        System.out.println("二分查找，猜对了：" + query + "，执行时间" + (end - start));
    }
}