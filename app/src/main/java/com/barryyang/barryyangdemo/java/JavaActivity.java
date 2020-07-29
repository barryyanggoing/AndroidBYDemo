package com.barryyang.barryyangdemo.java;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.java.model.Person;
import com.barryyang.barryyangdemo.java.model.Student;
import com.barryyang.barryyangdemo.java.model.YouthPerson;
import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/7/29 11:08 AM
 * @desc :java相关
 */
public class JavaActivity extends AppCompatActivity {

    private static final String TAG = "JavaActivity";

    /**
     * 1.==比较的是内存地址，student1和student2是两个不同的对象，因此内存地址也是不相同的。
     * 2.equal方法来自object类，但是student并没有重写equal,因此调用的还是object得equal,object的equal方法使用的是==运算符，因此返回的还是false
     *
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        //studentDemo();
        //personDemo();
        youthPersonDemo();
    }

    private void youthPersonDemo() {
        Person person1 = new Person(1, "小名");
        YouthPerson youthPerson = new YouthPerson(1, "小名",1);
        LogUtil.printLogDebug(TAG, "person1==youthPerson:" + (person1 == youthPerson));
        //YouthPerson是Person的子类 object instanceof Person为true，且userId，username都相同，固为true
        LogUtil.printLogDebug(TAG, "person1.equal(youthPerson):" + (person1.equals(youthPerson)));
        //youthPerson中equals方法object instanceof Person为false
        LogUtil.printLogDebug(TAG, "youthPerson.equal(person1):" + (youthPerson.equals(person1)));
    }

    private void personDemo() {
        Person person1 = new Person(1, "小名");
        Person person2 = new Person(1, "小名");
        LogUtil.printLogDebug(TAG, "person1==person2:" + (person1 == person2));
        LogUtil.printLogDebug(TAG, "person1.equal(person2):" + (person1.equals(person2)));
    }

    private void studentDemo() {
        Student student1 = new Student(1, "小名");
        Student student2 = new Student(1, "小名");
        LogUtil.printLogDebug(TAG, "student1==student2:" + (student1 == student2));
        LogUtil.printLogDebug(TAG, "student1.equal(student2):" + (student1.equals(student2)));
    }
}
