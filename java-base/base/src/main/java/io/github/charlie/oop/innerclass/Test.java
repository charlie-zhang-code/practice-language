package io.github.charlie.oop.innerclass;

interface A {
    void a();
}

public class Test {
    public static void main(String[] args) {
        new A() {
            @Override
            public void a() {
                System.out.println("aaaa");
            }
        }.a();
    }
}