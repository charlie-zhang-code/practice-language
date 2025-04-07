package io.github.charlie.oop.innerclass;

/**
 * @Author: charlie-zhang-code
 * @Date: 2025/3/30
 * @Description: TODO
 */
class OuterClassDemo1 {
    private static String a = "外部类的静态 a";
    private static String b = "外部类的静态 b";
    private String c = "外部类对象的非静态 c";
    private String d = "外部类对象的非静态 d";

    static class StaticInner {
        private static String a = "静态内部类的静态 a";
        private String c = "静态内部类对象的非静态 c";

        public static void inMethod() {
            System.out.println("Inner.a = " + a);
            System.out.println("Outer.a = " + OuterClassDemo1.a);
            System.out.println("b = " + b);
        }

        public void inFun() {
            System.out.println("Inner.inFun");
            System.out.println("Outer.a = " + OuterClassDemo1.a);
            System.out.println("Inner.a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
            // System.out.println("d = " + d);//不能访问外部类的非静态成员
        }
    }

    class NoStaticInner {
        private String a = "非静态内部类对象的非静态 a";
        private String c = "非静态内部类对象的非静态 c";

        public void inFun() {
            System.out.println("NoStaticInner.inFun");
            System.out.println("Outer.a = " + OuterClassDemo1.a);
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("Outer.c = " + OuterClassDemo1.this.c);
            System.out.println("c = " + c);
            System.out.println("d = " + d);
        }
    }

    public NoStaticInner getNoStaticInner() {
        return new NoStaticInner();
    }
}

public class TestMemberInnerClass {
    public static void main(String[] args) {
        //创建静态内部类实例，并调用方法
        OuterClassDemo1.StaticInner inner = new OuterClassDemo1.StaticInner();
        inner.inFun();
        //调用静态内部类静态方法
        OuterClassDemo1.StaticInner.inMethod();
        System.out.println("*****************************");

        //创建非静态内部类实例（方式 1），并调用方法
        OuterClassDemo1 outer = new OuterClassDemo1();
        OuterClassDemo1.NoStaticInner inner1 = outer.new NoStaticInner();
        inner1.inFun();
        //创建非静态内部类实例（方式 2）
        OuterClassDemo1.NoStaticInner inner2 = outer.getNoStaticInner();
        inner1.inFun();
    }
}
