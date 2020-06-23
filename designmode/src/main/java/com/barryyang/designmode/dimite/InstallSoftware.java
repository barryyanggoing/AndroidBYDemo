package com.barryyang.designmode.dimite;

/**
 * 迪米特法则，不要将太多的方法暴露出去
 * 迪米特法则要求类“羞涩”一点，尽量不要对外公布太多的public方法和非静态的public变量，尽量内敛，多使用private、package-private、protected等访问权限。
 */
public class InstallSoftware {

    public void install(Wizard wizard){
        wizard.installWizard();
    }
}
