package io.github.charlie.oop.innerclass.de2;

interface A {
    void method();
}

public class Test {
    public static void test(A a) {
        a.method();
    }

    public static void main(String[] args) {
        test(new A() {
            @Override
            public void method() {
                System.out.println("aaaa");
            }
        });
    }
}
