package io.github.charlie.oop.innerclass.de1;

interface A {
    void a();
}

public class Test {
    public static void main(String[] args) {
        A obj = new A() {
            @Override
            public void a() {
                System.out.println("aaaa");
            }
        };
        obj.a();
    }
}
