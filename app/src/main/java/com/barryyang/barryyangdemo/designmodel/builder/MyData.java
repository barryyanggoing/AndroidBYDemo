package com.barryyang.barryyangdemo.designmodel.builder;

public class MyData {

//    private int a;
//    private int b;

    public MyData(int a, int b) {
        System.out.println(a + b);
    }

    public static class MyBuilder {
        private int a;
        private int b;

        public MyBuilder setNumber(int a) {
            this.a = a;
            return this;
        }

        public MyBuilder setNumber1(int b) {
            this.b = b;
            return this;
        }

        public MyData build() {
            return new MyData(a, b);
        }
    }
}
